package com.techelevator.view;

public class VendingMachineCLI {
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	// array of main menu options
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	// -------------------------------------------------------------------------------------
	private static final String DISPLAY_ITEMS_OPTION_MAIN_MENU = "Main Menu";

	// array of display menu options
	private static final String[] DISPLAY_ITEMS_OPTIONS = { MAIN_MENU_OPTION_PURCHASE, DISPLAY_ITEMS_OPTION_MAIN_MENU };

	// -------------------------------------------------------------------------------------
	private static final String PURCHASE_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_OPTION_TRANSACTION = "Finish Transaction";

	// array of purchase menu options
	private static final String[] PURCHASE_OPTIONS = { PURCHASE_OPTION_FEED_MONEY, PURCHASE_OPTION_SELECT_PRODUCT, PURCHASE_OPTION_TRANSACTION };
	// -------------------------------------------------------------------------------------


	// -------------------------------------------------------------------------------------
	// our main programs
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	// -------------------------------------------------------------------------------------
	// this code runs our whole vending machine
	public void run(String file) {

		// our welcome sign
		Displays.welcome_Sign();

		//reads inventory file before menu opens
		InventoryReader.items(file);

		while (true) {

			// creating a new balance of 0.00;
			Balance customer_Balance = new Balance();

			// this is what creates our main menu
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			// -------------------------------------------------------------------------------------
			// main menu options

			// if choice is on display items
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// this is our display sign on top
				Displays.display_Items_Sign();

				// this is our displayed items as a list
				InventoryReader.items_Displayer(choice);

				// this is our display menu options
				display(customer_Balance, choice);
			}

			// if choice is on purchase
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// this is our purchase menu options
				purchase(customer_Balance, choice);
			}

			// if choice is on exit
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

				// prints out exit sign
				Displays.exit_Sign();

				// this ends the program
				break;
			}
		}
	}

	//-------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		// reads file before running the program
		FileCheck file = new FileCheck();

		// runs the vending machine
		cli.run(file.getFile());
	}


	// -------------------------------------------------------------------------------------
	//                                    Our Menu Loops
	// -------------------------------------------------------------------------------------

	// this is our whole display items menu
	public void display(Balance balance,String choice) {

		// while it's in the display item option
		while(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

			// our display menu
			String display_choice = (String) menu.getChoiceFromOptions(DISPLAY_ITEMS_OPTIONS);

			// checks to see if new choice is purchase
			if(display_choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// goes into purchase menu
				purchase(balance, display_choice);

				//this break goes to main menu after purchase is done
				break;
			}

			// checks to see if new choice is in main menu
			else if (display_choice.equals(DISPLAY_ITEMS_OPTION_MAIN_MENU)) {

				// prints out main menu display
				Displays.main_Menu();

				// goes back to main menu
				break;
			}
		}
	}

	//-------------------------------------------------------------------------------------
	// this is our whole purchase menu
	public void purchase(Balance balance, String choice) {

		// while the choice is the purchase option
		while(choice.equals(MAIN_MENU_OPTION_PURCHASE)){

			// our purchase display menu on top
			Displays.purchase_Menu();

			// prints out current balance
			System.out.println();
			System.out.println("Current Money Provided: $" + balance.getBalance());

			// our purchase menu options
			String purchase_choice = (String) menu.getChoiceFromOptions(PURCHASE_OPTIONS);

			// checks if option is feed money
			if(purchase_choice.equals(PURCHASE_OPTION_FEED_MONEY)) {

				// allows customer to enter an amount
				menu.balance(balance);

			// our select purchase menu
			} else if (purchase_choice.equals(PURCHASE_OPTION_SELECT_PRODUCT)) {

				// allows customer to purchase an item
				select_Purchase(balance, purchase_choice);

			// our finish transaction menu
			} else if (purchase_choice.equals(PURCHASE_OPTION_TRANSACTION)) {

				// returns change back to the customer, in coins
				balance.remaining_Balance();

				// prints out main menu display
				Displays.main_Menu();

				// goes back to main menu
				break;
			}
		}
	}

	// -------------------------------------------------------------------------------------
	// our select purchase menu within our purchase menu
	public void select_Purchase(Balance balance, String choice) {

		// while the choice is on select product
		while (choice.equals(PURCHASE_OPTION_SELECT_PRODUCT)) {

			// displays items sign
			Displays.display_Items_Sign();

			// displays a list of items with ID and cost
			InventoryReader.items_Displayer(choice);

			// prints out a string for user input
			Displays.slot_Id_Input_Sign();

			// this is where customers can input ID code and purchase items
			InventoryReader.item_Purchaser(menu.customer_Id_Input(), balance);

			// goes back to purchase menu
			break;
		}
	}

	// our getters for other while loops
	public static String getMainMenuOptionDisplayItems() {
		return MAIN_MENU_OPTION_DISPLAY_ITEMS;
	}
	public static String getPurchaseOptionSelectProduct() {
		return PURCHASE_OPTION_SELECT_PRODUCT;
	}
}
