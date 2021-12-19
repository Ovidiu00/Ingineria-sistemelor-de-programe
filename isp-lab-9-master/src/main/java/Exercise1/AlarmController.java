package Exercise1;

public class AlarmController implements Observer {

    @Override
    public void update(Object event) {
        System.out.println("Exercise1.Alarm status has changed!");
        System.out.println("Sending SMS message to owner.");
    }
}
