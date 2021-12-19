package Infrastructure;

import ViewModels.CarRecordViewModel;
import ViewModels.ParkedCarViewModel;

import java.util.List;

public interface ICarParkRepository {
    void addItem(CarRecordViewModel item) throws Exception;
    List<CarRecordViewModel> readAllItems();
    CarRecordViewModel readItem(String fileName);

}
