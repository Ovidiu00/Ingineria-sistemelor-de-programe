package isp.lab7.safehome.exceptions;

public class TenantNotFoundException extends Exception{

    public TenantNotFoundException(String tennantName){
        super("Tennant with the given name( "+ tennantName +") was not found");
    }
}
