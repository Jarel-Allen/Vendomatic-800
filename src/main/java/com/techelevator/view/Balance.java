package com.techelevator.view;

import java.math.BigDecimal;

public class Balance {

    // using Big Decimals to set decimal place to match prices
    private BigDecimal balance = BigDecimal.valueOf(0).setScale(2);


    // -----------------------------------------------------------------------------------
    // our calculators for adding and subtracting the balance
    public void add(int money) {
        balance = balance.add(BigDecimal.valueOf(money));
    }

    public void subtract(BigDecimal money) {

        // checks to see if balance is enough to cover cost
        if (balance.compareTo(money) >= 0) {
            balance = balance.subtract(money);
        }

        // if balance can't cover the cost, it will print out a string.
        else if (balance.compareTo(money) < 0) {
            System.out.println();
            System.out.println("Not Enough Money!");
        }
    }

    //-----------------------------------------------------------------------------------
    // this code is used after they select "finish transaction", gives back remaining balance
    public void remaining_Balance() {

        //prints out the customer's balance
        System.out.println();
        System.out.println("Returning Total Change Of: $" + balance + "!");

        // these are the counts of coins
        int quarters_Count = 0;
        int dimes_Count = 0;
        int nickels_Count = 0;

        // while the balance is first, more than a quarter, it will add a quarter to count, and subtract from balance
        while (balance.compareTo(BigDecimal.valueOf(.25)) >= 0) {
            quarters_Count++;
            balance = balance.subtract(BigDecimal.valueOf(.25));
        }
        // while the balance is second, more than a dime, it will add a dime to count, and subtract from balance
        while (balance.compareTo(BigDecimal.valueOf(.10)) >= 0) {
            dimes_Count++;
            balance = balance.subtract(BigDecimal.valueOf(.10));
        }
        // while the balance is third, more than a nickel, it will add a nickel to count, and subtract from balance
        while (balance.compareTo(BigDecimal.valueOf(.05)) >= 0) {
            nickels_Count++;
            balance = balance.subtract(BigDecimal.valueOf(.05));
        }
        // at this point, the balance should be at $0.00
        System.out.println();

        // this prints out the count of quarters, if any
        if (quarters_Count > 0){
            System.out.println(quarters_Count + " Quarter(s)");
        }
        // this prints out the count of dimes, if any
        if (dimes_Count > 0) {
            System.out.println(dimes_Count + " Dime(s)");
        }
        // this prints out the count of nickels, if any
        if (nickels_Count > 0) {
            System.out.println(nickels_Count + " Nickel(s)");
        }
    }

    // -----------------------------------------------------------------------------------
    // our getters
    public BigDecimal getBalance() {
        return balance;
    }
}
