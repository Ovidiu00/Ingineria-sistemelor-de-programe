package Models;

import java.io.Serializable;

public class Car implements Serializable {
    private String licensePlate;

    public Car() {
    }

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }


    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
