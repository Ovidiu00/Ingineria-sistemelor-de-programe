package isp.lab4.exercise4;


import org.junit.Assert;
import org.junit.Test;

public class ControlerTest {
    @Test
    public void controlStep_AllSensorsHaveTemperatureOver50_AlarmIsActive() {
        //Arrange
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];

        temperatureSensors[0] = new TemperatureSensor(51,"Garage");
        temperatureSensors[1] = new TemperatureSensor(66,"Garage");
        temperatureSensors[2] = new TemperatureSensor(82,"Garage");

        Controler controler = new Controler(temperatureSensors,fireAlarm);

        //Act
        controler.controlStep();
        Boolean actual = fireAlarm.isActive();

        //Assert
        Assert.assertEquals("Alarm should be on",true,actual);


    }
    @Test
    public void controlStep_AtLeastOneSensorReadsTemperatureUnder50_AlarmIsInactive() {
        //Arrange
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];

        temperatureSensors[0] = new TemperatureSensor(4,"Garage");
        temperatureSensors[1] = new TemperatureSensor(66,"Garage");
        temperatureSensors[2] = new TemperatureSensor(82,"Garage");

        Controler controler = new Controler(temperatureSensors,fireAlarm);

        //Act
        controler.controlStep();
        Boolean actual = fireAlarm.isActive();

        //Assert
        Assert.assertEquals("Alarm should be off",false,actual);


    }
}
