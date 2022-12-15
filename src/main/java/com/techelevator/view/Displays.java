package com.techelevator.view;

public class Displays {
    public static void welcome_Sign() {
        // this is used at the beginning when the code first runs
        System.out.println("\n" + "========================================");
        System.out.println(" Welcome to our Virtual Vending Machine");
        System.out.println("========================================");
    }
    public static void exit_Sign() {
        // this is used at the beginning when the code first runs
        System.out.println("\n" + "=================================================");
        System.out.println(" Thank You For Using Our Virtual Vending Machine");
        System.out.println("=================================================");
    }

    public static void main_Menu() {
        // prints out main menu
        System.out.println("\n" + "===================");
        System.out.println("     Main Menu     ");
        System.out.println("===================");
    }

    public static void display_Items_Sign() {
        // used when we list out our snacks
        System.out.println("\n" + "====================================");
        System.out.println("       List Of All Our Snacks");
        System.out.println("===================================="+ "\n");
    }

    public static void purchase_Menu() {
        // prints out purchase menu
        System.out.println("\n" + "=======================");
        System.out.println("     Purchase Menu");
        System.out.println("=======================");
    }
    public static void feed_Money_Display() {
        // prints out for our money feeder
        System.out.println("\n" + "==================================");
        System.out.println("           Money Feeder");
        System.out.println("==================================" + "\n");
        System.out.print("Enter Money Into Our Vending Machine: $");
    }
    public static void slot_Id_Input_Sign(){
        // used for our input for the ID slot codes
        System.out.print("Please Enter The ID Code: ");
    }

    public static void out_Of_Stock_Display() {
        //used when items are out of stock
        System.out.println("\n"+"This Item Is Currently Out Of Stock!");
    }
}
