package Exercise1;

class Alarm extends Observable {
    void startAlarm() {
        System.out.println("Exercise1.Alarm has been started!");
        this.changeState("START");
    }

    void stopAlarm() {
        System.out.print("Exercise1.Alarm has been stopped!");
        this.changeState("STOP");
    }
}