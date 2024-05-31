package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private long accountNumber; //계좌번호
    private int balance; //잔고
    private String message;
    private List<Transaction> transactionList; //거래내역 목록

    public Account(long accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //입금
    public void deposit(int price){
        balance += price;
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction(
                LocalDateTime.now(), "입금", price, balance));
    }

    //출금
    public void withdraw(int price){
        if(balance < price){
            throw new IllegalArgumentException("계좌 잔액이 부족합니다.");
        }
        balance -= price;
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction(
                LocalDateTime.now(), "출금", price, balance));
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

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
