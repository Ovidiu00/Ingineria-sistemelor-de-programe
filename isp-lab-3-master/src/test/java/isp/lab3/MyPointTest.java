package isp.lab3;

import isp.lab3.exercise4.MyPoint;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyPointTest {

    @Test
    public void testDistance()
    {
        //Arrange
        MyPoint point = new MyPoint(7,4,3);
        int x = 17,y = 6, z = 2;

        double  expected = 10.246951;

        //Act
        double result = point.distance(x,y,z);

        //Assert
        assertEquals("Distance should be " + expected, expected, result,0.001);

    }
}
