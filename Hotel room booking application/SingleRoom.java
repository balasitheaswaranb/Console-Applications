package com.bookings.hotel.rooms;

import java.util.ArrayList;
import java.util.List;

public class SingleRoom {
	private String customerName;
	private String customerContactNumber;
	private String gender;
	private List<Food> food = new ArrayList<>();

	SingleRoom(String name, String contact, String gender) {
		this.customerName = name;
		this.customerContactNumber = contact;
		this.gender = gender;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public String getContactNumber() {
		return customerContactNumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setPatients(List<Food> food) {
		this.food = food;
	}

	SingleRoom() {
		this.customerName = "";
	}
}