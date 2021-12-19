package isp.lab4.exercise3;

import isp.lab4.exercise3.TemperatureSensor;
import org.junit.Assert;
import org.junit.Test;

public class TemperatureSensorTest {

    @Test
    public void GetLocation_ValidLocationInConstructor_ReturnsLocationGivenInConstructor()
    {
        //Arange
        String expectedLocation = "Garage";
        isp.lab4.exercise3.TemperatureSensor temperatureSensor = new isp.lab4.exercise3.TemperatureSensor(1,expectedLocation);

        //Act
        String actualLocation = temperatureSensor.getLocation();

        //Assert

        Assert.assertEquals("Location should be Garage",expectedLocation,actualLocation);

    }
    @Test
    public void GetValue_ValidValueInConstructor_ReturnsValueGivenInConstructor()
    {
        //Arange
        int expectedValue = 10;
        isp.lab4.exercise3.TemperatureSensor temperatureSensor = new TemperatureSensor(expectedValue,"");

        //Act
        int actualValue = temperatureSensor.getValue();

        //Assert

        Assert.assertEquals("Value should be 10",expectedValue,actualValue);

    }
}
