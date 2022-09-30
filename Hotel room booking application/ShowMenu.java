package com.bookings.hotel.rooms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowMenu {
	Scanner scanner = new Scanner(System.in);
	Receptionist receptionist;

	ShowMenu() {
		receptionist = new Receptionist();
	}

	public void showMenu() {
		try {

			int option, roomType, roomNumber;
			char wantToContinue;
			do {

				System.out.println("\nEnter Your Choice :\n1.Show Room Details\n"
						+ "2.Show Room Availability \n3.Book Room\n4.Order Food\n5.Checkout Now\n6.Quit\n");
				option = scanner.nextInt();
				switch (option) {
				case 1:
					System.out.println(
							"\nChoose Room Type :\n1.Luxury Double Bedroom \n2.Deluxe Double Bedroom"
							+ " \n3.Luxury Single Bedroom \n4.Deluxe Single Bedroom \n");
					roomType = scanner.nextInt();
					receptionist.roomFeatures(roomType);
					break;
				case 2:
					System.out.println(
							"\nChoose Room Type :\n1.Luxury Double Bedroom\n2.Deluxe Double Bedroom\n3."
							+ "Luxury Single Bedroom\n4.Deluxe Single Bedroom\n");
					roomType = scanner.nextInt();
					receptionist.roomAvailability(roomType);
					break;
				case 3:
					System.out.println(
							"\nChoose Room Type :\n1.Luxury Double Bedroom\n2.Deluxe Double Bedroom\n3"
							+ ".Luxury Single Bedroom\n4.Deluxe Single Bedroom\n");
					roomType = scanner.nextInt();
					receptionist.bookRoom(roomType);
					break;
				case 4:
					System.out.print("Room Number -");
					roomNumber = scanner.nextInt();
					if (roomNumber > 60)
						System.out.println("Room doesn't exist");
					else if (roomNumber > 40)
						receptionist.orderFood(roomNumber - 41, 4);
					else if (roomNumber > 30)
						receptionist.orderFood(roomNumber - 31, 3);
					else if (roomNumber > 10)
						receptionist.orderFood(roomNumber - 11, 2);
					else if (roomNumber > 0)
						receptionist.orderFood(roomNumber - 1, 1);
					else
						System.out.println("Room doesn't exist");
					break;
				case 5:
					System.out.print("Room Number -");
					roomNumber = scanner.nextInt();
					if (roomNumber > 60)
						System.out.println("Room doesn't exist");
					else if (roomNumber > 40)
						receptionist.vecateRoom(roomNumber - 41, 4);
					else if (roomNumber > 30)
						receptionist.vecateRoom(roomNumber - 31, 3);
					else if (roomNumber > 10)
						receptionist.vecateRoom(roomNumber - 11, 2);
					else if (roomNumber > 0)
						receptionist.vecateRoom(roomNumber - 1, 1);
					else
						System.out.println("Room doesn't exist");
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid Option!");
				}
				System.out.println("\nContinue : (y/n)");
				wantToContinue = scanner.next().charAt(0);
				if (!(wantToContinue == 'y' || wantToContinue == 'Y' || wantToContinue == 'n'
						|| wantToContinue == 'N')) {
					System.out.println("Invalid Option!");
					System.out.println("\nContinue : (y/n)");
					wantToContinue = scanner.next().charAt(0);
				}

			} while (wantToContinue == 'y' || wantToContinue == 'Y');

		} catch (InputMismatchException e) {
			System.out.println("Not a valid input!");
		}
	}
}