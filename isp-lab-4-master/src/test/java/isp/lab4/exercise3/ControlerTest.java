package isp.lab4.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class ControlerTest {
    @Test
    public void controlStep_TemperatureOver50_AlarmIsActive() {
        //Arrange
        FireAlarm fireAlarm = new FireAlarm(false);
        Controler controler = new Controler(new TemperatureSensor(51, "Room"), fireAlarm);


        //Act
        controler.controlStep();
        Boolean actual = fireAlarm.isActive();

        //Assert
        Assert.assertEquals("Alarm should be on",true,actual);


    }
}
