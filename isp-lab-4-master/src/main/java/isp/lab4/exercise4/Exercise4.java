package isp.lab4.exercise4;


public class Exercise4 {

    public static void main(String[] args){
        TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];
        temperatureSensors[0] = new TemperatureSensor(40,"Bedroom");
        temperatureSensors[1] = new TemperatureSensor(13,"Kitchen");
        temperatureSensors[2] = new TemperatureSensor(24,"LivingRoom");



        Controler controler = new Controler(temperatureSensors, new FireAlarm(false));
        controler.controlStep();


    }


}
