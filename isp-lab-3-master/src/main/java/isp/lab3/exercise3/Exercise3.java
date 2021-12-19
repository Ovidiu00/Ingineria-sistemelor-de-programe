package isp.lab3.exercise3;

import isp.lab3.exercise3.Vehicle;
public class Exercise3 {



    public static void main(String[] args) {


        Vehicle car1 = new Vehicle("Dacia","Logan",120,'D');
        Vehicle car2 = new Vehicle("Audi","A4",180,'B');

        System.out.println("Model car1 : " + car1.getModel() + "\n");
        System.out.println("Model car2 : " + car2.getModel() + "\n");

        System.out.println("Type car1 : " + car1.getType() + "\n");
        System.out.println("Type car2 : " + car2.getType() + "\n");

        car1.set_model("Opel");
        System.out.println("The new model of car1 : " + car1.getModel() + "\n");

        if(car1.equals(car2))
            System.out.println("The two vehicles are equal \n ");
        else
            System.out.println(" Not equal ! \n");

        System.out.println("Number of vehicles created  " + Vehicle.GetNumberOfVehiclesCreated() + "\n");

    }



}
