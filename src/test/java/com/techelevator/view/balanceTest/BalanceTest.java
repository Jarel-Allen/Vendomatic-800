package com.techelevator.view.balanceTest;

import com.techelevator.balance.Balance;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTest {

    // tests out our add balance
    @Test
    public void add_Test () {
        Balance balance = new Balance();
        balance.add(5);
        Assert.assertEquals(BigDecimal.valueOf(5).setScale(2), balance.getBalance());

        // increase by 3 from current balance of 5.
        balance.add(3);
        Assert.assertEquals(BigDecimal.valueOf(8).setScale(2), balance.getBalance());
    }

    //tests out our subtract balance
    @Test
    public void subtract_Test() {
        Balance balance = new Balance();
        balance.add(10);

        balance.subtract(BigDecimal.valueOf(3));
        Assert.assertEquals(BigDecimal.valueOf(7).setScale(2), balance.getBalance());

        // decreases by 3 from current balance of 7.
        balance.subtract(BigDecimal.valueOf(3));
        Assert.assertEquals(BigDecimal.valueOf(4).setScale(2), balance.getBalance());
    }

    //tests out if negative balance prints out message
    @Test
    public void subtract_Negative_Test() {

        //will print out "Not Enough Money!"
        Balance balance = new Balance();
        balance.add(3);
        balance.subtract(BigDecimal.valueOf(4));
        Assert.assertEquals(BigDecimal.valueOf(3).setScale(2), balance.getBalance());
    }

    // tests out our remaining balance and prints out in coins
    @Test
    public void remaining_Balance_Coins_Check() {
        Balance balance = new Balance();
        balance.add(10);

        balance.remaining_Balance();
        Assert.assertEquals(BigDecimal.valueOf(0).setScale(2), balance.getBalance());
        //prints out a message for answer
        System.out.println("\n"+"Expected output: 40 Quarter(s)");
        System.out.println("Balance after change: $" + balance.getBalance());

        System.out.println();
        //adds 10 to balance
        balance.add(10);
        //subtract 4.70 from 10.00
        balance.subtract(BigDecimal.valueOf(4.70).setScale(2));

        //balance should be 5.30 and returns coins

        balance.remaining_Balance();
        Assert.assertEquals(BigDecimal.valueOf(0).setScale(2), balance.getBalance());
        //prints out a message for answer
        System.out.println("\n"+"Expected output: 21 Quarter(s) and 1 Nickel(s)");
        System.out.println("Balance after change: $" + balance.getBalance());
    }
}
