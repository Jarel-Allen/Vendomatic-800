package com.techelevator.view;

public class VendingMachineCLI {
	//List of our menu options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	//-------------------------------------------------------------------------------------
	private static final String DISPLAY_ITEMS_OPTION_MAIN_MENU = "Main Menu";
	private static final String[] DISPLAY_ITEMS_OPTIONS = { MAIN_MENU_OPTION_PURCHASE, DISPLAY_ITEMS_OPTION_MAIN_MENU };
	//-------------------------------------------------------------------------------------
	private static final String PURCHASE_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_OPTION_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_OPTIONS = { PURCHASE_OPTION_FEED_MONEY, PURCHASE_OPTION_SELECT_PRODUCT, PURCHASE_OPTION_TRANSACTION };
	//-------------------------------------------------------------------------------------
	//our main programs
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run(String file) {
		Menu_Display.welcome_Sign();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				//this is our display sign on top
				Menu_Display.display_Items_Sign();

				//this is our displayed items as a list
				Display_List.items(file);

				//this is our display menu options
				display(choice, file);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				//this is our purchase menu options
				purchase(choice, file);

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		//reads file before running the program
		File_Reader file = new File_Reader();

		cli.run(file.getFile());
	}
	//-------------------------------------------------------------------------------------
	//                                   Our Menu Loops
	//-------------------------------------------------------------------------------------
	public void display(String choice, String file) {
		while(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			//our display menu
			String display_choice = (String) menu.getChoiceFromOptions(DISPLAY_ITEMS_OPTIONS);
			if(display_choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchase(display_choice, file);
				break;
			} else if (display_choice.equals(DISPLAY_ITEMS_OPTION_MAIN_MENU)) {
				break;
			}
		}
	}
	public void purchase(String choice, String file) {
		Balance customer_Balance = new Balance();

		while(choice.equals(MAIN_MENU_OPTION_PURCHASE)){
			//our purchase display menu on top
			Menu_Display.purchase_Menu();

			System.out.println();
			System.out.println("Current Money Provided: $" + customer_Balance.getBalance());

			//our purchase menu
			String purchase_choice = (String) menu.getChoiceFromOptions(PURCHASE_OPTIONS);
			if(purchase_choice.equals(PURCHASE_OPTION_FEED_MONEY)) {
				//allows customer to enter an amount
				menu.balance(customer_Balance);
			} else if (purchase_choice.equals(PURCHASE_OPTION_SELECT_PRODUCT)) {
				//displays a list of items with ID and cost
				Menu_Display.purchase_Item_Sign();
				Display_List.purchase_Items(file);
			} else if (purchase_choice.equals(PURCHASE_OPTION_TRANSACTION)) {
				break;
			}
		}
	}


}
