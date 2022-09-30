package com.bookings.hotel.rooms;

import java.util.Scanner;

public class Receptionist {
	Scanner scanner = new Scanner(System.in);
	DoubleRoom luxuryDoubleRooms[];
	DoubleRoom deluxeDoubleRooms[];
	SingleRoom luxurySingleRooms[];
	SingleRoom deluxeSingleRooms[];

	Receptionist() {
		luxuryDoubleRooms = new DoubleRoom[10];
		deluxeDoubleRooms = new DoubleRoom[20];
		luxurySingleRooms = new SingleRoom[10];
		deluxeSingleRooms = new SingleRoom[20];
	}

	public void roomFeatures(int option) {
		switch (option) {
		case 1:
			System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
			break;
		case 2:
			System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
			break;
		case 3:
			System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
			break;
		case 4:
			System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
	}

	public void roomAvailability(int option) {
		int j, count = 0;
		switch (option) {
		case 1:
			for (j = 0; j < luxuryDoubleRooms.length; j++) {
				if (luxuryDoubleRooms[j] == null)
					count++;
			}
			break;
		case 2:
			for (j = 0; j < deluxeDoubleRooms.length; j++) {
				if (deluxeDoubleRooms[j] == null)
					count++;
			}
			break;
		case 3:
			for (j = 0; j < luxurySingleRooms.length; j++) {
				if (luxurySingleRooms[j] == null)
					count++;
			}
			break;
		case 4:
			for (j = 0; j < deluxeSingleRooms.length; j++) {
				if (deluxeSingleRooms[j] == null)
					count++;
			}
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		System.out.println("Number of rooms available : " + count);
	}

	public void bookRoom(int roomType) {
		int j, roomNumber;
		System.out.println("\nChoose room number from : ");
		switch (roomType) {
		case 1:
			for (j = 0; j < luxuryDoubleRooms.length; j++) {
				if (luxuryDoubleRooms[j] == null) {
					System.out.print(j + 1 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				roomNumber--;
				if (luxuryDoubleRooms[roomNumber] != null)
					throw new Exception();
				customerDetails(roomType, roomNumber);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 2:
			for (j = 0; j < deluxeDoubleRooms.length; j++) {
				if (deluxeDoubleRooms[j] == null) {
					System.out.print(j + 11 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				roomNumber = roomNumber - 11;
				if (deluxeDoubleRooms[roomNumber] != null)
					throw new Exception();
				customerDetails(roomType, roomNumber);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 3:
			for (j = 0; j < luxurySingleRooms.length; j++) {
				if (luxurySingleRooms[j] == null) {
					System.out.print(j + 31 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				roomNumber = roomNumber - 31;
				if (luxurySingleRooms[roomNumber] != null)
					throw new Exception();
				customerDetails(roomType, roomNumber);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 4:
			for (j = 0; j < deluxeSingleRooms.length; j++) {
				if (deluxeSingleRooms[j] == null) {
					System.out.print(j + 41 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				roomNumber = roomNumber - 41;
				if (deluxeSingleRooms[roomNumber] != null)
					throw new Exception();
				customerDetails(roomType, roomNumber);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		System.out.println("Room Booked");
	}

	public void customerDetails(int roomType, int roomNumber) {
		String name, contact, gender;
		String name2 = null, contact2 = null;
		String gender2 = null;
		System.out.print("\nEnter customer name: ");
		name = scanner.next();
		System.out.print("Enter contact number: ");
		contact = scanner.next();
		System.out.print("Enter gender: ");
		gender = scanner.next();
		if (roomType < 3) {
			System.out.print("Enter second customer name: ");
			name2 = scanner.next();
			System.out.print("Enter contact number: ");
			contact2 = scanner.next();
			System.out.print("Enter gender: ");
			gender2 = scanner.next();
		}
		switch (roomType) {
		case 1:
			luxuryDoubleRooms[roomNumber] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
			break;
		case 2:
			deluxeDoubleRooms[roomNumber] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
			break;
		case 3:
			luxurySingleRooms[roomNumber] = new SingleRoom(name, contact, gender);
			break;
		case 4:
			deluxeSingleRooms[roomNumber] = new SingleRoom(name, contact, gender);
			break;
		default:
			System.out.println("Wrong option");
			break;
		}
	}

	public void orderFood(int RoomNumber, int roomType) {
		int chosenFood, quantity;
		char wantMore;
		try {
			System.out.println(
					"\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
			do {
				chosenFood = scanner.nextInt();
				System.out.print("Quantity- ");
				quantity = scanner.nextInt();

				switch (roomType) {
				case 1:
					luxuryDoubleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				case 2:
					deluxeDoubleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				case 3:
					luxurySingleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				case 4:
					deluxeSingleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				}
				System.out.println("Do you want to order anything else? (y/n)");
				wantMore = scanner.next().charAt(0);
			} while (wantMore == 'y' || wantMore == 'Y');
		} catch (NullPointerException e) {
			System.out.println("\nRoom not booked");
		} catch (Exception e) {
			System.out.println("Cannot be done");
		}
	}

	public void vecateRoom(int roomNumber, int roomType) {
		char option;
		switch (roomType) {
		case 1:
			if (luxuryDoubleRooms[roomNumber] != null)
				System.out.println("Room used by " + luxuryDoubleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println("Do you want to checkout ?(y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				luxuryDoubleRooms[roomNumber] = null;
				System.out.println("Deallocated succesfully");
			}
			break;
		case 2:
			if (deluxeDoubleRooms[roomNumber] != null)
				System.out.println("Room used by " + deluxeDoubleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ?(y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				deluxeDoubleRooms[roomNumber] = null;
				System.out.println("Deallocated succesfully");
			}
			break;
		case 3:
			if (luxurySingleRooms[roomNumber] != null)
				System.out.println("Room used by " + luxurySingleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ? (y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				luxurySingleRooms[roomNumber] = null;
				System.out.println("Deallocated succesfully");
			}
			break;
		case 4:
			if (deluxeSingleRooms[roomNumber] != null)
				System.out.println("Room used by " + deluxeSingleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already!");
				return;
			}
			System.out.println(" Do you want to checkout? (y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				deluxeSingleRooms[roomNumber] = null;
				System.out.println("Deallocated successfully");
			}
			break;
		default:
			System.out.println("\nEnter a valid option : ");
			break;
		}
	}

	public void generateBill(int roomNumber, int roomType) {
		double amount = 0;
		String list[] = { "Sandwich", "Pasta", "Noodles", "Coke" };
		System.out.println("\n*******");
		System.out.println(" Bill:-");
		System.out.println("*******");

		switch (roomType) {
		case 1:
			amount += 4000;
			System.out.println("\nRoom Charge - " + 4000);
			System.out.println("\n===============");
			System.out.println("Food Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : luxuryDoubleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				String format = "%-10s%-10s%-10s%n";
				System.out.printf(format, list[food.getChosenFoodNo() - 1], food.getQuantity(), food.getCost());
			}

			break;
		case 2:
			amount += 3000;
			System.out.println("Room Charge - " + 3000);
			System.out.println("\nFood Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : deluxeDoubleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				String format = "%-10s%-10s%-10s%n";
				System.out.printf(format, list[food.getChosenFoodNo() - 1], food.getQuantity(), food.getCost());
			}
			break;
		case 3:
			amount += 2200;
			System.out.println("Room Charge - " + 2200);
			System.out.println("\nFood Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : luxurySingleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				String format = "%-10s%-10s%-10s%n";
				System.out.printf(format, list[food.getChosenFoodNo() - 1], food.getQuantity(), food.getCost());
			}
			break;
		case 4:
			amount += 1200;
			System.out.println("Room Charge - " + 1200);
			System.out.println("\nFood Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : deluxeSingleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				String format = "%-10s%-10s%-10s%n";
				System.out.printf(format, list[food.getChosenFoodNo() - 1], food.getQuantity(), food.getCost());
			}
			break;
		default:
			System.out.println("Not valid");
		}
		System.out.println("\nTotal Amount- " + amount);
	}
}