package com.techelevator.view;

public class Menu_Display {
    public static void welcome_Sign() {
        // this is used at the beginning when the code first runs
        System.out.println();
        System.out.println("========================================");
        System.out.println(" Welcome to our Virtual Vending Machine");
        System.out.println("========================================");
    }
    public static void exit_Sign() {
        // this is used at the beginning when the code first runs
        System.out.println();
        System.out.println("=================================================");
        System.out.println(" Thank You For Using Our Virtual Vending Machine");
        System.out.println("=================================================");
    }

    public static void main_Menu() {
        // prints out main menu
        System.out.println();
        System.out.println("===================");
        System.out.println("     Main Menu     ");
        System.out.println("===================");
    }

    public static void display_Items_Sign() {
        // used when we list out our snacks
        System.out.println();
        System.out.println("====================================");
        System.out.println("       List Of All Our Snacks");
        System.out.println("====================================");
        System.out.println();
    }

    public static void purchase_Menu() {
        // prints out purchase menu
        System.out.println();
        System.out.println("=======================");
        System.out.println("     Purchase Menu");
        System.out.println("=======================");
    }
    public static void feed_Money_Display() {
        // prints out for our money feeder
        System.out.println();
        System.out.println("==================================");
        System.out.println("           Money Feeder");
        System.out.println("==================================");
        System.out.println();
        System.out.print("Enter Money Into Our Vending Machine: $");
    }
    public static void slot_Id_Input_Sign(){
        // used for our input for the ID slot codes
        System.out.print("Please Enter The ID Code: ");
    }

    public static void chip_Display () {
        // prints out for chips
        System.out.println();
        System.out.println("Crunch Crunch, Yum!");
    }
    public static void candy_Display () {
        // prints out for candy
        System.out.println();
        System.out.println("Munch Munch, Yum!");
    }
    public static void drink_Display () {
        // prints our for drinks
        System.out.println();
        System.out.println("Glug Glug, Yum!");
    }
    public static void gum_Display () {
        // prints out for gum
        System.out.println();
        System.out.println("Chew Chew, Yum!");
    }

    public static void out_Of_Stock_Display() {
        //used when items are out of stock
        System.out.println();
        System.out.println("This Item Is Currently Out Of Stock!");
    }
    public static void code_Does_Not_Exist(){
        //used when ID codes are not found in our map
        System.out.println();
        System.out.println("This Code Does Not Exist!");
    }
}
