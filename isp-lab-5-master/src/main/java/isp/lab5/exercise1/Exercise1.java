package isp.lab5.exercise1;

//import isp.lab4.exercise0.CarAlarm; //NU ASA

public class Exercise1 {

    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);

        Account Account1 = bank.getAccountByCardId("1");

        atm.insertCard(Account1.getCard(), "0000");

        atm.checkMoney();

        atm.withdraw(10);

       atm.checkMoney();


        atm.changePin("0000","1234");


        atm.removeCard();



    }
}
