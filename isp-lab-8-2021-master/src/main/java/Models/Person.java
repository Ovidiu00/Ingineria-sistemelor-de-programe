package Models;


import java.io.Serializable;

public abstract class Person {

    protected String FirstName;
    protected String LastName;

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public abstract PARKROLE GetParkRole();

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
