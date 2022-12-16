package com.techelevator.view.misc;

import com.techelevator.view.exceptions.DataFileNotFoundException;
import com.techelevator.view.exceptions.LogFileException;
import com.techelevator.view.exceptions.StringToNumberException;

import static java.lang.System.exit;

public class ExceptionHandling {


    //----------------------------------------------------------------------------------------------
    // this will print out and exit the program, if that fails, then it will print custom exception
    public static void fileException() {
        try {
            System.out.println("\n" + "File Not Found.");
            exit(0);
        }
        catch (Exception f) {
            throw new DataFileNotFoundException("File not found." + "\n");
        }
    }

//-----------------------------------------------------------------------------------------------------
    // exception handling for parsing a user input

    // try to print string, if not, it will print out custom exception
    public static void parseInt_Exception() {
        try {
            System.out.println("\n"+"Please Enter a Whole Number (Without A Decimal).");
        }
        catch (Exception f){
            throw new StringToNumberException("String Cannot Be Parsed To An Integer" + "\n");
        }
    }

//-----------------------------------------------------------------------------------------------------
    // this is where our try catch blocks are when an error in creating a file

    // transaction error exception
    public static void transactionLog_Exception(){
        try {
            System.out.println("\n" + "An Error Has Occurred Within Transaction Log");
        }
        catch(Exception f){
            throw new LogFileException("FileOutputStream Error");
        }
    }

    // feeder error exception
    public static void feederLog_Exception(){
        try {
            System.out.println("\n" + "An Error Has Occurred Within Feeding Money Log");
        }
        catch(Exception f){
            throw new LogFileException("FileOutputStream Error");
        }
    }

    // change error exception
    public static void changeLog_Exception(){
        try {
            System.out.println("\n" + "An Error Has Occurred with Change Log");
        }
        catch(Exception f){
            throw new LogFileException("FileOutputStream Error");
        }
    }

    // sales report error exception
    public static void salesReportLog_Exception(){
        try {
            System.out.println("\n" + "An Error Has Occurred with Sales Report Log");
        }
        catch(Exception f){
            throw new LogFileException("FileOutputStream Error");
        }
    }


}
