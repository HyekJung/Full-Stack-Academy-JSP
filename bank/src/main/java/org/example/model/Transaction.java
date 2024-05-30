package org.example.model;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime dateTime; //거래시각
    private String type; //입,출금 타입
    private int price; //금액
    private int balanceAfter; //거래 후 잔액

    public Transaction(LocalDateTime dateTime, String type, int price, int balanceAfter) {
        this.dateTime = dateTime;
        this.type = type;
        this.price = price;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return "거래내역 = " +
                "시각 : " + dateTime +
                ", 입/출금 형태 : '" + type + '\'' +
                ", 거래 금액 : " + price +
                ", 거래 후 잔액 : " + balanceAfter +
                '}';
    }
}
