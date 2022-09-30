package com.reservation.railway;

import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	Administrator admin;

	Main() {
		admin = new Administrator();
	}

	private void startLogin() {
		System.out.println("\nWelcome to the Railway Reservation System...");
		boolean flag = true;
		while (flag == true) {
			try {
				System.out.println("\n  1. Admin\n  2. Passenger\n");
				System.out.print("  Enter your choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.print("  Username : ");
					String username = sc.next();
					System.out.print("  Password : ");
					int password = sc.nextInt();
					if (admin.isAdmin(username, password)) {
						System.out.print("  Enter number of total tickets : ");
						admin.assignSeats(sc.nextInt());
					} else {
						System.out.println("  Invalid Username and Password");
					}
					break;
				case 2:
					flag = false;
					PassengerLogin passengerLogin = new PassengerLogin();
					passengerLogin.passengerLogin();
				}
			} catch (Exception e) {
				System.out.println(e);
				sc.next();
			}
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.startLogin();
	}
}