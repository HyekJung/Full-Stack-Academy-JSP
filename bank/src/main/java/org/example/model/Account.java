package org.example.model;

import java.util.List;

public class Account {
    private long accountNumber; //계좌번호
    private int balance; //잔고
    private String message;
    private List<Transaction> transactionList; //거래내역 리스트

    public Account(long accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //입금
    public void deposit(int price){
        balance += price;
    }

    //출금
    public void withdraw(int price){
        if(balance < price){
            throw new IllegalArgumentException("계좌 잔액이 부족합니다.");
        }
        balance -= price;
    }

    public int getBalance() {
        return balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
