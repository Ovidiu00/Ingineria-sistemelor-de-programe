package isp.lab3;

import isp.lab3.exercise1.Exercise1;
import isp.lab3.exercise3.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    @Test
    public void testToString() {
        Vehicle car = new Vehicle("Dacia","Logan",120,'D');

        String expected =  "Dacia(Logan) speed 120 fuel type D";
        assertEquals("Should return " + expected, expected, car.toString());
    }

}
