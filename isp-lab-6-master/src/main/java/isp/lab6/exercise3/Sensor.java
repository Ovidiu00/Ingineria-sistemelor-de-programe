package isp.lab6.exercise3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sensor implements Comparator<SensorReading> {
    private List<SensorReading> readings = new ArrayList<>();


    private SENSOR_TYPE SENSOR_TYPE;
    private int id;

    public Sensor(isp.lab6.exercise3.SENSOR_TYPE SENSOR_TYPE, int id) {
        this.SENSOR_TYPE = SENSOR_TYPE;
        this.id = id;
    }

    public List<SensorReading> getSensorReadingSortedByDateAndTime() {


        Collections.sort(readings);

        return readings;

    }

    public List<SensorReading> getSensorReadingSortedByValue() {

        Collections.sort(readings, this);

        return readings;

    }

    public boolean addSensorReading(SensorReading sr) {

        readings.add(sr);

        return true;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Sensor{" +
                "readings=" + readings +
                ", SENSOR_TYPE=" + SENSOR_TYPE +
                ", id=" + id +
                '}';
    }

    @Override
    public int compare(SensorReading o1, SensorReading o2) {

        if (o1.getValue() == o2.getValue()) {
            return 0;
        }
        if (o1.getValue() > o2.getValue()) {
            return 1;
        } else
            return -1;
    }
}
