package isp.lab4.exercise3;

import isp.lab4.exercise3.FireAlarm;
import org.junit.Assert;
import org.junit.Test;

public class FireAlarmTest {

    @Test
    public void IsActive_SettingAlarmActive_ReturnsTrue(){
        //Arrange
        isp.lab4.exercise3.FireAlarm fireAlarm = new FireAlarm(false);

        //Act
        fireAlarm.setActive();
        Boolean actual = fireAlarm.isActive();

        //Assert
        Assert.assertEquals("Should return true",true,actual);
    }
}
