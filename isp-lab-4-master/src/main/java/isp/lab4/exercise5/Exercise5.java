package isp.lab4.exercise5;

public class Exercise5 {
    public static void main(String[] args){

        House house = new House(new Controler());

        house.getControler().controlStep();

    }
}
