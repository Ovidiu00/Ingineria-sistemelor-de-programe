package Configuration;

public class ParkSystemConfiguration {
    private static int _maximumSpaces;

    public static int getMaximumSpaces() {
        return _maximumSpaces;
    }

    public static void setMaximumSpaces(int maximumSpaces) {
        _maximumSpaces = maximumSpaces;
    }
}
