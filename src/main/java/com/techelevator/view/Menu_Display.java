package com.techelevator.view;

public class Menu_Display {
    public static void welcome_Sign() {
        System.out.println();
        System.out.println("========================================");
        System.out.println(" Welcome to our Virtual Vending Machine");
        System.out.println("========================================");
    }

    public static void main_Menu() {
        System.out.println();
        System.out.println("===================");
        System.out.println("     Main Menu     ");
        System.out.println("===================");
    }

    public static void display_Items_Sign() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("       List Of All Our Snacks");
        System.out.println("====================================");
        System.out.println();
    }

    public static void purchase_Menu() {
        System.out.println();
        System.out.println("=======================");
        System.out.println("     Purchase Menu");
        System.out.println("=======================");
    }
    public static void feed_Money_Display() {
        System.out.println();
        System.out.println("==================================");
        System.out.println("           Money Feeder");
        System.out.println("==================================");
        System.out.println();
        System.out.print("Enter Money Into Our Vending Machine: $");
    }
    public static void slot_Id_Input_Sign(){
        System.out.print("Please Enter The ID Code: ");
    }

    public static void chip_Display () {
        System.out.println();
        System.out.println("Crunch Crunch, Yum!");
    }
    public static void candy_Display () {
        System.out.println();
        System.out.println("Munch Munch, Yum!");
    }
    public static void drink_Display () {
        System.out.println();
        System.out.println("Glug Glug, Yum!");
    }
    public static void gum_Display () {
        System.out.println();
        System.out.println("Chew Chew, Yum!");
    }

    public static void out_Of_Stock_Display() {
        System.out.println();
        System.out.println("This Item Is Currently Out Of Stock!");
    }
    public static void code_Does_Not_Exist(){
        System.out.println();
        System.out.println("This Code Does Not Exist!");
    }
}
