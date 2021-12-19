package Infrastructure;

import Models.ParkLog;

import java.util.List;

public interface ILogRepository {

    void addLog(ParkLog log);
    List<ParkLog> readAllLogs();
    ParkLog readLog(String fileName);
}
