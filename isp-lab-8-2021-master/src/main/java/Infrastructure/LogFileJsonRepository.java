package Infrastructure;

import Configuration.FolderConfiguration;
import Models.ParkLog;
import Utilities.FilesAndFolderUtil;
import ViewModels.CarRecordViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LogFileJsonRepository implements ILogRepository {
    private final ObjectMapper objectMapper;
    private String folderName;

    public LogFileJsonRepository() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        this.folderName = FolderConfiguration.get_LogsfolderName();
    }

    @Override
    public void addLog(ParkLog log) {

        try {
            String fileName = log.getLicensePlate() + "_" + new Random().nextInt(1000) + ".dat";

            objectMapper.writeValue(new File(folderName + "\\" + fileName), log);
        } catch (Exception e) {
            Logger.getLogger(LogFileJsonRepository.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<ParkLog> readAllLogs() {
        List<ParkLog> items = new ArrayList<>();

        for (String fileName : FilesAndFolderUtil.getFilesInFolder(folderName)) {
            ParkLog item = this.readLog(fileName);

            items.add(item);
        }

        return items;
    }

    @Override
    public ParkLog readLog(String fileName) {
        String jsonContent = null;
        ParkLog model = null;


        try {
            jsonContent = FilesAndFolderUtil.readAllFileLines(folderName + "\\" + fileName)
                    .stream().collect(Collectors.joining("\n"));

            model = objectMapper.readValue(jsonContent, ParkLog.class);
        } catch (IOException e) {
            Logger.getLogger(LogFileJsonRepository.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(LogFileJsonRepository.class.getName()).log(Level.SEVERE, null, e);
        }

        return model;
    }
}
