package isp.lab10.exercise1.Models;

import isp.lab10.exercise1.Commands.AtcCommand;
import isp.lab10.exercise1.Commands.TakeOffCommand;
import isp.lab10.exercise1.MVC.AbstractModel;
import isp.lab10.exercise1.Services.AIRCRAFT_STATE;
import isp.lab10.exercise1.Services.COMMAND_TYPE;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aircraft extends AbstractModel implements Runnable {

    private boolean onStand = true;
    private boolean active = true;

    private String aircraftID;
    private int altitude;

    private AIRCRAFT_STATE currentState;



    public Aircraft(String aircraftID) {
        this.aircraftID = aircraftID;
    }

    public void run() {
        while (active) {

            if (onStand) {
                synchronized (this) {
                    try {
                        System.out.println("Aircraft : " + aircraftID + " is on stand waiting!");
                        this.currentState = AIRCRAFT_STATE.ONSTAND;

                        this.firePropertyChange("currentState","","On stand");
                        wait(); //pune in asteptare firl de executie
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aircraft.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            try {
                this.firePropertyChange("currentState"," ","Taxing");
                this.currentState = AIRCRAFT_STATE.TAXING;
                Thread.sleep(1000 * 10 ); // 10 secunde



                this.firePropertyChange("currentState","","Taking Off");
                this.currentState = AIRCRAFT_STATE.TAKINGOFF;
                Thread.sleep(1000 * 5 ) ;// 5 secunde



                this.firePropertyChange("currentState","","Ascending ");
                this.currentState = AIRCRAFT_STATE.ASCENDING;
                for(int i = 1 ; i <= this.altitude ; i++) {

                    Thread.sleep(1000 * 10);
                    this.firePropertyChange("currentAltitude",0,i);


                }


                LocalDateTime dateBeforeCruising = LocalDateTime.now();
                synchronized (this)
                {
                    this.firePropertyChange("currentState","","Cruising");
                    this.currentState = AIRCRAFT_STATE.CRUISING;
                    System.out.println("Aircraft : " + aircraftID + " is cruising!");
                    wait();
                }

                LocalDateTime dateAfterCruising = LocalDateTime.now();

                int secondsSpentCruising = (int)dateBeforeCruising.until(dateAfterCruising, ChronoUnit.SECONDS);
                this.firePropertyChange("cruisingTime",0,secondsSpentCruising);



                this.firePropertyChange("currentState","","Descending");
                this.currentState = AIRCRAFT_STATE.DESCENDING;
                System.out.println("Aircraft : " + aircraftID + " is descending!");
                for(int i = this.altitude ; i >= 1 ; i--) {

                    Thread.sleep(1000 * 10);
                    this.firePropertyChange("currentAltitude",0,i);


                }


                this.firePropertyChange("currentState","","Landed !");
                this.currentState = AIRCRAFT_STATE.LANDED;
                this.firePropertyChange("currentAltitude","","On ground");


                this.stopThread();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Aircraft.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void stopThread()
    {
        this.active = false;
    }

    public String getAircraftID() {
        return aircraftID;
    }


    public  void recieveAtcCommand(AtcCommand atcCommand){

         synchronized(this) {
             COMMAND_TYPE typeOfCommand = atcCommand.getTypeOfCommand();
             switch (typeOfCommand.ordinal()) {

                 //Take off
                 case 0:

                     TakeOffCommand takeOffCommand = (TakeOffCommand)atcCommand;

                     this.altitude = takeOffCommand.getAltitude();
                     onStand = false;
                     notify();
                     break;


                     //Land
                 case 1:
                     if(currentState != AIRCRAFT_STATE.CRUISING)
                         break;

                     notify();
                     break;


             }
         }

    }
}

