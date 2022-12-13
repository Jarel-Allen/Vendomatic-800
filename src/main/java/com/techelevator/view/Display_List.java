package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Display_List {

    //this is our file reader to display items as a list
    public static void items(Balance balance, String choice, String file) {
        File fileInput = new File(file);
        try (Scanner dataInput = new Scanner(fileInput)) {
            while (dataInput.hasNextLine()) {
                List<String> product_Info = Arrays.asList(dataInput.nextLine().split("\\|"));
                Product product = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3));

                if(choice.equals(VendingMachineCLI.getMainMenuOptionDisplayItems())) {
                    display_Items(product);
                } else if (choice.equals(VendingMachineCLI.getPurchaseOptionSelectProduct())) {
                    purchase_Items_List(product);
                }

                if (product.getSlot_Location().equals(choice)) {
                    product.purchase_item(choice);
                    purchase_Item(balance, product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please Check Your File Path...");
        }
    }
    //---------------------------------------------------------------------------------------------
    //this is our display list of items
    public static void display_Items(Product item) {
        System.out.println("Item: " + item.getProduct_Name());
        if (item.getProduct_Stock_Quantity()==0) {
            System.out.println("Out of Stock!" + "\n");
        } else {
            System.out.println("In-Stock: " + item.getProduct_Stock_Quantity() + "\n");
        }
    }

    public static void purchase_Items_List(Product item) {
        System.out.println("ID: " + item.getSlot_Location());
        System.out.println("Item: " + item.getProduct_Name());
        System.out.println("Cost: $" + item.getProduct_Price() + "\n");
    }

    //---------------------------------------------------------------------------------------------

    public static void purchase_Item(Balance balance, Product item) {
        String price = item.getProduct_Price();
        BigDecimal price_value = BigDecimal.valueOf(Double.valueOf(price));
        balance.subtract(price_value);
        if (balance.getBalance().compareTo(price_value) >= 0) {
            System.out.println();
            System.out.println("Now Dispensing Your Item: " + item.getProduct_Name());

            if(item.getProduct_Type().equals("Chip")) {
                Menu_Display.chip_Display();
            } else if(item.getProduct_Type().equals("Candy")) {
                Menu_Display.candy_Display();
            } else if(item.getProduct_Type().equals("Drink")) {
                Menu_Display.drink_Display();
            }else if(item.getProduct_Type().equals("Gum")) {
                Menu_Display.gum_Display();
            }
        }



    }
}
