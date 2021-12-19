package isp.lab6.exercise1;

import isp.lab6.exercise1.Comparators.LocationComparator;
import isp.lab6.exercise1.Comparators.ValueComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadingRepository implements IReadingRepository {
    private List<SensorReading> sensorReadings = new ArrayList<>();

    @Override
    public void addReading(SensorReading reading) {
        sensorReadings.add(reading);
    }

    @Override
    public double getAvarageValueByType(Type type, String location) {
        double sum = 0.0;
        int nr = 0;

        for (SensorReading reading : sensorReadings) {
            if (reading.getType().equals(type) && reading.getLocation().equals(location)) {
                sum += reading.getValue();
                nr++;
            }
        }

        return sum / nr;
    }

    @Override
    public List<SensorReading> getReadingsByType(Type type) {
        List<SensorReading> queryResult = new ArrayList<>();

        for (SensorReading reading : sensorReadings) {
            if (reading.getType().equals(type)) {
                queryResult.add(reading);
            }
        }

        return queryResult;
    }



    @Override
    public void listSortedByLocation() {

        Collections.sort(sensorReadings,new LocationComparator());
    }

    @Override
    public void listSortedByValue() {

        Collections.sort(sensorReadings,new ValueComparator());

    }

    @Override
    public List<SensorReading> findAllByLocationAndType(String location, Type type) {
        List<SensorReading> queryResult = new ArrayList<>();

        for (SensorReading reading : sensorReadings) {
            if (reading.getType().equals(type) && reading.getLocation().equals(location)) {
                queryResult.add(reading);
            }
        }

        return queryResult;
    }
}
