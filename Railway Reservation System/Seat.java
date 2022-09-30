package com.reservation.railway;

public class Seat {
	static int availableLowerBerth = 1;
	static int availableUpperBerth = 1;
	static int availableMiddleBerth = 1;
	static int availableRAC = 1;
	static int availableWaitingList = 1;

	public void seatAllocation(Passenger passenger) {
		if (passenger.getAge() > 60 && Seat.availableLowerBerth > 0) {
			System.out.println("  You're a Senior citizen, so we allocate a Lower Berth.");
			Seat.availableLowerBerth--;
			passenger.setAlloted(Passenger.Alloted.LOWER);
		} else if (passenger.getChildName() != null && Seat.availableLowerBerth > 0) {
			System.out.println("  You have a child, so we allocate a Lower Berth...  ");
			Seat.availableLowerBerth--;
			passenger.setAlloted(Passenger.Alloted.LOWER);
		} else if ((passenger.getBerthPreference() == Passenger.Berthpreference.LOWER && availableLowerBerth > 0)
				|| (passenger.getBerthPreference() == Passenger.Berthpreference.MIDDLE && availableMiddleBerth > 0)
				|| (passenger.getBerthPreference() == Passenger.Berthpreference.UPPER && availableUpperBerth > 0)) {
			if (passenger.getBerthPreference() == Passenger.Berthpreference.LOWER) {
				System.out.println("  Lower Berth is Alloted...   ");
				Seat.availableLowerBerth--;
				passenger.setAlloted(Passenger.Alloted.LOWER);
			} else if (passenger.getBerthPreference() == Passenger.Berthpreference.MIDDLE) {
				System.out.println("  Middle Berth is Alloted...  ");
				Seat.availableMiddleBerth--;
				passenger.setAlloted(Passenger.Alloted.MIDDLE);
			} else if (passenger.getBerthPreference() == Passenger.Berthpreference.UPPER) {
				System.out.println("  Upper Berth is Alloted...  ");
				Seat.availableUpperBerth--;
				passenger.setAlloted(Passenger.Alloted.UPPER);
			}
		} else if (availableLowerBerth > 0) {
			System.out.println("  Prefered berth is not available...  ");
			System.out.println("  Lower Berth is Alloted...  ");
			Seat.availableLowerBerth--;
			passenger.setAlloted(Passenger.Alloted.LOWER);
		} else if (availableMiddleBerth > 0) {
			System.out.println("  Prefered berth is not available...  ");
			System.out.println("  Middle Berth is Alloted...  ");
			Seat.availableMiddleBerth--;
			passenger.setAlloted(Passenger.Alloted.MIDDLE);
		} else if (availableUpperBerth > 0) {
			System.out.println("  Prefered berth is not available...  ");
			System.out.println("  Upper Berth is Alloted...   ");
			Seat.availableUpperBerth--;
			passenger.setAlloted(Passenger.Alloted.UPPER);
		} else if (availableRAC > 0) {
			System.out.println("  Prefered berth is not available...  ");
			System.out.println("  Your're in RAC List...   ");
			Seat.availableRAC--;
			passenger.setAlloted(Passenger.Alloted.RAC);
		} else if (availableWaitingList > 0) {
			System.out.println("  Prefered berth is not available...  ");
			System.out.println("  You're in Waiting List...  ");
			Seat.availableWaitingList--;
			passenger.setAlloted(Passenger.Alloted.WAITINGLIST);
		}
	}

}