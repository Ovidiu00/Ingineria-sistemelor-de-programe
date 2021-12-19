package Controller;

import Configuration.FolderConfiguration;
import Exceptions.CarCannotBeFoundException;
import Exceptions.ParkIsFullException;
import Exceptions.SamePlateAlreadyParketException;
import Exceptions.UnauthorizedAccessException;
import Infrastructure.ILogRepository;
import Models.Car;
import Models.PARKROLE;
import Models.ParkLog;
import Models.Person;
import Services.IAdminService;
import Services.ITrackingCarsService;

import ViewModels.CarRecordViewModel;
import ViewModels.ParkedCarViewModel;
import ViewModels.PastEntriesCarViewModel;
import ViewModels.UniqueEntryCarViewModel;

import java.io.File;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public final class ParkSystemController {


    private final ITrackingCarsService carsService;
    private final IAdminService adminService;
    private final ILogRepository logRepository;



    public  ParkSystemController(ITrackingCarsService carsService, IAdminService adminService, ILogRepository logRepository) {
        this.carsService = carsService;
        this.adminService = adminService;
        this.logRepository = logRepository;
    }


    public void EnterCarPark(Car car) throws Exception {
        if (carsService.CheckPlateExistance(car.getLicensePlate()) == false) {
            if (carsService.CheckSpaceAvaibility() > 0) {
                carsService.addNewRecord(new CarRecordViewModel(car.getLicensePlate(), LocalDateTime.now(), null));

            } else {
                throw new ParkIsFullException();
            }

        } else {
            throw new SamePlateAlreadyParketException(car.getLicensePlate());
        }
    }


    public void ExitCarPark(Car car) throws Exception {

        Optional<CarRecordViewModel> entryRecord = carsService.FindParkedCarByPlateNumber(car.getLicensePlate());
        if (entryRecord.isPresent() == false) {
            throw new CarCannotBeFoundException(car.getLicensePlate());
        }

        long cost = carsService.CalculateUsageCost(entryRecord.get().entryTime, LocalDateTime.now());
        ParkLog log = new ParkLog(entryRecord.get().entryTime, LocalDateTime.now(), car.getLicensePlate(), cost);

        logRepository.addLog(log);


        String carRecordToBeDeleted = carsService.getFileNameOfCarCurrentlyParked(car.getLicensePlate());
        File file = new File(FolderConfiguration.get_ParkingLotfolderName() + "\\" + carRecordToBeDeleted);

        file.delete();
    }


    public void ViewCurrentParkedCars(Person person) throws Exception {

        if (person.GetParkRole().equals(PARKROLE.Driver)) {
            throw new UnauthorizedAccessException(person,"ViewCurrentParkedCars");
        }

        List<ParkedCarViewModel> currentParkedCars = adminService.returnParkedCars();

        System.out.println("Current parked cars : \n");
        for (ParkedCarViewModel car : currentParkedCars) {
            System.out.println(car + "\n");
        }
        System.out.println("\n Free spaces in the parking lot : \n");

        System.out.println(carsService.CheckSpaceAvaibility());

    }

    public void ViewAllPastEntriesForCar(Car car,Person person)  throws Exception{
        if (person.GetParkRole().equals(PARKROLE.Driver)) {
            throw new UnauthorizedAccessException(person,"ViewAllPastEntriesForCar");
        }

        List<PastEntriesCarViewModel> pastEntries = adminService.returnPastEntriesForCar(car);

        for(PastEntriesCarViewModel viewModel : pastEntries){
            System.out.println(viewModel + "\n");
        }

    }
    public void ViewUniqueEntries(Person person)  throws Exception{
        if (person.GetParkRole().equals(PARKROLE.Driver)) {
            throw new UnauthorizedAccessException(person,"ViewUniqueEntries");
        }

        List<UniqueEntryCarViewModel> uniqueEntryCarViewModels = adminService.returnUniquePastEntries();

        System.out.println("Unique cars that entered to  parking log! \n");
        for(UniqueEntryCarViewModel carViewModel : uniqueEntryCarViewModels){
            System.out.println(carViewModel + "\n");
        }

    }
}
