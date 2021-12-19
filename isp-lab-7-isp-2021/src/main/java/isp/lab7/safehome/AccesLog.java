package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccesLog {

    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String ErrorMessage;

    public AccesLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        ErrorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "AccesLog{" +
                "tenantName='" + tenantName + '\'' +
                ", dateTime=" + dateTime +
                ", operation='" + operation + '\'' +
                ", doorStatus=" + doorStatus +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                '}';
    }
}
