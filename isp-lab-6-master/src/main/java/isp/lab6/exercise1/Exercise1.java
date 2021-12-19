package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        IReadingRepository readingRepository = new ReadingRepository();

        SensorReading reading1 = new SensorReading(14, "Cluj", Type.HUMIDITY);
        SensorReading reading2 = new SensorReading(20, "Cluj", Type.PRESSURE);
        SensorReading reading3 = new SensorReading(21, "Cluj", Type.TEMPERATURE);
        SensorReading reading4 = new SensorReading(14, "Zalau", Type.HUMIDITY);
        SensorReading reading5 = new SensorReading(14, "Baia Mare", Type.PRESSURE);

        readingRepository.addReading(reading1);
        readingRepository.addReading(reading2);
        readingRepository.addReading(reading3);
        readingRepository.addReading(reading4);
        readingRepository.addReading(reading5);

        List<SensorReading> readings = readingRepository.getReadingsByType(Type.HUMIDITY);
        for (SensorReading reading : readings) {
            System.out.println(reading.toString());
        }

        System.out.println(readingRepository.getAvarageValueByType(Type.PRESSURE, "Cluj"));

        readingRepository.listSortedByValue();

        readings = readingRepository.getReadingsByType(Type.PRESSURE);
        for (SensorReading reading : readings) {
            System.out.println(reading.toString());
        }

    }

}
