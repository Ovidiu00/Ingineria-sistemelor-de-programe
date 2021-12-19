package isp.lab7.safehome.exceptions;

public class InvalidPinException extends Exception{
    public InvalidPinException(String pin){
        super("The pin you entered (" + pin + " ) was invalid!");
    }
}
