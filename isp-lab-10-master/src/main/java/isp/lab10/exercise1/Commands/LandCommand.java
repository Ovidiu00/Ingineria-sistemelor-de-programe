package isp.lab10.exercise1.Commands;

import isp.lab10.exercise1.Services.COMMAND_TYPE;

public class LandCommand  extends AtcCommand{


    public LandCommand() {
        this.typeOfCommand = COMMAND_TYPE.LAND;
    }
}
