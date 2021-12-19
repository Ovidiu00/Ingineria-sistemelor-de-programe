package isp.lab5.exercise1;

public class WithdrawMoney extends Transaction {
    private  double amount;

    public WithdrawMoney(double amount) {
        this.amount = amount;
    }

    @Override
    String execute() {
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);

        return "You currently have" + account.getBalance() + "in your account";
    }
}
