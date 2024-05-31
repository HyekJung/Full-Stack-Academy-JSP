package org.example.model;

public class BankAccount {
    private Account account;
    private User user;

    public BankAccount(Account account, User user) {
        this.account = account;
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public User getUser() {
        return user;
    }

    public void transactionHistory(){
        for (Transaction history : account.getTransactionList()){
            System.out.println(history.toString());
        }
    }
}
