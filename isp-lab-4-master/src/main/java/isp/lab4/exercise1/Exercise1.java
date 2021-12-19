package isp.lab4.exercise1;

//import isp.lab4.exercise0.CarAlarm; //NU ASA


public class Exercise1 {

    public static void main(String[] args) {

        TemperatureSensor temperatureSensor = new TemperatureSensor(50, "Garage");
        String location = temperatureSensor.getLocation();
        Integer value = temperatureSensor.getValue();


        System.out.print(location + " " + value );
    }
}
