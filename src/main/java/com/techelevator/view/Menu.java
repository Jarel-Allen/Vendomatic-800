package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
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

	public void Balance (Customer_Balance balance) {
		System.out.println();
		System.out.println("Enter the amount of money to feed: ");
		String userInput = in.nextLine();
		int money = Integer.parseInt(userInput);
		balance.add(money);
	}

	public void welcomeDisplay() {
		System.out.println();
		System.out.println("=======================================");
		System.out.println("Welcome to our Virtual Vending Machine!");
		System.out.println("=======================================");
		System.out.println();
	}
	public void exitDisplay() {
		System.out.println();
		System.out.println("=======================================");
		System.out.println(" Exiting our Virtual Vending Machine!");
		System.out.println("=======================================");
	}

	public void displayedItems(){
		System.out.println();
		System.out.println("===========================");
		System.out.println(" Displaying Items by Type:");
		System.out.println("===========================");
		System.out.println();
	}

}
