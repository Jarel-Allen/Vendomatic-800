package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Display_List {

    //this is our file reader to display items as a list
    public static void items(Balance balance, String choice,String file) {
        File fileInput = new File(file);
        try (Scanner dataInput = new Scanner(fileInput)) {
            while (dataInput.hasNextLine()) {
                List<String> product_Info = Arrays.asList(dataInput.nextLine().split("\\|"));
                Product product = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3), 5);
                Map<String, Integer> items = new HashMap<>();
                items.put(product.getSlot_Location(), product.getProduct_Stock_Quantity());

                if(choice.equals(VendingMachineCLI.getMainMenuOptionDisplayItems())) {
                    display_Items(items, product);
                } else if (choice.equals(VendingMachineCLI.getPurchaseOptionSelectProduct())) {
                    purchase_Items_List(items, product);
                }

                if (items.containsKey(choice)) {
                    purchase_Item(product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please Check Your File Path...");
        }
    }
    //---------------------------------------------------------------------------------------------
    //this is our display list of items
    public static void display_Items(Map<String, Integer> product, Product item) {
        System.out.println("Item: " + item.getProduct_Name());
        if (product.values().equals(0)) {
            System.out.println("Out of Stock!" + "\n");
        } else {
            System.out.println("In-Stock: " + product.values() + "\n");
        }
    }

    public static void purchase_Items_List(Map<String, Integer> product,Product item) {
        System.out.println("ID: " + product.keySet());
        System.out.println("Item: " + item.getProduct_Name());
        System.out.println("Cost: $" + item.getProduct_Price() + "\n");
    }

    //---------------------------------------------------------------------------------------------

    public static void purchase_Item(Product product) {

        if(product.getProduct_Type().equals("Chip")) {
            Menu_Display.chip_Display();
        } else if(product.getProduct_Type().equals("Candy")) {
            Menu_Display.candy_Display();
        } else if(product.getProduct_Type().equals("Drink")) {
            Menu_Display.drink_Display();
        }else if(product.getProduct_Type().equals("Gum")) {
            Menu_Display.gum_Display();
        }
    }
}
