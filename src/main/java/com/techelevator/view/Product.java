package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Product{

    private String slot_Location;
    private String product_Name;
    private String product_Price;
    private String product_Type;

    public Product(String slot_Location, String product_Name, String product_Price, String product_Type) {
        this.slot_Location = slot_Location;
        this.product_Name = product_Name;
        this.product_Price = product_Price;
        this.product_Type = product_Type;
    }

    public String getSlot_Location() {
        return slot_Location;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public String getProduct_Price() {
        return product_Price;
    }

    public String getProduct_Type() {
        return product_Type;
    }

}
