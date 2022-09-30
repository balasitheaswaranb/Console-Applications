package com.bala.contacts.management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);
	UserInput userInput;

	Main() {
		userInput = new UserInput();
	}

	private void initiate() {
		boolean quit = false;
		int choice;
		userInput.printOptions();
		while (!quit) {
			try {
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 0:
				userInput.printOptions();
				break;
			case 1:
				userInput.process.printAllContacts();
				break;
			case 2:
				userInput.addContacts();
				break;
			case 3:
				userInput.modifyContact();
				break;
			case 4:
				userInput.removeContact();
				break;
			case 5:
				userInput.findContact();
				break;
			case 6:
				quit = true;
				break;
			default:
				System.out.println("Please enter a valid input!");
			}
			}catch(InputMismatchException e) {
				e.printStackTrace();
				scanner.next();
			}
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initiate();
	}
}
