package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {

    // returns the current date and time as a string
    public static String date_Time() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String s_Date = formatter.format(date);
        return s_Date;
    }



    //used to write our purchase logs in Log.txt
    public static void transactions_Log(Product item, Balance balance) {
        try(FileOutputStream t_log = new FileOutputStream("Log.txt", true)) {
            String line = date_Time() + " | PURCHASED: " + item.getProduct_Name() + " " + item.getSlot_Location() + " $" + item.getProduct_Price() + " $" + balance.getBalance().toString() + "\n";
            t_log.write(line.getBytes());
        }
        catch (Exception e){
            System.out.println();
            System.out.println("An Error Has Occurred Within Transaction Log");
        }
    }


    // used to write our money feeder logs in Log.txt
    public static void feeders_Log(Balance balance, int money) {
        try(FileOutputStream f_log = new FileOutputStream("Log.txt", true)) {
            String line = date_Time() + " | " + "FEED MONEY: $" + money + " $" + balance.getBalance() + "\n";
            f_log.write(line.getBytes());
        }
        catch (Exception e){
            System.out.println();
            System.out.println("An Error Has Occurred Within Feeding Money Log");
        }
    }


    // used to write our change return logs in Log.txt
    public static void changes_Log(BigDecimal current_Balance, BigDecimal balance) {

        try(FileOutputStream c_log = new FileOutputStream("Log.txt", true)) {
            String line = date_Time() + " | " + "GIVE CHANGE: $" + current_Balance + " $" + balance + "\n";
            c_log.write(line.getBytes());
            c_log.write("- END -\n".getBytes());
        }
        catch (Exception e){
            System.out.println();
            System.out.println("An Error Has Occurred with Change Log");
        }
    }
}
