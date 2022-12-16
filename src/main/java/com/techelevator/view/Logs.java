package com.techelevator.view;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Logs {

    // returns the current date and time as a string
    public static String getDate_Time() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String s_Date = formatter.format(date);
        return s_Date;
    }

    // returns the current date and time as a string formatted to create a file
    public static String getFile_Date_Time() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh.mm.ss a");
        String s_Date = formatter.format(date);
        return s_Date;
    }



    //used to write our purchase logs in Log.txt
    public static void transactions_Log(Product item, Balance balance) {
        try(FileOutputStream t_log = new FileOutputStream("Log.txt", true)) {
            String line = getDate_Time() + " | PURCHASED: " + item.getProduct_Name() + " " + item.getSlot_Location() + " $" + item.getProduct_Price() + " $" + balance.getBalance().toString() + "\n";
            t_log.write(line.getBytes());
        }
        catch (Exception e){
            System.out.println("\n" + "An Error Has Occurred Within Transaction Log");
        }
    }


    // used to write our money feeder logs in Log.txt
    public static void feeders_Log(Balance balance, int money) {
        try(FileOutputStream f_log = new FileOutputStream("Log.txt", true)) {
            String line = getDate_Time() + " | " + "FEED MONEY: $" + money + " $" + balance.getBalance() + "\n";
            f_log.write(line.getBytes());
        }
        catch (Exception e){
            System.out.println("\n" + "An Error Has Occurred Within Feeding Money Log");
        }
    }


    // used to write our change return logs in Log.txt
    public static void changes_Log(BigDecimal current_Balance, BigDecimal balance) {

        try(FileOutputStream c_log = new FileOutputStream("Log.txt", true)) {
            String line = getDate_Time() + " | " + "GIVE CHANGE: $" + current_Balance + " $" + balance + "\n";
            c_log.write(line.getBytes());

            // this means that the user chose "Finish Transaction" and used for readability
            c_log.write("- END OF TRANSACTION -\n".getBytes());
        }
        catch (Exception e){
            System.out.println("\n" + "An Error Has Occurred with Change Log");
        }
    }

    // creates a unique log for sales report
    public static void sales_Report(List<Product> items){

        // creating a string to make it easier to .getByte()
        String s_Report_File = "Sales Report " + getFile_Date_Time() + ".txt";

        try(FileOutputStream report_Of_Sales = new FileOutputStream(s_Report_File, true)) {

            // calculates sales amounts
            SalesReportCalculator.sales_Calculations(items, report_Of_Sales);
        }

        catch (Exception e){
            System.out.println("\n" + "An Error Has Occurred with Sales Report Log");
        }
    }
}
