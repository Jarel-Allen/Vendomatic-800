package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display_List {

    //this is our file reader to display items as a list
    public static void items(String choice,String file) {
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
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please Check Your File Path...");
        }
    }
    //---------------------------------------------------------------------------------------------
    //this is our display list of items
    public static void display_Items(Product item) {
        System.out.println("Item: " + item.getProduct_Name());
        if (item.getProduct_Stock_Quantity() == 0) {
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
}
