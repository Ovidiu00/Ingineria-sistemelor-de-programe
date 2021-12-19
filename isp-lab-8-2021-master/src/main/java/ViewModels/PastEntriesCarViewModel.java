package ViewModels;

import Models.Car;

import java.time.LocalDateTime;

public class PastEntriesCarViewModel extends Car {
    LocalDateTime entryTime;
    long totalStaySeconds;
    long totalCost;


    public PastEntriesCarViewModel(String plate, long totalStaySeconds, long totalCost,LocalDateTime entryTime) {
        super(plate);
        this.totalCost = totalCost;
        this.entryTime = entryTime;
        this.totalStaySeconds = totalStaySeconds;
    }

    @Override
    public String toString() {
        return "PastEntriesCarViewModel{" +
                "entryTime=" + entryTime +
                ", totalStaySeconds=" + totalStaySeconds +
                ", totalCost=" + totalCost +
                ", plate= " + super.getLicensePlate() +
                '}';
    }
}
