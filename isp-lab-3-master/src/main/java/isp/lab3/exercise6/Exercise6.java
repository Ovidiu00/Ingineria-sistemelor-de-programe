package isp.lab3.exercise6;

import isp.lab3.exercise5.VendingMachine;

public class Exercise6 {

    public static void main(String[] args) {

        VendingMachineSingleton vendingMachine =  VendingMachineSingleton.getInstance();

        VendingMachineSingleton vendingMachine2 = VendingMachineSingleton.getInstance();

        VendingMachineSingleton vendingMachine3 =  VendingMachineSingleton.getInstance();

        System.out.println("vendingMachine adress : " + vendingMachine + " \n");
        System.out.println("vendingMachine2 adress : " + vendingMachine2 + " \n");
        System.out.println("vendingMachine3 adress : " + vendingMachine3 + " \n");


        vendingMachine.userMenu();



    }
}
