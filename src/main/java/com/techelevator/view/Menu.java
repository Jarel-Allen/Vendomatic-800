package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	// using menu user input to add balance to customer
	public void balance (Balance customer_balance) {

		// display of money feeder
		Menu_Display.feed_Money_Display();

		// user input
		String userInput = in.nextLine();

		// this checks to see if the input is a whole number
		try {
			int money = Integer.parseInt(userInput);

			// adds money from user input into balance
			customer_balance.add(money);
		}

		// if the user input isn't a whole number, it will print out a string
		catch (NumberFormatException e) {
			System.out.println();
			System.out.println("Please Enter a Whole Number.");
		}

	}

	// used for ID code input
	public String customer_Id_Input () {
		String userInput = in.nextLine();
		return userInput;
	}
}
