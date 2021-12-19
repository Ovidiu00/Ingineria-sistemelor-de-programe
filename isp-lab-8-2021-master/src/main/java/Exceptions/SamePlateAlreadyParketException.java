package Exceptions;

public class SamePlateAlreadyParketException extends  Exception{

    public SamePlateAlreadyParketException(String plateNumber){
        super("There is already a card parked with the given license plate : " + plateNumber + "\n");
    }
}
