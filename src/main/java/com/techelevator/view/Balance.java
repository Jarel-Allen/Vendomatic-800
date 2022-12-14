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
    public void remaining_Balance() {
        System.out.println();
        System.out.println("Returning Total Change Of: $" + balance + "!");

        int quarters_Count = 0;
        int dimes_Count = 0;
        int nickels_Count = 0;
        while (balance.compareTo(BigDecimal.valueOf(.25)) >= 0) {
            quarters_Count++;
            balance = balance.subtract(BigDecimal.valueOf(.25));
        }
        while (balance.compareTo(BigDecimal.valueOf(.10)) >= 0) {
            dimes_Count++;
            balance = balance.subtract(BigDecimal.valueOf(.10));
        }
        while (balance.compareTo(BigDecimal.valueOf(.05)) >= 0) {
            nickels_Count++;
            balance = balance.subtract(BigDecimal.valueOf(.05));
        }
        if (quarters_Count > 0){
            System.out.println(quarters_Count + " Quarter(s)");
        }
        if (dimes_Count > 0) {
            System.out.println(dimes_Count + " Dime(s)");
        }
        if (nickels_Count > 0) {
            System.out.println(nickels_Count + " Nickel(s)");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
