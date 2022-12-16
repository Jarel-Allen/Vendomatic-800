package com.techelevator.view;

public class Product{

    private String slot_Location;
    private String product_Name;
    private String product_Price;
    private String product_Type;

    //-----------------------------------------------------------------------------------
    // stock counts for each item
    private int product_Stock_Quantity = 5;
    private int product_Purchase_Count = 0;



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

    // this code adds one purchase count for sales report
    public int add_PurchaseCount() {
        if (product_Purchase_Count <= 5) {
            product_Purchase_Count++;
        }
        return product_Purchase_Count;
    }

    //-----------------------------------------------------------------------------------
    // our getters
    public int getProduct_Stock_Quantity () {
        return product_Stock_Quantity;
    }

    public int getProduct_Purchase_Count() {
        return product_Purchase_Count;
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
            System.out.println("\n" + "Crunch Crunch, Yum!");
        }

        else if (product_Type.equals("Candy")) {
            // prints out for candy
            System.out.println("\n" + "Munch Munch, Yum!");
        }

        else if (product_Type.equals("Drink")) {
            // prints our for drinks
            System.out.println("\n" + "Glug Glug, Yum!");
        }

        else if (product_Type.equals("Gum")) {
            // prints out for gum
            System.out.println("\n" + "Chew Chew, Yum!");
        }

        return product_Type;
    }

}
