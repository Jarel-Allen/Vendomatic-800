package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Display_List {

    //this is our file reader to display items as a list
    public static void items(Stock_Amount amount, Balance balance, String choice, String file) {
        File fileInput = new File(file);
        try (Scanner dataInput = new Scanner(fileInput)) {
            while (dataInput.hasNextLine()) {
                List<String> product_Info = Arrays.asList(dataInput.nextLine().split("\\|"));
                Product product = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3));
                if(choice.equals(VendingMachineCLI.getMainMenuOptionDisplayItems())) {
                    display_Items(product, amount);

                } else if (choice.equals(VendingMachineCLI.getPurchaseOptionSelectProduct())) {
                    purchase_Items_List(product);
                }

                if (product.getSlot_Location().equals(choice)) {
                    purchase_Item(amount,balance, product);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please Check Your File Path...");
        }
    }
    //---------------------------------------------------------------------------------------------
    //this is our display list of items
    public static void display_Items(Product item, Stock_Amount amount) {
        System.out.println("Item: " + item.getProduct_Name());
        if (amount.getQuantity()==0) {
            System.out.println("SOLD OUT" + "\n");
        } else {
            System.out.println("In-Stock: " + amount.getQuantity() + "\n");
        }
    }

    public static void purchase_Items_List(Product item) {
        System.out.println("ID: " + item.getSlot_Location());
        System.out.println("Item: " + item.getProduct_Name());
        System.out.println("Cost: $" + item.getProduct_Price() + "\n");
    }

    //---------------------------------------------------------------------------------------------

    public static void purchase_Item(Stock_Amount amount, Balance balance, Product item) {
        String price = item.getProduct_Price();
        BigDecimal price_value = BigDecimal.valueOf(Double.valueOf(price));

        if (amount.getQuantity()==0){
            Menu_Display.out_Of_Stock_Display();
        } else if (amount.getQuantity() > 0) {
            balance.subtract(price_value);
            amount.remove_Stock(1);
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
}
