package com.techelevator.view.misc;

import com.techelevator.view.inventory.Inventory;
import com.techelevator.view.inventory.Product;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;

public class SalesReportCalculator {

    // does calculations to print out sales amounts
    public static void sales_Calculations(List<Product> items, FileOutputStream report_Of_Sales) {
        try {
            // collects all purchased items' costs
            BigDecimal sales = BigDecimal.valueOf(0).setScale(2);

            // creating indent to look better
            String indent = "                    ";

            // for every product of the list
            for (Product p : items) {
                // each product has an indent
                String item_Name = p.getProduct_Name();
                item_Name += indent.substring(0, indent.length() - p.getProduct_Name().length());
                // prints out product name and purchase count
                String line = item_Name + "| " + p.getProduct_Purchase_Count() + "\n";

                // writes the line of the string
                report_Of_Sales.write(line.getBytes());

                // for every count up to five it adds cost to sales
                for (int i = 1; i <= 5; i++) {
                    if (p.getProduct_Purchase_Count() >= i){
                        sales = sales.add(BigDecimal.valueOf(Double.parseDouble(p.getProduct_Price())).setScale(2));
                    }
                }
            }

            // prints out the total sale cost
            String sales_Total = "\n**TOTAL SALES**     $" + sales;
            report_Of_Sales.write(sales_Total.getBytes());
        }

        // catches if there is a problem with writing to a file
        catch (Exception e) {
            ExceptionHandling.salesReportLog_Exception();
        }
    }

    // sets the sold item counts back to 0
    public static void set_To_Zero () {
        for (Product p : Inventory.items) {
            p.setProduct_Purchase_Count(0);
        }
    }
}