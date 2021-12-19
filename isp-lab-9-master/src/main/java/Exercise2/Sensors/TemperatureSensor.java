package Exercise2.Sensors;

import Exercise2.SENSORTYPE;
import Exercise2.Sensor;

public class TemperatureSensor extends Sensor {
    @Override
    public SENSORTYPE getSensorType() {
        return SENSORTYPE.TEMPERATURE;
    }


}
