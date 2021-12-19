package Models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ParkLog implements Serializable {
    private LocalDateTime entryTime;
    private  LocalDateTime exitTime;
    private String licensePlate;
    private long cost;

    public ParkLog(LocalDateTime entryTime, LocalDateTime exitTime, String licensePlate,long cost) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.licensePlate = licensePlate;
        this.cost = cost;
    }

    public ParkLog() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getCost() {
        return cost;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkLog log = (ParkLog) o;
        return licensePlate.equals(log.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }
}
