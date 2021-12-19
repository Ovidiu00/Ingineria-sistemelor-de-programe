package isp.lab10.exercise1.Services;

import isp.lab10.exercise1.Commands.AtcCommand;
import isp.lab10.exercise1.Commands.TakeOffCommand;
import isp.lab10.exercise1.Models.Aircraft;

import java.util.ArrayList;
import java.util.List;

public class ATC implements  IATC{

    List<Aircraft> aircrafts;

    public ATC() {
        this.aircrafts = new ArrayList<>();
    }

    @Override
    public Aircraft addAircraft(String id) {
        Aircraft aircraft = new Aircraft(id);

        aircrafts.add(aircraft);

        return  aircraft;
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return  aircrafts;
    }

    @Override
    public void sendCommand(String aircraftId, AtcCommand command) {


        for (Aircraft aircraft : aircrafts){
            if(aircraft.getAircraftID().equals(aircraftId)){
                aircraft.recieveAtcCommand(command);
            }
        }

    }
}
