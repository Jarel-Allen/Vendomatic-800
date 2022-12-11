package com.techelevator.view;

import java.math.BigDecimal;

public class Customer_Balance {
    private BigDecimal balance = BigDecimal.valueOf(0).setScale(2);

    public void add(int money) {
        balance = balance.add(BigDecimal.valueOf(money));
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
