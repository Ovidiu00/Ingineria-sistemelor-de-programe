package isp.lab6.exercise3;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class SensorTest {

    @Test

    public void getSensorReadingSortedByValue_Test(){

        //Arrange
        SensorsCluster sensorsCluster = new SensorsCluster();

        sensorsCluster.addSensor("1",SENSOR_TYPE.HUMIDITY);


        sensorsCluster.writeSensorReading("1",22, LocalDateTime.now());
        sensorsCluster.writeSensorReading("1",5,LocalDateTime.now());

        Sensor sensor = sensorsCluster.getSensorById("1");

        //Act

       List<SensorReading> sortedReadings =  sensor.getSensorReadingSortedByValue();

        //Assert

        Assert.assertEquals("First reading should have value 5",5,sortedReadings.stream().findFirst().get().getValue(),0.01);
    }
}
