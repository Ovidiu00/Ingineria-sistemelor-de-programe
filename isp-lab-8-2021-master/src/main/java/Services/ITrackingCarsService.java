package Services;

import ViewModels.CarRecordViewModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ITrackingCarsService {
    /**
     Check the left space in the parking lot
     @return number of spaces left
     */
    int CheckSpaceAvaibility();
    /**
     Checks the existance of a car with the same license plate in the parking lot
     @return true if there is a matching plate, false otherwise
     */
    boolean CheckPlateExistance(String plate);
    /**
     @return Number of cars currently parked
     */
    int CountOfCarsCurrentlyParked();
    /**
     Adds a new file record in the specified parking folder via configuration
     */
    void addNewRecord(CarRecordViewModel model);
    /**
    Finds the car with the matching license plate
     @param plate the license plate to search for
     @return the car corresponding the plate or an optional empty
     */
    Optional<CarRecordViewModel> FindParkedCarByPlateNumber(String plate);
    /**
     Finds the fileName of the car with the matching license plate
     @param plate the license plate to search for
     @return name of the file
     */
    String getFileNameOfCarCurrentlyParked(String plate);
    /**
    Calculates the cost of parking based on formula 1 SECOND = 1 CURRENCY

     @return total cost of the given time window
     */
    long CalculateUsageCost(LocalDateTime entryTime, LocalDateTime exitTime);




}
