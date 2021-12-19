package isp.lab6.exercise3;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SensorsCluster {
    private List<Sensor> sensors= new ArrayList();



    public Sensor addSensor(String sensorId,SENSOR_TYPE type){

        Sensor newSensor = new Sensor(type, Integer.parseInt(sensorId));
        sensors.add(newSensor);

        return  newSensor;
    }
    public boolean writeSensorReading(String sensorId, double value, LocalDateTime dateTime){

        Sensor sensor = getSensorById(sensorId);
        SensorReading reading = new SensorReading(dateTime,value);

        sensor.addSensorReading(reading);

        return  true;
    }

    public Sensor getSensorById(String sensorId){
        for(Sensor sensor : sensors){
            if(sensor.getId() == Integer.parseInt(sensorId)){
                return  sensor;
            }
        }

        return  null;
    }
}
