package isp.lab10.exercise1.Commands;

import isp.lab10.exercise1.Services.COMMAND_TYPE;

public class TakeOffCommand extends AtcCommand {

    private int altitude;

    public TakeOffCommand(int altitude) {
        this.altitude = altitude;
        this.typeOfCommand = COMMAND_TYPE.TAKEOFF;
    }

    public int getAltitude() {
        return altitude;
    }
}
