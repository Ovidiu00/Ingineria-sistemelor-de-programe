package Infrastructure;

import Configuration.FolderConfiguration;
import Models.ParkLog;
import Utilities.FilesAndFolderUtil;
import ViewModels.CarRecordViewModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogFileSerializeRepository implements ILogRepository {

    private String folderName;

    public LogFileSerializeRepository() {
        this.folderName = FolderConfiguration.get_LogsfolderName();
    }

    @Override
    public ParkLog readLog(String fileName) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(folderName + "\\" + fileName))) {
            return (ParkLog) in.readObject();
        }
        catch (Exception e){

        }
        return  null;
    }

    @Override
    public void addLog(ParkLog log) {
        String fileName = "log_" + new Random().nextInt(1000) + "_" + log.getLicensePlate() +".dat";
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(folderName + "\\" + fileName))) {
            os.writeObject(log);
        }
        catch (Exception e){

        }
    }

    @Override
    public List<ParkLog> readAllLogs() {

        List<ParkLog> items = new ArrayList<>();

        for(String fileName : FilesAndFolderUtil.getFilesInFolder(folderName)){
            ParkLog item = this.readLog(fileName);

            items.add(item);
        }

        return  items;
    }

}
