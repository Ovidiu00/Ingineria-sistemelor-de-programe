package isp.lab7.safehome;

import isp.lab7.safehome.UI.AdministratorUI;
import isp.lab7.safehome.UI.SafeHouseUI;

import java.util.ArrayList;
import java.util.List;


public class SafeHome {

    public static void main(String[] args) throws Exception {


        Door door = new Door();
        List<AccesLog> logs = new ArrayList<>();

        DoorLockController controller = new DoorLockController(door, logs);

        SafeHouseUI ui = new SafeHouseUI();
        ui.setDoorLockController(controller);


        AdministratorUI administratorUI = new AdministratorUI();
        administratorUI.setController(controller);




        /*
        controller.addTenant("1111","Marius");
        controller.addTenant("0000","Sergiu");
        controller.addTenant("69420","Viorel");

        //controller.enterPin("333333");

        controller.enterPin("1111");

        //controller.removeTenant("fasfd");

        controller.removeTenant("Sergiu");

        controller.addTenant("0000","Sergiu");

        System.out.println(logs.toString());

        */

    }
}
