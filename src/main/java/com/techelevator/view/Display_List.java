package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

public class Display_List{

    public static List<Product> items = new ArrayList<>();
    public static Map<String, Product> items_Grabber = new HashMap<>();
    //this is our file reader to display items as a list
    public static void items_Displayer(String choice) {
        for(int j = 0; j < items.size(); j++) {
            if(choice.equals(VendingMachineCLI.getMainMenuOptionDisplayItems())) {
                display_Items(items.get(j));

            } else if (choice.equals(VendingMachineCLI.getPurchaseOptionSelectProduct())) {
                purchase_Items_List(items.get(j));
            }
        }
    }
    public static void item_Purchaser(String choice, Balance balance){
        if(items_Grabber.get(choice)==null) {
            Menu_Display.code_Does_Not_Exist();
        } else {
            purchase_Item(balance, items_Grabber.get(choice));
        }
    }
    public static void items(String file) {
        File fileInput = new File(file);
        try (Scanner dataInput = new Scanner(fileInput)) {
            while (dataInput.hasNextLine()) {
                List<String> product_Info = Arrays.asList(dataInput.nextLine().split("\\|"));
                Product product = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3));
                items.add(product);
                items_Grabber.put(product_Info.get(0), product);
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
            System.out.println("SOLD OUT" + "\n");
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
        
        if (item.getProduct_Stock_Quantity()==0){
            Menu_Display.out_Of_Stock_Display();
        } else if (item.getProduct_Stock_Quantity() > 0) {
            balance.subtract(price_value);
            item.remove_Stock();
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
