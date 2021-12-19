package Exceptions;

public class ParkIsFullException extends Exception{
    public ParkIsFullException() {
        super("Park is full ! \n");
    }
}
