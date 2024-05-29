package org.example;

import org.example.service.BankService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        //user와 account 생성 //1
        for (int i = 1; i <= 10; i++) {
            bankService.createAccount(i,"user " + i, i, 0);
        }

        bankService.deposit(10, 1); //2
        bankService.withdraw(5, 1); //3
        bankService.transfer(3, 1, 2); //4
    }
}