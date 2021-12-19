package isp.lab5.exercise1;

public class ATM {
    private Bank bank;
    private Card card;





    public ATM(Bank bank) {
        this.bank = bank;



    }

    public void insertCard(Card card, String pin){
        if(card.getPin() == pin){
            this.card = card;
            System.out.println("Card successfully inserted! \n");
        }
        else{
            System.out.println("Wrong pin! \n");
        }

    }
    public void removeCard(){
        this.card = null;
    }
    public void changePin(String oldPin, String newPin){
        if(card != null){

            Transaction changePinTransaction = new ChangePin(oldPin,newPin);
            changePinTransaction.setAccount(bank.getAccountByCardId(card.getCardId()));

            bank.executeTransaction(changePinTransaction);
        }
        else {
            System.out.println("Card not inserted yet! \n");
        }


    }
    public void withdraw(double amount){

        if(card != null){

            Transaction withDrawTransaction = new WithdrawMoney(amount);
            withDrawTransaction.setAccount(bank.getAccountByCardId(card.getCardId()));

            bank.executeTransaction(withDrawTransaction);
        }
        else {
            System.out.println("Card not inserted yet! \n");
        }


    }
    public void checkMoney(){

        if(card != null){

            Transaction checkMoneyTransaction = new CheckMoney();
            checkMoneyTransaction.setAccount(bank.getAccountByCardId(card.getCardId()));

            System.out.println( bank.executeTransaction(checkMoneyTransaction) );
        }
        else {
            System.out.println("Card not inserted yet! \n");
        }

    }

}
