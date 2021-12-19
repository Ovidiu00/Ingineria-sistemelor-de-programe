package isp.lab8.carparkaccess;

import Configuration.FolderConfiguration;
import Configuration.ParkSystemConfiguration;
import Controller.ParkSystemController;
import Infrastructure.*;
import Models.Administrator;
import Models.Car;
import Models.Driver;
import Models.Person;
import Services.AdminService;
import Services.IAdminService;
import Services.ITrackingCarsService;
import Services.TrackingCarsService;

import Utilities.FilesAndFolderUtil;


import java.util.concurrent.TimeUnit;

public class CarParkingAccessApp {
    public static void main(String[] args) throws Exception {

        //Using serializable

        FolderConfiguration.set_ParkingLotfolderName("Parking");
        FolderConfiguration.set_LogsfolderName("Logs");
        ParkSystemConfiguration.setMaximumSpaces(10);

        FilesAndFolderUtil.createFolder(FolderConfiguration.get_ParkingLotfolderName());
        FilesAndFolderUtil.createFolder(FolderConfiguration.get_LogsfolderName());


        ICarParkRepository carParkRepository = new CarFileSerializeRepository();
        ITrackingCarsService trackingCarsService = new TrackingCarsService(carParkRepository);

        ILogRepository logRepository = new LogFileSerializeRepository();

        IAdminService adminService = new AdminService(carParkRepository,trackingCarsService,logRepository);




        Car car1 = new Car("11111");
        Car car2 = new Car("22222");
        Car car3 = new Car("33333");
        Person driver = new Driver("Marcel","Iacob");
        Person administrator = new Administrator("Sergiu","Coroi");



        ParkSystemController controller = new ParkSystemController(trackingCarsService,adminService,logRepository);



       controller.EnterCarPark(car1);
        controller.EnterCarPark(car2);

        TimeUnit.SECONDS.sleep(5);
        controller.ExitCarPark(car1);



        controller.EnterCarPark(car3);
        TimeUnit.SECONDS.sleep(3);

        controller.EnterCarPark(car1);
        controller.ExitCarPark(car3);

        TimeUnit.SECONDS.sleep(3);

        controller.ExitCarPark(car2);
        controller.ExitCarPark(car1);


        controller.EnterCarPark(car2);



        controller.ViewCurrentParkedCars(administrator);
        controller.ViewAllPastEntriesForCar(car1,administrator);
        controller.ViewUniqueEntries(administrator);


        //Using JSON serialization

        FolderConfiguration.set_ParkingLotfolderName("Parking_json");
        FolderConfiguration.set_LogsfolderName("Logs_json");
        //ParkSystemConfiguration.setMaximumSpaces(10);

        FilesAndFolderUtil.createFolder(FolderConfiguration.get_ParkingLotfolderName());
        FilesAndFolderUtil.createFolder(FolderConfiguration.get_LogsfolderName());


        ICarParkRepository carParkRepository_json = new CarFileJsonRepository();
        ITrackingCarsService trackingCarsService_json = new TrackingCarsService(carParkRepository_json);

        ILogRepository logRepository_json = new LogFileJsonRepository();

        IAdminService adminService_json = new AdminService(carParkRepository_json,trackingCarsService_json,logRepository_json);




        controller = new ParkSystemController(trackingCarsService_json,adminService_json,logRepository_json);



       controller.EnterCarPark(car1);
        controller.EnterCarPark(car2);

        TimeUnit.SECONDS.sleep(5);
        controller.ExitCarPark(car1);



        controller.EnterCarPark(car3);
        TimeUnit.SECONDS.sleep(3);

        controller.EnterCarPark(car1);
        controller.ExitCarPark(car3);

        TimeUnit.SECONDS.sleep(3);

        controller.ExitCarPark(car2);
        controller.ExitCarPark(car1);


        controller.EnterCarPark(car2);



        controller.ViewCurrentParkedCars(administrator);
        controller.ViewAllPastEntriesForCar(car1,administrator);
        controller.ViewUniqueEntries(administrator);
    }
}
