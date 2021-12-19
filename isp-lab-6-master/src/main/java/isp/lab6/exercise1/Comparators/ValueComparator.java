package isp.lab6.exercise1.Comparators;

import isp.lab6.exercise1.SensorReading;

import java.util.Comparator;

public class ValueComparator implements Comparator<SensorReading> {
    @Override
    public int compare(SensorReading o1, SensorReading o2) {
        if(o1.getValue() == o2.getValue()){
            return  0;
        }
        if(o1.getValue() > o2.getValue()){
            return  1;
        }
        else
            return  -1;
    }
}
