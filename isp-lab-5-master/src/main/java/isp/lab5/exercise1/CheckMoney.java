package isp.lab5.exercise1;

public class CheckMoney extends Transaction{



    @Override
    String execute() {

        return  "You have " + account.getBalance() + " ";
    }
}
