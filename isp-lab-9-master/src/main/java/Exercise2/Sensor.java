package Exercise2;

import java.util.Random;

public abstract class Sensor extends Observable {
    private double value = 0;


    public abstract SENSORTYPE getSensorType();

    public void readSensor() {
       this.value = new Random().nextInt(1000);

        this.changeState(this);
    }



    public double getValue() {
        return value;
    }
}
