package org.example.service;

import org.example.model.Account;
import org.example.model.BankAccount;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    Map<Long, BankAccount> accountMap = new HashMap<>(); //은행계좌

    public Map<Long, BankAccount> getAccountMap() {
        return accountMap;
    }

    public void createAccount(long id, String name, long accountNumber, int balance) {
        //새로 유저, 계좌 생성
        User user = new User(id, name);
        Account account = new Account(accountNumber, balance);

        BankAccount bankAccount = new BankAccount(account, user);
        accountMap.put(accountNumber, bankAccount);
    }

    public void deposit(int price, long accountNumber) {
        BankAccount bankAccount = accountMap.get(accountNumber);

        if (bankAccount != null) {
            bankAccount.getAccount().deposit(price);
            bankAccount.getAccount().setMessage(price + " 원이 입금되었습니다.");
            System.out.println(bankAccount.getAccount().getMessage());
        } else {
            throw new IllegalArgumentException("없는 계좌입니다. 계좌번호를 확인해주세요.");
        }
    }

    public void withdraw(int price, long accountNumber) {
        BankAccount bankAccount = accountMap.get(accountNumber);

        if (bankAccount != null) {
            if (bankAccount.getAccount().getBalance() >= price) {
                bankAccount.getAccount().withdraw(price);
                bankAccount.getAccount().setMessage(price + " 원이 출금되었습니다.");
                System.out.println(bankAccount.getAccount().getMessage());
            }
        } else {
            throw new IllegalArgumentException("없는 계좌입니다. 계좌번호를 확인해주세요.");
        }
    }

    public void transfer(int price, long fromAccountNumber, long toAccountNumber) {
        BankAccount fromAccount = accountMap.get(fromAccountNumber); //받는 분
        BankAccount toAccount = accountMap.get(toAccountNumber); //보내는 분

        if (fromAccount != null && toAccount != null) {
            //입금
            toAccount.getAccount().deposit(price);
            toAccount.getAccount().setMessage(
                    toAccount.getUser().getName() + "님의 현재 잔액은 " + toAccount.getAccount().getBalance() + " 입니다.");
            System.out.println(toAccount.getAccount().getMessage());

            //출금
            fromAccount.getAccount().withdraw(price);
            fromAccount.getAccount().setMessage(
                    fromAccount.getUser().getName() + "님의 현재 잔액은 " + fromAccount.getAccount().getBalance() + " 입니다.");
            System.out.println(fromAccount.getAccount().getMessage());
        } else {
            throw new IllegalArgumentException("계좌번호를 확인해주세요.");
        }
    }

}
