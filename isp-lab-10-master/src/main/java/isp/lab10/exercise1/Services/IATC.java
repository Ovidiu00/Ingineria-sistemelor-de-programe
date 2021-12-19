package isp.lab10.exercise1.Services;

import isp.lab10.exercise1.Commands.AtcCommand;
import isp.lab10.exercise1.Models.Aircraft;

import java.util.List;

public interface IATC {
     Aircraft addAircraft(String id);
     List<Aircraft> getAllAircrafts();
     void sendCommand(String aircraftId, AtcCommand command);

}
