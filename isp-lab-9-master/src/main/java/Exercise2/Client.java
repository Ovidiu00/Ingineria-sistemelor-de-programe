package Exercise2;

import Exercise2.Sensors.HumiditySensor;
import Exercise2.Sensors.PressureSensor;
import Exercise2.Sensors.TemperatureSensor;

public class Client {
    public static void main(String[] args){
        Sensor temperatureSensor = new TemperatureSensor();
        Sensor humiditySensor = new HumiditySensor();
        Sensor pressureSensor = new PressureSensor();

        Observer controller = new SensorController();

        temperatureSensor.register(controller);
        humiditySensor.register(controller);
        pressureSensor.register(controller);

        ClientUI ui = new ClientUI(controller,temperatureSensor,humiditySensor,pressureSensor);

        temperatureSensor.readSensor();
        humiditySensor.readSensor();
        pressureSensor.readSensor();
    }
}
