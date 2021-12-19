package Models;

public class Administrator extends Person {

    public Administrator(String FirstName, String LastName) {
        FirstName = FirstName;
        LastName = FirstName;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
   public    PARKROLE GetParkRole() {
        return  PARKROLE.Administrator;
    }
}
