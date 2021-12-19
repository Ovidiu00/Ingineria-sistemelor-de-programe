package isp.lab7.safehome.exceptions;

public class TenantAlreadyExistsException extends Exception{

    public TenantAlreadyExistsException(String tennantName){
        super("Tennant with the given name ( " + tennantName + " ) already exists!");
    }
}
