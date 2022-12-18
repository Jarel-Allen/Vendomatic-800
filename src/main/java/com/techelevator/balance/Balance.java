package com.techelevator.balance;

import com.techelevator.logger.Logs;
import com.techelevator.misc.Displays;
import com.techelevator.misc.ExceptionHandling;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Balance {

    // using Big Decimals to set decimal place to match prices
    private BigDecimal balance = BigDecimal.valueOf(0).setScale(2);

    // our calculators for balance
    // -----------------------------------------------------------------------------------

    // adds money to balance
    public void add(int money) {
        balance = balance.add(BigDecimal.valueOf(money));
    }

    // subtracts money from balance
    public void subtract(BigDecimal money) {

        // checks to see if balance is enough to cover cost
        if (balance.compareTo(money) >= 0) {
            balance = balance.subtract(money);
        }
    }

    // this method is used after they select "finish transaction", gives back remaining balance
    //----------------------------------------------------------------------------------------
    public void remaining_Balance() {

        BigDecimal current_Balance = balance;

        // prints a change dispenser display
        Displays.change_Display();

        //prints out the customer's balance
        System.out.println("\n" + "Total Change Of: $" + balance + "!");

        // these are the counts of coins
        int quarters_Count = 0;
        int dimes_Count = 0;
        int nickels_Count = 0;

        // if the balance is greater than 0, dispensing coins display will print
        if (balance.compareTo(BigDecimal.valueOf(0)) > 0) {
            Displays.dispensing_Coins();

            // for a quick dispenser pause...
            for (int i = 0; i <= 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print(" .");
                    i++;
                } catch (InterruptedException e) {
                    ExceptionHandling.Timer_Exception();
                }
            }
            System.out.println();
        }

        // subtracts balance by coin value
        subtract_By_Coins(quarters_Count, dimes_Count, nickels_Count);

        // at this point, the balance should be at $0.00 and coins are dispensed

        /*  if the balance is greater than 0, it will print out finish transaction logs,
            preventing blank balances to fill the log  */
        if (current_Balance.compareTo(BigDecimal.valueOf(0))!=0) {
            Logs.changes_Log(current_Balance, balance);
        }
    }

    // methods used to reduce balance to zero and get counts of coins
    //-------------------------------------------------------------------------------------

    // this method subtracts balance by coin value
    public void subtract_By_Coins(int quarters_Count, int dimes_Count, int nickels_Count) {
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

        // prints out coin if count is greater than 0
        coin_Dispenser(quarters_Count, dimes_Count, nickels_Count);
    }

    // this method will print out coins if the count is greater than 0
    public void coin_Dispenser(int quarters_Count, int dimes_Count, int nickels_Count) {
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

    // our getters
    // -----------------------------------------------------------------------------------
    public BigDecimal getBalance() {
        return balance;
    }
}
