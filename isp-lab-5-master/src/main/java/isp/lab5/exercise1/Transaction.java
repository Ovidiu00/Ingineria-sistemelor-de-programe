package isp.lab5.exercise1;

abstract class Transaction {
    public Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    abstract String execute();
}
