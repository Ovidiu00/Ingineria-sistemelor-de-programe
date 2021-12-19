package isp.lab5.exercise1;

public class Account {

    private Card card;
    private String owner;
    private  double balance;

    public Account(Card card, String owner, double balance) {
        this.card = card;
        this.owner = owner;
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
