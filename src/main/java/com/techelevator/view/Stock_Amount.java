package com.techelevator.view;

public class Stock_Amount {
    private int quantity = 5;

    public int remove_Stock(int number) {
        return quantity -= number;
    }

    public int getQuantity() {
        return quantity;
    }

}
