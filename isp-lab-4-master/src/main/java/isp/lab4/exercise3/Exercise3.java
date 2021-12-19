package isp.lab4.exercise3;

public class Exercise3 {

    public static void main(String[] args){

        Controler controler = new Controler(new TemperatureSensor(60,"Room"),new FireAlarm(false));

        controler.controlStep();
    }
}
