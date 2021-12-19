package Infrastructure;

import Configuration.FolderConfiguration;
import Utilities.FilesAndFolderUtil;
import ViewModels.CarRecordViewModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class CarFileJsonRepository implements ICarParkRepository {
    private ObjectMapper objectMapper;
    private String folderName;

    public CarFileJsonRepository() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


        this.folderName = FolderConfiguration.get_ParkingLotfolderName();
    }

    @Override
    public void addItem(CarRecordViewModel item) throws Exception {
        String fileName = item.getLicensePlate() + "_" + new Random().nextInt(1000) + ".dat";

        objectMapper.writeValue(new File(folderName + "\\" + fileName), item);
    }

    @Override
    public List<CarRecordViewModel> readAllItems() {
        List<CarRecordViewModel> items = new ArrayList<>();


        for (String fileName : FilesAndFolderUtil.getFilesInFolder(folderName)) {

            CarRecordViewModel item = this.readItem(fileName);


            if (item != null)
                items.add(item);
        }

        return items;
    }

    @Override
    public CarRecordViewModel readItem(String fileName) {
        String jsonContent;
        CarRecordViewModel model = null;


        try {
            jsonContent = FilesAndFolderUtil.readAllFileLines(folderName + "\\" + fileName)
                    .stream().collect(Collectors.joining("\n"));

            model = objectMapper.readValue(jsonContent, CarRecordViewModel.class);
        } catch (IOException e) {

            Logger.getLogger(CarFileSerializeRepository.class.getName()).log(Level.SEVERE, e.getMessage(), e);
           return model;
        } catch (Exception e) {
            Logger.getLogger(CarFileSerializeRepository.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return  model;
        }

        return model;

    }
}
