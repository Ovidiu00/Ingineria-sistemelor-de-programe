package isp.lab5.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();


    public Bank() {


        accounts.add(new Account(new Card("1", "0000"), "Paul", 325.05));
        accounts.add(new Account(new Card("2", "0000"), "Paula", 11));
        accounts.add(new Account(new Card("3", "0000"), "Marian", 231));
        accounts.add(new Account(new Card("4", "0000"), "Gabriel", 4));


    }

    public String executeTransaction(Transaction transaction) {
        return transaction.execute();
    }

    public Account getAccountByCardId(String cardId) {

        for (Account account : accounts) {
            if (account.getCard().getCardId() == cardId)
                return account;
        }

        return null;
    }
}
