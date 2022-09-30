package com.bala.contacts.management;

import java.util.ArrayList;
import java.util.Iterator;

public class Process {

	private final ArrayList<Contacts> contactsArrayList = new ArrayList<>();

	public void printAllContacts() {
		Iterator<Contacts> contactsIterator = contactsArrayList.iterator();
		while (contactsIterator.hasNext()) {
			Contacts nextContact = contactsIterator.next();
			System.out.println((contactsArrayList.indexOf(nextContact) + 1) + ". Contact name: " + nextContact.getName()
					+ ", phone number: " + nextContact.getPhoneNumber());
		}
		checkForNull();
	}

	private void checkForNull() {
		if (contactsArrayList.size() == 0) {
			System.out.println("The contact list is empty.");
		}
	}

	public void addNewContact(String name, String phoneNumber) {
		Contacts resultLoop = iterateContacts(name);
		if (resultLoop != null) {
			System.out.println("There is a contact with this name: " + name);
			System.out.println("Please try to use different contact name.");
		} else {
			Contacts newContact = new Contacts(name, phoneNumber);
			contactsArrayList.add(newContact);
			System.out.println("New contact created. Name: " + newContact.getName() + ", phone number: "
					+ newContact.getPhoneNumber());
		}
	}

	public void updateContact(String contactName, String newPhoneNumber) {

		Contacts resultLoop = iterateContacts(contactName);
		if (resultLoop != null) {
			resultLoop.setPhoneNumber(newPhoneNumber);
			System.out.println("Phone number updated for " + resultLoop.getName() + ". New phone number: "
					+ resultLoop.getPhoneNumber());
		} else {
			System.out.println("There is no contact with this " + contactName + " contact name.");
			System.out.println("Please try to add a new contact!");
		}
	}

	public void removeContact(String contactName) {
		Contacts resultLoop = iterateContacts(contactName);
		if (resultLoop != null) {
			contactsArrayList.remove(resultLoop);
			System.out.println(resultLoop.getName() + " -> this contact was deleted.");
		} else {
			System.out.println("This contact doesn't exist.");
		}
	}

	public void queryContact(String contactName) {
		Contacts resultLoop = iterateContacts(contactName);
		if (resultLoop != null) {
			System.out.println("Contact: " + resultLoop.getName() + " , phone number: " + resultLoop.getPhoneNumber());
		} else {
			System.out.println("This contact doesn't exist");
		}
	}

	private Contacts iterateContacts(String name) {
		Iterator<Contacts> contactsIterator = contactsArrayList.iterator();
		while (contactsIterator.hasNext()) {
			Contacts currentContact = contactsIterator.next();
			if (currentContact.getName().equals(name)) {
				return currentContact;
			}
		}
		return null;
	}
}
