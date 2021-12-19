package isp.lab4.exercise3;


public class Controler {

    private TemperatureSensor temperatureSensor;
    private FireAlarm fireAlarm;

    public Controler(TemperatureSensor temperatureSensor, FireAlarm fireSensor) {
        this.temperatureSensor = temperatureSensor;
        this.fireAlarm = fireSensor;
    }

    public void controlStep(){
        if(temperatureSensor.getValue() > 50){
            fireAlarm.setActive();
            System.out.println("Fire alarm  started");
        }
        else{
            System.out.println("Fire alarm not started");
        }
    }
}
