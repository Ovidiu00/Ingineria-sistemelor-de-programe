package Exercise1;

import Exercise1.Alarm;
import Exercise1.AlarmController;
import Exercise1.AlarmMonitor;

public class Client {
    public static void main(String[] args) throws InterruptedException{
        Alarm fireAlarm = new Alarm();
        AlarmMonitor monitor = new AlarmMonitor();
        AlarmController controller = new AlarmController();

        fireAlarm.register(monitor);
        fireAlarm.register(controller);


        fireAlarm.startAlarm();
        Thread.sleep(500);
        fireAlarm.stopAlarm();

    }
}