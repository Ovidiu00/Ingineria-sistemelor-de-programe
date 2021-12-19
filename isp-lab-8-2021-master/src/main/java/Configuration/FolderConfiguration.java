package Configuration;

public class FolderConfiguration {

    private static String _ParkingLotfolderName;
    private static String _LogsfolderName;

    public static void set_ParkingLotfolderName(String _ParkingLotfolderName) {
        FolderConfiguration._ParkingLotfolderName = _ParkingLotfolderName;
    }

    public static void set_LogsfolderName(String _LogsfolderName) {
        FolderConfiguration._LogsfolderName = _LogsfolderName;
    }

    public static String get_LogsfolderName() {
        return _LogsfolderName;
    }

    public static String get_ParkingLotfolderName() {
        return _ParkingLotfolderName;
    }
}
