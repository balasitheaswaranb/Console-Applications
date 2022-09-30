package com.reservation.railway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class PassengerLogin {

	public void passengerLogin() {
		int id = 1;
		Scanner scanner = new Scanner(System.in);
		Ticket ticket = new Ticket();
		ListOfTicket list = new ListOfTicket();
		ticket.confirmedTicketList = new ArrayList<Integer>();
		ticket.racQueue = new LinkedList<Integer>();
		ticket.waitingListQueue = new LinkedList<Integer>();
		ticket.passengerDetailsMap = new HashMap<Integer, Passenger>();
		boolean flag = true;
		while (flag) {
			try {
				System.out.println(
						"  *************************\n  1. Book Ticket.\n  2. Cancel Ticket\n  3. Booked Tickets List.\n "
								+ " 4. Available Tickets List.\n  5. Exit.\n  *************************\n ");
				System.out.print("  Enter your choice : ");
				int choice = scanner.nextInt();
				if (choice <= 5) {
					switch (choice) {
					case 1:
						Passenger passenger = new Passenger();
						System.out.print("  Enter passenger's Name                                     : ");
						passenger.setName(scanner.next());
						System.out.print("  Enter passenger's Age                                      : ");
						int age = scanner.nextInt();
						if (age <= 100 && age > 5) {
							passenger.setAge(age);
						} else {
							System.out.println("  Pleas enter valid age ");
							break;
						}
						System.out.print("  Enter passenger's Gender as [MALE press 1 ,FEMALE press 2] : ");
						int gender = scanner.nextInt();
						if (gender == 1) {
							passenger.setGender(Passenger.Gender.MALE);
						} else if (gender == 2) {
							passenger.setGender(Passenger.Gender.FEMALE);
						} else {
							System.out.println("  Please enter the correct option !!");
							break;
						}
						if (passenger.getGender() == Passenger.Gender.MALE
								|| passenger.getGender() == Passenger.Gender.FEMALE) {
							System.out.println("\tYou travel with your child under 5 or equal old ?");
							System.out.println("\t1. Yes.");
							System.out.println("\t2. No means click any number.");
							System.out.print("\tEnter your choice : ");
							int gChoice = scanner.nextInt();
							if (gChoice == 1) {
								System.out.print("\tEnter your child's Name               : ");
								passenger.setChildName(scanner.next());
								System.out.print("\tEnter your child's Age                : ");
								int childAge = scanner.nextInt();
								if (childAge <= 5) {
									passenger.setChildAge(childAge);
								} else {
									System.out.println("  please enter valid age !! ");
									break;
								}
								System.out.print("\tEnter your child's Gender as [FEMALE or MALE] : ");
								passenger.setChildGender(scanner.next());
							} else {
								passenger.setChildName(null);
								passenger.setChildAge(0);
								passenger.setChildGender(null);
							}
						}
						System.out.print(
								"  Enter passenger's Berth Preference as [UPPER press 1 or MIDDLE press 2 or LOWER press 3 ] : ");
						int berth = scanner.nextInt();
						if (berth == 1) {
							passenger.setBerthPreference(Passenger.Berthpreference.UPPER);
						} else if (berth == 2) {
							passenger.setBerthPreference(Passenger.Berthpreference.MIDDLE);
						} else if (berth == 3) {
							passenger.setBerthPreference(Passenger.Berthpreference.LOWER);
						} else {
							System.out.println("  Enter the correct option!!");
						}
						passenger.setPassengerId(id++);
						ticket.ticketBooking(passenger);
						break;
					case 2:
						System.out.print("  Enter your PassengerID : ");
						int passengerID = scanner.nextInt();
						ticket.ticketCancelling(passengerID);
						break;
					case 3:
						list.bookedTicketList();
						break;
					case 4:
						list.ticketAvailabilityList();
						break;
					case 5:
						System.out.println("..........Thankyou please visit again..........");
						flag = false;
						break;
					}
				} else {
					System.out.println("  Please enter correct option ? ");
					flag = true;
				}
			} catch (Exception e) {
				System.out.println(e);
				scanner.next();
			}
		}
		scanner.close();
	}

}
