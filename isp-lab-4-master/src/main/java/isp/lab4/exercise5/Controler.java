package isp.lab4.exercise5;

public class Controler {

    private TemperatureSensor[] temperatureSensors ;
    private FireAlarm fireAlarm;

    public Controler() {
        this.temperatureSensors = new TemperatureSensor[3];


        this.temperatureSensors[0] = new TemperatureSensor(60,"Bedroom");
        this.temperatureSensors[1] = new TemperatureSensor(14,"Kitchen");
        this.temperatureSensors[2] = new TemperatureSensor(4,"Garage");



        this.fireAlarm = new FireAlarm(false);
    }

    private boolean atLeastOneSensorOverTemperatureLimit(){
        for(TemperatureSensor temperatureSensor : temperatureSensors){
            if(temperatureSensor.getValue() > 50){
                return true;
            }
        }
        return false;
    }

    public void controlStep(){
        if(this.atLeastOneSensorOverTemperatureLimit()){
            fireAlarm.setActive();
            System.out.println("Fire alarm  started");
        }
        else{
            System.out.println("Fire alarm not started");
        }
    }
}
