package com.reservation.railway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ticket {

	ArrayList<Integer> confirmedTicketList;
	Queue<Integer> racQueue;
	Queue<Integer> waitingListQueue;
	HashMap<Integer, Passenger> passengerDetailsMap;
	Seat seat;

	Ticket() {
		seat = new Seat();
	}

	public void ticketBooking(Passenger passenger) {
		if (Seat.availableWaitingList == 0) {
			System.out.println("  No tickets are available...  ");
		} else {
			seat.seatAllocation(passenger);
			ticketAllocation(passenger);
		}
	}

	public void ticketAllocation(Passenger passenger) {
		if (passenger.getAlloted() == Passenger.Alloted.LOWER || passenger.getAlloted() == Passenger.Alloted.MIDDLE
				|| passenger.getAlloted() == Passenger.Alloted.UPPER) {
			confirmedTicketList.add(passenger.getPassengerId());

		} else if (passenger.getAlloted() == Passenger.Alloted.RAC) {
			racQueue.add(passenger.getPassengerId());
		} else if (passenger.getAlloted() == Passenger.Alloted.WAITINGLIST) {
			waitingListQueue.add(passenger.getPassengerId());
		}

		passengerDetailsMap.put(passenger.getPassengerId(), passenger);
		System.out.println("  Passenger ID is     : " + passenger.getPassengerId());
		System.out.println("  Passenger Name is   : " + passenger.getName());
		System.out.println("  Passenger Age is    : " + passenger.getAge());
		System.out.println("  Passenger Gender is : " + passenger.getGender());

		if ((passenger.getChildName() != null)) {
			System.out.println("  Passenger Child Name is   : " + passenger.getChildName());
			System.out.println("  Passenger Child Age is    : " + passenger.getChildAge());
			System.out.println("  Passenger Child Gender is : " + passenger.getChildGender());
		}

		System.out.println("  Alloted Berth is    : " + passenger.getAlloted());
		System.out.println("  ---------------Ticket Booked Successfully..!---------------\n");
	}

	public void ticketCancelling(int passengerId) {

		if (passengerDetailsMap.containsKey(passengerId)) {
			Passenger passenger = passengerDetailsMap.get(passengerId);
			if (passenger.getAlloted() == Passenger.Alloted.WAITINGLIST) {
				passengerDetailsMap.remove(passengerId);
				waitingListQueue.remove(passengerId);
				Seat.availableWaitingList++;
				System.out.println("  ---------------Your Ticket is Cancelled..!---------------\n");
			} else if (passenger.getAlloted() == Passenger.Alloted.RAC) {
				System.out.println("  You are not able to cancel RAC ticket");
			} else {
				passengerDetailsMap.remove(passengerId);
				confirmedTicketList.remove(Integer.valueOf(passengerId));

				if (passenger.getAlloted() == Passenger.Alloted.LOWER) {
					Seat.availableLowerBerth++;
				} else if (passenger.getAlloted() == Passenger.Alloted.MIDDLE) {
					Seat.availableMiddleBerth++;
				} else if (passenger.getAlloted() == Passenger.Alloted.UPPER) {
					Seat.availableUpperBerth++;
				}

				System.out.println("  ---------------Your Ticket is Cancelled..!---------------\n");

				if (racQueue.size() > 0) {
					passengerId = racQueue.poll();
					passenger = passengerDetailsMap.get(passengerId);
					seat.seatAllocation(passenger);
					confirmedTicketList.add(passengerId);
					passengerDetailsMap.put(passengerId, passenger);
					Seat.availableRAC++;
					if (waitingListQueue.size() > 0) {
						passengerId = waitingListQueue.poll();
						passenger = passengerDetailsMap.get(passengerId);
						seat.seatAllocation(passenger);
						racQueue.add(passengerId);
						passengerDetailsMap.put(passengerId, passenger);
						Seat.availableWaitingList++;
					}
				}
			}
		} else {
			System.out.println("  Please enter the valid Passenger's ID.");
		}
	}

	public HashMap<Integer, Passenger> getMap() {
		return passengerDetailsMap;
	}
}
