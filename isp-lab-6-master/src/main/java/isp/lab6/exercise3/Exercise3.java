package isp.lab6.exercise3;

import java.time.LocalDateTime;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) {

        SensorsCluster sensorsCluster = new SensorsCluster();

        sensorsCluster.addSensor("1",SENSOR_TYPE.HUMIDITY);
        sensorsCluster.addSensor("2",SENSOR_TYPE.PRESSURE);
        sensorsCluster.addSensor("3",SENSOR_TYPE.TEMPERATURE);

        sensorsCluster.writeSensorReading("1",22,LocalDateTime.now());
        sensorsCluster.writeSensorReading("1",5,LocalDateTime.now());
        sensorsCluster.writeSensorReading("2",11.324,LocalDateTime.now());
        sensorsCluster.writeSensorReading("3",13.4,LocalDateTime.now());


        Sensor sensor = sensorsCluster.getSensorById("1");
        System.out.println(sensor + "\n\n");

        List<SensorReading> sortedReadings = sensor.getSensorReadingSortedByValue();

        for(SensorReading reading : sortedReadings){
            System.out.println(reading + " ");
        }


    }
}
