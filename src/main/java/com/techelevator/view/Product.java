package com.techelevator.view;

public class Product{

    private String slot_Location;
    private String product_Name;
    private String product_Price;
    private String product_Type;
    private int product_Stock_Quantity = 5;

    //-----------------------------------------------------------------------------------
    // our product/item constructor
    public Product(String slot_Location, String product_Name, String product_Price, String product_Type) {
        this.slot_Location = slot_Location;
        this.product_Name = product_Name;
        this.product_Price = product_Price;
        this.product_Type = product_Type;
    }

    //-----------------------------------------------------------------------------------
    // this code removes one item stock per purchase
    public int remove_Stock() {

        if (product_Stock_Quantity > 0) {
            return product_Stock_Quantity --;
        }
        return product_Stock_Quantity;
    }

    //-----------------------------------------------------------------------------------
    // our getters
    public int getProduct_Stock_Quantity () {
        return product_Stock_Quantity;
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
        if (product_Type.equals("Chip")) {
            // prints out for chips
            System.out.println();
            System.out.println("Crunch Crunch, Yum!");
        }

        else if (product_Type.equals("Candy")) {
            // prints out for candy
            System.out.println();
            System.out.println("Munch Munch, Yum!");
        }

        else if (product_Type.equals("Drink")) {
            // prints our for drinks
            System.out.println();
            System.out.println("Glug Glug, Yum!");
        }

        else if (product_Type.equals("Gum")) {
            // prints out for gum
            System.out.println();
            System.out.println("Chew Chew, Yum!");
        }

        return product_Type;
    }

}
