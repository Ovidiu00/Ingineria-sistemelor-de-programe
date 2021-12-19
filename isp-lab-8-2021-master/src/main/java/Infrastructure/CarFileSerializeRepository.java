package Infrastructure;

import Configuration.FolderConfiguration;
import Utilities.FilesAndFolderUtil;
import ViewModels.CarRecordViewModel;
import ViewModels.ParkedCarViewModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarFileSerializeRepository implements ICarParkRepository{

    private String folderName;

    public CarFileSerializeRepository() {
        this.folderName = FolderConfiguration.get_ParkingLotfolderName();
    }

    @Override
    public CarRecordViewModel readItem(String fileName) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(folderName + "\\" + fileName))) {
            return (CarRecordViewModel) in.readObject();
        }
        catch (Exception e){

            Logger.getLogger(CarFileSerializeRepository.class.getName()).log(Level.SEVERE, null, e);
        }


        return  null;
    }

    @Override
    public void addItem(CarRecordViewModel item) {
        String fileName  = item.getLicensePlate() + "_" + new Random().nextInt(1000) +".dat";

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(folderName + "\\" + fileName))) {
            os.writeObject(item);
        }
        catch (IOException e){
            Logger.getLogger(CarFileSerializeRepository.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<CarRecordViewModel> readAllItems() {

        List<CarRecordViewModel> items = new ArrayList<>();

        for(String fileName : FilesAndFolderUtil.getFilesInFolder(folderName)){
            CarRecordViewModel item = this.readItem(fileName);

            items.add(item);
        }

        return  items;
    }
}
