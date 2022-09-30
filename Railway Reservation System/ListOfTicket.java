package com.reservation.railway;

import java.util.HashMap;

public class ListOfTicket {
	Ticket ticketObj = new Ticket();
	HashMap<Integer, Passenger> passengerDetailsMap;

	private HashMap<Integer, Passenger> getValue() {
		passengerDetailsMap = ticketObj.getMap();
		return passengerDetailsMap;
	}

	public void ticketAvailabilityList() {
		if ((Seat.availableLowerBerth == 0) && (Seat.availableMiddleBerth == 0) && (Seat.availableUpperBerth == 0)
				&& (Seat.availableRAC == 0) && (Seat.availableWaitingList == 0)) {
			System.out.println("   All Tickets are Booked...  ");
		} else {
			System.out.println("  Available Upper Berths are         : " + Seat.availableUpperBerth);
			System.out.println("  Available Middle Berths are        : " + Seat.availableMiddleBerth);
			System.out.println("  Available Lower Berths are         : " + Seat.availableLowerBerth);
			System.out.println("  Available RAC Tickets are          : " + Seat.availableRAC);
			System.out.println("  Available Waiting List Tickets are : " + Seat.availableWaitingList);
		}
	}

	public void bookedTicketList() {
		passengerDetailsMap = getValue();
		// Ticket ticket = new Ticket();
		if (passengerDetailsMap.size() == 0) {
			System.out.println("  No Passengers Details Found...  ");
			return;
		} else {
			int i = 1;
			System.out.println(
					"\tS.No.\tPassengerID No.\tName\t\tAge\tGender\tAlloted Seat\tChildName\tChildAge\tGender ");
			for (Passenger pD : passengerDetailsMap.values()) {
				System.out.print("\t" + i++);
				System.out.print("\t\t" + pD.getPassengerId());
				System.out.print("\t" + pD.getName() + "\t");
				System.out.print("\t" + pD.getAge());
				System.out.print("\t" + pD.getGender());
				System.out.print("\t" + pD.getAlloted());
				if (pD.getChildName() == null && pD.getChildAge() == 0 && pD.getChildGender() == null) {
					System.out.print("\t\t***");
					System.out.print("\t\t***");
					System.out.println("\t\t***");
				} else {
					System.out.print("\t\t" + pD.getChildName());
					System.out.print("\t\t" + pD.getAge());
					System.out.println("\t" + pD.getGender());

				}
			}
		}
	}
}