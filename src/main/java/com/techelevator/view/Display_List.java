package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display_List {
    //this is our file reader to display items as a list
    public static void items(String file) {
        File fileInput = new File(file);
        try (Scanner dataInput = new Scanner(fileInput)) {
            while (dataInput.hasNextLine()) {
                List<String> product_Info = Arrays.asList(dataInput.nextLine().split("\\|"));
                Product product = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3));
                display_Items(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }
    }
    //this is our display list of items
    public static void display_Items(Product item) {
        System.out.println("Item: " + item.getProduct_Name());
        System.out.println("In-Stock: " + item.getProduct_Stock_Quantity() + "\n");
    }
}
