package com.techelevator.view.inventory;

import com.techelevator.view.balance.Balance;
import com.techelevator.view.misc.Displays;
import com.techelevator.VendingMachineCLI;
import com.techelevator.view.logger.Logs;
import com.techelevator.view.misc.ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    // global list of items by product
    public static List<Product> items = new ArrayList<>();

    // global map of products associated to slot location
    public static Map<String, Product> items_Grabber = new HashMap<>();

    // inventory file reader
    // --------------------------------------------------------------------------
    public static void data_Reader(String file) {

        // reads the file
        File fileInput = new File(file);

        // checks to see if file is eligible
        try (Scanner dataInput = new Scanner(fileInput)) {

            // our loop to read each line in the file
            while (dataInput.hasNextLine()) {

                // creates a list of arrays of a string that is split by a pipe "|"
                List<String> product_Info = Arrays.asList(dataInput.nextLine().split("\\|"));

                // creating a new product object for each line
                Product product = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3));

                // adds product to the list of items
                items.add(product);

                // adds slot location as key, and then product as the value into a map called items grabber
                items_Grabber.put(product_Info.get(0), product);
            }

            // if the file does not have a path, it will catch the error and print out a string
        } catch (FileNotFoundException e) {
            ExceptionHandling.fileException();
        }
    }

    // this is a list of items to be displayed in our menus
    //-------------------------------------------------------------------------------------
    public static void items_Display(String choice) {

        // this is a for loop that goes through every item
        for(Product p : items) {

            // if choice is on display items, it will print out item name/stock amount
            if(choice.equals(VendingMachineCLI.getMainMenuOptionDisplayItems())) {

                // displays list of items with stocked quantity
                display_Items_List(p);
            }

            // if choice is on select product, it will print out slot location/item name/item price
            else if (choice.equals(VendingMachineCLI.getPurchaseOptionSelectProduct())) {

                // displays purchasable items with IDs and prices
                purchase_Items_List(p);
            }
        }
    }

    // displays list of items with stocked quantity
    public static void display_Items_List(Product item) {

        // prints out each product name
        System.out.println("Item: " + item.getProduct_Name());

        // if the quantity of stock is 0, it will print out a string
        if (item.getProduct_Stock_Quantity()==0) {
            System.out.println("SOLD OUT" + "\n");
        }

        // if not, then it will print out the quantity
        else {
            System.out.println("In-Stock: " + item.getProduct_Stock_Quantity() + "\n");
        }
    }

    // displays purchasable items with IDs and prices
    public static void purchase_Items_List(Product item) {

        // prints out the slot location, item name, and item cost
        System.out.println("ID: " + item.getSlot_Location());
        System.out.println("Item: " + item.getProduct_Name());
        System.out.println("Cost: $" + item.getProduct_Price() + "\n");
    }

    // this is our method when purchasing items
    //-------------------------------------------------------------------------------
    public static void item_Selector(String choice, Balance balance){

        // if there is a key, then it will calculate balance with cost

        if(items_Grabber.get(choice)!=null) {
            purchasing_Item(balance, items_Grabber.get(choice));
        }
        else {
            // if the key is null within the map, it will print out a string
            System.out.println("\n" + "ID Code: [" + choice + "] Does Not Exist!");
        }
    }

    // method used to calculate balance and change stock quantity
    public static void purchasing_Item(Balance balance, Product item) {

        // changing the string of item cost to a big decimal
        BigDecimal price_value = BigDecimal.valueOf(Double.parseDouble(item.getProduct_Price()));

        // if the stock quantity is 0, then it will print out a string
        if (item.getProduct_Stock_Quantity()==0){
            Displays.out_Of_Stock_Display();
        }

        // if the stock quantity is greater than 0, it will calculate money
        else if (item.getProduct_Stock_Quantity() > 0) {

            // this calculates remaining balance and prints out strings
            dispenser(balance, item, price_value);
        }
    }

    // this method is for after entering the slot location, our dispenser
    public static void dispenser(Balance balance, Product item, BigDecimal price_value) {

        // checks to see if balance will still be greater than 0
        if (balance.getBalance().compareTo(price_value) >= 0) {

            // this subtracts item cost from current balance
            balance.subtract(price_value);

            // this adds one count after purchase to sales report
            item.add_PurchaseCount();

            // this removes one stock from the stock quantity
            item.remove_Stock();

            // prints out item name, cost, and remaining balance
            System.out.println("\n" + "Dispensing Your Item: " + item.getProduct_Name());
            System.out.println("Cost: $" + item.getProduct_Price());
            System.out.println("Remaining Balance: $"+ balance.getBalance());

            // prints out sound by type of item
            soundCheck(item);

            // creates a transaction log to our log.txt
            Logs.transactions_Log(item, balance);
        }
        // if there is not enough money, prints message
        else {
            System.out.println("\n" + "You are short of $" + price_value.subtract(balance.getBalance()) + ". Feed More Money!");
        }
    }

    // creates a sound for each item
    //----------------------------------------------------------------------------------------
    public static void soundCheck(Product item) {
        if (item.getProduct_Type().equals("Chip")) {
            // prints out for chips
            System.out.println("\n" + "Crunch Crunch, Yum!");
        }

        else if (item.getProduct_Type().equals("Candy")) {
            // prints out for candy
            System.out.println("\n" + "Munch Munch, Yum!");
        }

        else if (item.getProduct_Type().equals("Drink")) {
            // prints our for drinks
            System.out.println("\n" + "Glug Glug, Yum!");
        }

        else if (item.getProduct_Type().equals("Gum")) {
            // prints out for gum
            System.out.println("\n" + "Chew Chew, Yum!");
        }
    }

}

