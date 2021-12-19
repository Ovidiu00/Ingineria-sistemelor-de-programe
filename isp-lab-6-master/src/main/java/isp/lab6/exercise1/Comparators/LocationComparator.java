package isp.lab6.exercise1.Comparators;



import isp.lab6.exercise1.SensorReading;

import java.util.Comparator;

public class LocationComparator implements Comparator<SensorReading> {

    @Override
    public int compare(SensorReading o1, SensorReading o2) {
        return o1.getLocation().compareTo(o2.getLocation());
    }
}
