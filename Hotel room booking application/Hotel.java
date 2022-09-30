package com.bookings.hotel.rooms;

import java.util.Scanner;

public class Hotel {
	Scanner scanner = new Scanner(System.in);
	private LoginController loginControler;

	Hotel() {
		loginControler = new LoginController();
	}

	private void start() {
		System.out.println("Welcome to Hotel Management System\n ------------------------");
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		if (loginControler.checkCredentials(userName, password)) {
			System.out.println("\n-->Welcome " + userName + "<--\n");
			ShowMenu showMenu = new ShowMenu();
			showMenu.showMenu();
		} else {
			System.out.println("\nInvalid Credentials. Please try again!\n");
			checkForLogin();
		}
	}

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.start();
	}
}