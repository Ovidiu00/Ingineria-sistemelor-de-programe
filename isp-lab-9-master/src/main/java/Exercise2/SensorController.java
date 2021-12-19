package Exercise2;

public class SensorController implements Observer{
    @Override
    public void update(Object event) {

        Sensor sensor = (Sensor) event;

        String sensorType = sensor.getSensorType().name();
        double sensorValue = sensor.getValue();

        System.out.println("Sensor type : " + sensorType + " Value : " + sensorValue + "\n");

    }
}
