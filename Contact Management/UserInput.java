package com.bala.contacts.management;

import java.util.Scanner;

public class UserInput {
	Scanner scanner = new Scanner(System.in);
	Process process;

	UserInput() {
		process = new Process();
	}

	public void printOptions() {
		System.out.println("\nPress");
		System.out.println("\t0 - To print choice options.");
		System.out.println("\t1 - To print the list of contacts.");
		System.out.println("\t2 - To add a new contact.");
		System.out.println("\t3 - To modify an existing contact.");
		System.out.println("\t4 - To remove a contact from the list.");
		System.out.println("\t5 - To find a contact in the list.");
		System.out.println("\t6 - To quit the application.");
	}

	public void addContacts() {
		System.out.print("Enter new contact name: ");
		String newContactName = scanner.nextLine();
		System.out.print("Enter phone number: ");
		String phoneNumber = scanner.nextLine();
		process.addNewContact(newContactName, phoneNumber);
	}

	public void modifyContact() {
		System.out.print("Enter contact name to update: ");
		String contactNameToUpdate = scanner.nextLine();
		System.out.print("Enter a new phone number: ");
		String newPhoneNumber = scanner.nextLine();
		process.updateContact(contactNameToUpdate, newPhoneNumber);
	}

	public void removeContact() {
		System.out.print("Specify a contact to delete: ");
		String contactToDelete = scanner.nextLine();
		process.removeContact(contactToDelete);
	}

	public void findContact() {
		System.out.print("Type a contact name to find: ");
		String queryContact = scanner.nextLine();
		process.queryContact(queryContact);
	}
}
