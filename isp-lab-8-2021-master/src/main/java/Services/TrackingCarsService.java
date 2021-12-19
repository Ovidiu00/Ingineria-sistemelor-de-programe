package Services;

import Configuration.FolderConfiguration;
import Configuration.ParkSystemConfiguration;
import Infrastructure.ICarParkRepository;
import Utilities.FilesAndFolderUtil;
import ViewModels.CarRecordViewModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class TrackingCarsService implements  ITrackingCarsService{
    private final ICarParkRepository carParkRepository;

    public TrackingCarsService(ICarParkRepository carParkRepository) {
        this.carParkRepository = carParkRepository;
    }

    @Override
    public int CountOfCarsCurrentlyParked() {
        return (int) carParkRepository.readAllItems().stream().count();
    }

    @Override
    public int CheckSpaceAvaibility() {
        int foo = ParkSystemConfiguration.getMaximumSpaces() - this.CountOfCarsCurrentlyParked();

        return  foo;
    }


    @Override
    public boolean CheckPlateExistance(String plate) {
        Optional<CarRecordViewModel> record;

        try {
             record = carParkRepository.readAllItems().stream().filter(item -> item.getLicensePlate().equals(plate) && item.exitTime == null).findFirst();
        }
        catch (NullPointerException e){
            return  false;
        }

       if(record.isPresent()){
           return true;
       }
       return  false;
    }

    @Override
    public void addNewRecord(CarRecordViewModel model) {
        try{
            carParkRepository.addItem(model);
        }
        catch (Exception e){

        }

    }

    @Override
    public Optional<CarRecordViewModel> FindParkedCarByPlateNumber(String plate) {
        try {

            Optional<CarRecordViewModel> foo = carParkRepository.readAllItems().stream().filter(item -> item.getLicensePlate().equals(plate) && item.exitTime == null).findFirst();

            return  foo;

        }
        catch (NullPointerException e){
            return  Optional.ofNullable(null);
        }
    }

    @Override
    public String getFileNameOfCarCurrentlyParked(String plate) {

        for(String fileName : FilesAndFolderUtil.getFilesInFolder(FolderConfiguration.get_ParkingLotfolderName())){
            CarRecordViewModel record = carParkRepository.readItem(fileName);

            if(record.exitTime == null && record.getLicensePlate().equals(plate))
                return fileName;
        }
        return  null;
    }
    public long CalculateUsageCost(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);

        return duration.getSeconds();
    }
}
