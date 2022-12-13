package com.techelevator.view;

public class Stock_Amount {
    private int quantity = 5;

    public int remove_Stock(int number) {

        if (quantity > 0) {
           return quantity -= number;
        }
        return quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
