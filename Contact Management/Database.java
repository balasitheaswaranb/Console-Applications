package com.bala.contacts.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private String url = "jdbc:mysql://localhost:3306/contact_management";
	private String userName = "root";
	private String password = "Admin@123";
	private Connection connection;
	private static Database database;

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Database() {

	}

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
		}
		return database;
	}
}
