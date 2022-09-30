package com.bookings.hotel.rooms;

public class LoginController {
	public boolean checkCredentials(String userName, String password) {
		return userName.equals("admin") && password.equals("12345");
	}
}
