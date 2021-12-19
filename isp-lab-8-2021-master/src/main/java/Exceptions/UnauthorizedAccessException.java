package Exceptions;

import Models.Person;

public class UnauthorizedAccessException extends Exception {

    public UnauthorizedAccessException(Person person, String methodName){
        super("The person : " + person + " does not have acces to perfom this operation : " + methodName);
    }
}
