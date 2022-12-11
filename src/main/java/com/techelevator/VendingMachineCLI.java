package com.techelevator;

import com.techelevator.view.Customer_Balance;
import com.techelevator.view.File_Path;
import com.techelevator.view.Menu;
import com.techelevator.view.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachineCLI{

	private static final String MAIN_MENU_OPTION_MAIN_MENU = "Main Menu";
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_TRANSACTION = "Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] MAIN_MENU_OPTIONS_AFTER_DISPLAY = { MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_MAIN_MENU };

	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_PRODUCT, PURCHASE_MENU_OPTION_TRANSACTION};
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		menu.welcomeDisplay();
		//checking files to make sure it runs
		check_File();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display sign for display menu.
				menu.displayedItems();
				// reading file data
				products_List(check_File());
				// in a display menu for items
				display(choice);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchase_Menu(choice);
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
//				// exit menu
				menu.exitDisplay();
				break;
			}
		}
	}
	public Scanner check_File() throws FileNotFoundException {
		File_Path file_path = new File_Path();
		File dataFile = new File(file_path.getFile_Path());
		Scanner dataInput = new Scanner(dataFile);
		return dataInput;
	}

	public void products_List (Scanner check_File) {
		while (check_File.hasNextLine()) {
			String[] lineOfInput = check_File.nextLine().split("\\|");
			List <String> product_Info = Arrays.asList(lineOfInput);
			product_Info(product_Info);
		}
	}

	public void product_Info (List<String> product_Info) {
		Product item = new Product(product_Info.get(0), product_Info.get(1), product_Info.get(2), product_Info.get(3));
		System.out.println("Item: " + item.getProduct_Name() + "\n" + "In-Stock: " + item.getProduct_Amount());
//			System.out.println("ID: " + item.getSlot_Location() + "\n" + "Item: "+ item.getProduct_Name() + "\n" + "Cost: $" + item.getProduct_Price());
			System.out.println();
	}

	public void display(String choice) {
		while(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)){
			String choice_After_Display = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS_AFTER_DISPLAY);
			if (choice_After_Display.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchase_Menu(choice_After_Display);
				break;
			}
			if (choice_After_Display.equals(MAIN_MENU_OPTION_MAIN_MENU)) {
				break;
			}
		}
	}

	public void purchase_Menu(String choice) {
		Customer_Balance balance = new Customer_Balance();

		while(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
			System.out.println();
			System.out.println("Current Money Provided: $" + balance.getBalance());

			String choice_Purchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			if (choice_Purchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				menu.Balance(balance);
			}
			if (choice_Purchase.equals(PURCHASE_MENU_OPTION_PRODUCT)) {

			}
			if (choice_Purchase.equals(PURCHASE_MENU_OPTION_TRANSACTION)) {
				break;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
