package ViewModels;

import Models.Car;

import java.time.LocalDateTime;

public class ParkedCarViewModel extends Car {
    public LocalDateTime entryTime;
    public long currentCost;

    public ParkedCarViewModel(String licensePlate, LocalDateTime entryTime, long currentCost) {
       super(licensePlate);
        this.entryTime = entryTime;
        this.currentCost = currentCost;
    }

    @Override
    public String toString() {
        return "ParkedCarViewModel{" +
                "entryTime=" + entryTime +
                ", currentCost=" + currentCost +
                ", licensePlate=" + super.getLicensePlate() +
                '}';
    }
}
