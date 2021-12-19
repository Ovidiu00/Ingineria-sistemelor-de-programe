package Exercise1;

class AlarmMonitor implements Observer {

    @Override
    public void update(Object event) {
        System.out.println("Exercise1.Alarm status has changed!");
        System.out.println("Received event: Event class:"+event.getClass()+":"+event.toString());

    }

}