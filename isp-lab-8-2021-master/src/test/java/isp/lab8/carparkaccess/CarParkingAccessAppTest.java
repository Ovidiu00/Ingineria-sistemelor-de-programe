package isp.lab8.carparkaccess;

import Configuration.FolderConfiguration;
import Configuration.ParkSystemConfiguration;
import Controller.ParkSystemController;
import Infrastructure.CarFileJsonRepository;
import Infrastructure.ICarParkRepository;
import Infrastructure.ILogRepository;
import Infrastructure.LogFileJsonRepository;
import Models.Car;
import Models.ParkLog;
import Services.AdminService;
import Services.IAdminService;
import Services.ITrackingCarsService;
import Services.TrackingCarsService;
import Utilities.FilesAndFolderUtil;
import ViewModels.CarRecordViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class CarParkingAccessAppTest {
    ParkSystemController controller;
    ICarParkRepository carParkRepository_json;
    ILogRepository logRepository_json;

    @Before
    public void instantiateDoorController() {

        FolderConfiguration.set_ParkingLotfolderName("TEST_Parking_json");
        FolderConfiguration.set_LogsfolderName("TEST_Logs_json");
        ParkSystemConfiguration.setMaximumSpaces(10);

        FilesAndFolderUtil.createFolder(FolderConfiguration.get_ParkingLotfolderName());
        FilesAndFolderUtil.createFolder(FolderConfiguration.get_LogsfolderName());


        carParkRepository_json = new CarFileJsonRepository();
        ITrackingCarsService trackingCarsService_json = new TrackingCarsService(carParkRepository_json);

         logRepository_json = new LogFileJsonRepository();

        IAdminService adminService_json = new AdminService(carParkRepository_json, trackingCarsService_json, logRepository_json);


        controller = new ParkSystemController(trackingCarsService_json, adminService_json, logRepository_json);
    }

    @Test
    public void EnterCarPark_carEntersPark_fileCanBeFoundInFolder() throws Exception {
        //Arrange
        Car expectedCar = new Car("1111");

        //Act
        controller.EnterCarPark(expectedCar);

        //Assert
        CarRecordViewModel record = carParkRepository_json.readAllItems().stream().findFirst().get();;

        Assert.assertEquals(expectedCar.getLicensePlate(), record.getLicensePlate());

        controller.ExitCarPark(expectedCar);
    }
    @Test
    public void ExitCarPark_carExitsPark_fileIsDeletedFromFolder() throws Exception {
        //Arrange
        Car carToBeExited = new Car("1111");

        //Act
        controller.EnterCarPark(carToBeExited);
        controller.ExitCarPark(carToBeExited);

        //Assert
        List<String> fileNames = FilesAndFolderUtil.getFilesInFolder(FolderConfiguration.get_ParkingLotfolderName());

        Assert.assertEquals(0,fileNames.size());
    }
    @Test
    public void ExitCarPark_carExitsPark_LogFileIsCreated() throws Exception {
        //Arrange
        File logFolder = new File(FolderConfiguration.get_LogsfolderName());
        this.deleteFolder(logFolder);

        FilesAndFolderUtil.createFolder(FolderConfiguration.get_LogsfolderName());


        Car carToBeExited = new Car("1111");

        //Act
        controller.EnterCarPark(carToBeExited);
        controller.ExitCarPark(carToBeExited);

        //Assert
        ParkLog log = logRepository_json.readAllLogs().stream().findFirst().get();
        Assert.assertEquals(carToBeExited.getLicensePlate(),log.getLicensePlate());


    }

    private  void deleteFolder(File folder){
        if(folder.list().length == 0){
            folder.delete();
            System.out.println("aici");
            return;
        }
        for(String file : folder.list()){
            File fileToBeDeleted = new File(FolderConfiguration.get_LogsfolderName() + "\\" + file);

            fileToBeDeleted.delete();
        }
        folder.delete();


    }

}
