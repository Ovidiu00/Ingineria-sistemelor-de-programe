package Exceptions;

public class CarCannotBeFoundException extends  Exception{

    public CarCannotBeFoundException(String plate) {
        super("Cannot find any car in the parking lot with the given plate: " + plate);
    }
}
