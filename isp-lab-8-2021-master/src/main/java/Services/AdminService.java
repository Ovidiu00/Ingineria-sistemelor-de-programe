package Services;

import Infrastructure.ICarParkRepository;
import Infrastructure.ILogRepository;
import Models.Car;
import Models.PARKROLE;
import Models.ParkLog;
import ViewModels.CarRecordViewModel;
import ViewModels.ParkedCarViewModel;
import ViewModels.PastEntriesCarViewModel;
import ViewModels.UniqueEntryCarViewModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService implements IAdminService {

    private final ICarParkRepository carParkRepository;
    private final ITrackingCarsService trackingCarsService;
    private final ILogRepository logRepository;


    public AdminService(ICarParkRepository carParkRepository, ITrackingCarsService trackingCarsService, ILogRepository logRepository) {
        this.carParkRepository = carParkRepository;
        this.trackingCarsService = trackingCarsService;
        this.logRepository = logRepository;
    }

    @Override
    public List<ParkedCarViewModel> returnParkedCars() {

        List<ParkedCarViewModel> result = new ArrayList<>();
        for (CarRecordViewModel model : carParkRepository.readAllItems()) {

            long currentCost = trackingCarsService.CalculateUsageCost(model.entryTime, LocalDateTime.now());

            ParkedCarViewModel parkedCarViewModel = new ParkedCarViewModel(model.getLicensePlate(), model.entryTime, currentCost);
            result.add(parkedCarViewModel);
        }

        return result;
    }

    @Override
    public List<PastEntriesCarViewModel> returnPastEntriesForCar(Car car) {

        List<PastEntriesCarViewModel> result = new ArrayList<>();

        long nrOfEntries = logRepository.readAllLogs().stream().filter(log -> log.getLicensePlate().equals(car.getLicensePlate())).count();

        for (ParkLog item : logRepository.readAllLogs().stream().filter(log -> log.getLicensePlate().equals(car.getLicensePlate())).collect(Collectors.toList())) {

            long cost = trackingCarsService.CalculateUsageCost(item.getEntryTime(), item.getExitTime());
            PastEntriesCarViewModel model = new PastEntriesCarViewModel(item.getLicensePlate(), cost, cost, item.getEntryTime());

            result.add(model);
        }

        System.out.println("Number of entries for this car : " + nrOfEntries);

        return result;
    }

    @Override
    public List<UniqueEntryCarViewModel> returnUniquePastEntries() {

        List<UniqueEntryCarViewModel> result = new ArrayList<>();

        for (ParkLog _log : logRepository.readAllLogs().stream().distinct().collect(Collectors.toList())) {

            int nrEntries = (int)logRepository.readAllLogs().stream().filter(log -> log.getLicensePlate().equals(_log.getLicensePlate())).count();

            UniqueEntryCarViewModel model = new UniqueEntryCarViewModel(_log.getLicensePlate(), nrEntries);

            result.add(model);
        }
        return result;
    }


}
