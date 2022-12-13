package com.techelevator.view;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance = BigDecimal.valueOf(0).setScale(2);

    public void add(int money) {
        balance = balance.add(BigDecimal.valueOf(money));
    }

    public void subtract(BigDecimal money) {
        if (balance.compareTo(money) >= 0) {
            balance = balance.subtract(money);
        } else if (balance.compareTo(money) < 0) {
            System.out.println();
            System.out.println("Not Enough Money!");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
