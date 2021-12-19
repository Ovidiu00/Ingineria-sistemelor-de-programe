package Exercise2.Sensors;

import Exercise2.SENSORTYPE;
import Exercise2.Sensor;

public class PressureSensor extends Sensor {
    @Override
    public SENSORTYPE getSensorType() {
        return SENSORTYPE.PRESSURE;
    }


}
