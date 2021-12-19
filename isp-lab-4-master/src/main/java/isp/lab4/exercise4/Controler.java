package isp.lab4.exercise4;

public class Controler {

    private TemperatureSensor[] temperatureSensors;
    private FireAlarm fireAlarm;

    public Controler(TemperatureSensor[] temperatureSensors, FireAlarm fireSensor) {
        this.temperatureSensors = temperatureSensors;
        this.fireAlarm = fireSensor;
    }

    private boolean everySensorOverTemperatureLimit(){
        for(TemperatureSensor temperatureSensor : temperatureSensors){
            if(temperatureSensor.getValue() <= 50){
                return false;
            }
        }
        return true;
    }

    public void controlStep(){
        if(this.everySensorOverTemperatureLimit()){
            fireAlarm.setActive();
            System.out.println("Fire alarm  started");
        }
        else{
            System.out.println("Fire alarm not started");
        }
    }
}
