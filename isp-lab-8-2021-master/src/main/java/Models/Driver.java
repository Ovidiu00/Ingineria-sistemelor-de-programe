package Models;

import java.io.Serializable;

public class Driver extends Person implements Serializable {

    public Driver(String FirstName, String LastName) {
       super.FirstName = FirstName;
       super.LastName = FirstName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
   public PARKROLE GetParkRole() {
        return PARKROLE.Driver;
    }
}
