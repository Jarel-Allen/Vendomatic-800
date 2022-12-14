package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory_Reader {

    // global list of items by product
    public static List<Product> items = new ArrayList<>();

    // global map of products associated to slot location
    public static Map<String, Product> items_Grabber = new HashMap<>();

    // --------------------------------------------------------------------------

    // inventory file reader
    public static void items(String file) {

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

                // adds slot location as key, and then product as the value into a map
                items_Grabber.put(product_Info.get(0), product);
            }

            // if the file does not have a path, it will catch the error and print out a string
        } catch (FileNotFoundException e) {
            System.out.println("Please Check Your File Path...");
        }
    }

    //-------------------------------------------------------------------------------------

    // this is a list of items to be displayed in our menus
    public static void items_Displayer(String choice) {

        // this is a for loop that goes through every item
        for(Product p : items) {

            // if choice is on display items, it will print out item name/stock amount
            if(choice.equals(VendingMachineCLI.getMainMenuOptionDisplayItems())) {

                // displays list of items with stocked quantity
                display_Items(p);
            }

            // if choice is on select product, it will print out slot location/item name/item price
            else if (choice.equals(VendingMachineCLI.getPurchaseOptionSelectProduct())) {

                // displays purchasable items with IDs and prices
                purchase_Items_List(p);
            }
        }
    }

    // displays list of items with stocked quantity
    public static void display_Items(Product item) {

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

    //-------------------------------------------------------------------------------

    // this is our code when purchasing items
    public static void item_Purchaser(String choice, Balance balance){

        // if the key is null within the map, it will print out a string
        if(items_Grabber.get(choice)==null) {
            Menu_Display.code_Does_Not_Exist();
        }

        // if there is a key, then it will calculate balance with cost
        else {
            purchase_Item(balance, items_Grabber.get(choice));
        }
    }

    // code to calculate balance and change stock quantity
    public static void purchase_Item(Balance balance, Product item) {

        // changing the string of item cost to a big decimal
        String price = item.getProduct_Price();
        BigDecimal price_value = BigDecimal.valueOf(Double.valueOf(price));

        // if the stock quantity is 0, then it will print out a string
        if (item.getProduct_Stock_Quantity()==0){
            Menu_Display.out_Of_Stock_Display();
        }

        // if the stock quantity is greater than 0, it will calculate money
        else if (item.getProduct_Stock_Quantity() > 0) {

            // this subtracts item cost from current balance
            balance.subtract(price_value);

            // this removes one stock from the stock quantity
            item.remove_Stock();

            //this calculates remaining balance and prints out strings
            dispenser(balance, item, price_value);
        }
    }

    // this code is for after entering the slot location, our dispenser
    public static void dispenser(Balance balance, Product item, BigDecimal price_value) {

        // checks to see if balance will still be greater than 0
        if (balance.getBalance().compareTo(price_value) >= 0) {

            // prints out item name, cost, and remaining balance
            System.out.println();
            System.out.println("Dispensing Your Item: " + item.getProduct_Name());
            System.out.println("Cost: $" + item.getProduct_Price());
            System.out.println("Remaining Balance: $"+ balance.getBalance());

            // if item type is chip, prints out chip string
            if(item.getProduct_Type().equals("Chip")) {
                Menu_Display.chip_Display();
            }

            // if item type is candy, prints out candy string
            else if(item.getProduct_Type().equals("Candy")) {
                Menu_Display.candy_Display();
            }

            // if item type is drink, prints out drink string
            else if(item.getProduct_Type().equals("Drink")) {
                Menu_Display.drink_Display();
            }
            // if item type is gum, prints out gum string
            else if(item.getProduct_Type().equals("Gum")) {
                Menu_Display.gum_Display();
            }
        }
    }
}
