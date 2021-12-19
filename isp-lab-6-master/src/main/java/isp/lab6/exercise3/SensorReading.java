package isp.lab6.exercise3;

import java.time.LocalDateTime;

public class SensorReading implements Comparable {
    private LocalDateTime dateAndTime;
    private double value;

    public SensorReading(LocalDateTime dateAndTime, double value) {
        this.dateAndTime = dateAndTime;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "dateAndTime=" + dateAndTime +
                ", value=" + value +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        SensorReading obj = (SensorReading) o;
        return dateAndTime.compareTo(obj.dateAndTime);
    }

    public double getValue() {
        return value;
    }
}
