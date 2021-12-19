package isp.lab6.exercise3;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class SensorsClusterTest {

    @Test
    public void addSensor_NewSensorAdded_TheAddedSensorShouldExistInSensorColection(){

        //Arrange
        SensorsCluster sensorsCluster = new SensorsCluster();

        //Act
        sensorsCluster.addSensor("1",SENSOR_TYPE.TEMPERATURE);

        //Assert
        Assert.assertNotNull("Should be different than null",sensorsCluster.getSensorById("1"));

    }
    @Test
    public void writeSensorReading_NewReadingAdded_InformationShouldBeFoundInSensor(){

        //Arrange
        SensorsCluster sensorsCluster = new SensorsCluster();
        sensorsCluster.addSensor("1",SENSOR_TYPE.TEMPERATURE);
        Sensor sensor = sensorsCluster.getSensorById("1");

        //Act
        sensorsCluster.writeSensorReading("1",14.0, LocalDateTime.now());

        //Assert
        Assert.assertEquals("Value should be 14.0",14.0,sensor.getSensorReadingSortedByValue().stream().findFirst().get().getValue(),0.001);

    }
}
