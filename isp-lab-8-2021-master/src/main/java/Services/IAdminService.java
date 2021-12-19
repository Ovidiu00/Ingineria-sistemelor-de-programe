package Services;

import Models.Car;
import ViewModels.ParkedCarViewModel;
import ViewModels.PastEntriesCarViewModel;
import ViewModels.UniqueEntryCarViewModel;

import java.util.List;

public interface IAdminService {
    List<ParkedCarViewModel> returnParkedCars();
    List<PastEntriesCarViewModel> returnPastEntriesForCar(Car car);
    List<UniqueEntryCarViewModel> returnUniquePastEntries();




}
