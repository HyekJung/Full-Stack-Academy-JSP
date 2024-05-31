package org.example.service;

import org.example.model.Account;
import org.example.model.BankAccount;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @DisplayName("createAccount : 계좌, 유저 생성을 성공한다.")
    @Test
    public void createAccount(){
        //given
        long id = 1;
        String name = "user1";
        long accountNumber = 1;
        int balance = 0;

        //when
        BankService bankService = new BankService();
        bankService.createAccount(id, name, accountNumber, balance);

        //then
        Map<Long, BankAccount> accountMap = bankService.getAccountMap();
        assertTrue(accountMap.containsKey(accountNumber)); //계좌번호 있는지 확인
    }

    @DisplayName("depositSuccess : 입금에 성공한다.")
    @Test
    public void depositSuccess(){
        //given
        long id = 1;
        String name = "user1";
        long accountNumber = 1;
        int balance = 0;

        BankService bankService = new BankService();
        bankService.createAccount(id, name, accountNumber, balance);

        //when
        int price = 10;
        bankService.deposit(price, accountNumber);

        //then
        BankAccount bankAccount = bankService.getAccountMap().get(accountNumber);
        assertEquals(bankAccount.getAccount().getBalance(), balance + price);
        assertNotNull(bankAccount);
    }

    @DisplayName("depositFail : 입금에 실패한다.")
    @Test
    public void depositFail(){
        //given
        BankService bankService = new BankService();
        long accountNumber = 1;
        int price = 10;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                bankService.deposit(price, accountNumber));

        //then
        assertEquals(exception.getMessage(), "없는 계좌입니다. 계좌번호를 확인해주세요.");
    }

    @DisplayName("withdrawSuccess : 출금에 성공한다.")
    @Test
    public void withdrawSuccess(){
        //given
        long id = 1;
        String name = "user1";
        long accountNumber = 1;
        int balance = 10;

        BankService bankService = new BankService();
        bankService.createAccount(id, name, accountNumber, balance);

        //when
        int price = 10;
        bankService.withdraw(price, accountNumber);

        //then
        BankAccount bankAccount = bankService.getAccountMap().get(accountNumber);
        assertEquals(bankAccount.getAccount().getBalance(), balance - price);
        assertNotNull(bankAccount);
    }

    @DisplayName("withdrawFailNon : 출금에 실패한다. - 계좌번호가 없는 경우")
    @Test
    public void withdrawFailNon(){
        //given
        long accountNumber = 1;
        int price = 20;

        BankService bankService = new BankService();

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                bankService.withdraw(price, accountNumber));

        //then
        assertEquals(exception.getMessage(), "없는 계좌입니다. 계좌번호를 확인해주세요.");
    }

    @DisplayName("withdrawFail : 출금에 실패한다. - 출금액이 잔액보다 큰 경우")
    @Test
    public void withdrawFail() {
        //given
        long id = 1;
        String name = "user1";
        long accountNumber = 1;
        int balance = 10;

        BankService bankService = new BankService();
        bankService.createAccount(id, name, accountNumber, balance);

        //when, then
        int price = 20;

        try {
            bankService.withdraw(price, accountNumber);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("계좌 잔액이 부족합니다.", e.getMessage());
        }
    }

        @DisplayName("transferSuccess : 계좌 간 이체에 성공한다.")
        @Test
        public void transferSuccess(){
            //given
            long id1 = 1;
            String user1 = "user1";
            long accountNumber1 = 1;
            int balance1 = 10;

            long id2 = 2;
            String user2 = "user2";
            long accountNumber2 = 2;
            int balance2 = 5;

            BankService bankService = new BankService();
            bankService.createAccount(id1, user1, accountNumber1, balance1);
            bankService.createAccount(id2, user2, accountNumber2, balance2);

            //when
            int price = 3;
            bankService.transfer(price, accountNumber1, accountNumber2);

            //then
            BankAccount fromAccount = bankService.getAccountMap().get(accountNumber1);
            BankAccount toAccount = bankService.getAccountMap().get(accountNumber2);

            assertEquals(fromAccount.getAccount().getBalance(), balance1 - price);
            assertEquals(toAccount.getAccount().getBalance(), balance2 + price);

    }

    @DisplayName("transferFail : 계좌 간 이체에 실패한다. - 계좌번호가 없는 경우")
    @Test
    public void transferFail(){
        //given
        long id1 = 1;
        String user1 = "user1";
        long accountNumber1 = 1;
        int balance1 = 10;

        long id2 = 2;
        String user2 = "user2";
        long accountNumber2 = 2;
        int balance2 = 5;

        BankService bankService = new BankService();
        bankService.createAccount(id1, user1, accountNumber1, balance1);

        //when
        int price = 5;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                bankService.transfer(price, accountNumber1, accountNumber2));

        //then
        assertEquals("계좌번호를 확인해주세요.", exception.getMessage());
    }

    @DisplayName("historySuccess : 거래내역 출력을 성공한다.")
    @Test
    public void historySuccess(){
        //given
        long id1 = 1;
        String user1 = "user1";
        long accountNumber1 = 1;
        int balance1 = 10;

        BankService bankService = new BankService();
        bankService.createAccount(id1, user1, accountNumber1, balance1);

        bankService.deposit(10, accountNumber1); //거래내역 생성

        //when
        bankService.transactionHistory(accountNumber1, user1);

        //then
        assertEquals(1,
                bankService.accountMap.get(accountNumber1).getAccount().getTransactionList().size());
    }

    @DisplayName("historyFail : 거래내역 출력을 실패한다.")
    @Test
    public void historyFail(){
        //given
        long id1 = 1;
        String user1 = "user1";
        long accountNumber1 = 1;
        int balance1 = 10;

        BankService bankService = new BankService();
        bankService.createAccount(id1, user1, accountNumber1, balance1);

        bankService.deposit(10, accountNumber1); //거래내역 생성

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                bankService.transactionHistory(accountNumber1, "user999"));

        //then
        assertEquals("계좌번호 또는 이름을 확인해주세요.", exception.getMessage());
    }
}