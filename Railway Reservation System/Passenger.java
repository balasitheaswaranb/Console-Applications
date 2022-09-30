package com.reservation.railway;

public class Passenger {

	private int passengerId;
	private String name;
	private int age;
	private Gender gender;
	private String childName;
	private int childAge;
	private String childGender;
	private Alloted alloted;
	private  Berthpreference berthpreference;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public int getChildAge() {
		return childAge;
	}

	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}

	public String getChildGender() {
		return childGender;
	}

	public void setChildGender(String childGender) {
		this.childGender = childGender;
	}

	public Alloted getAlloted() {
		return alloted;
	}

	public void setAlloted(Alloted alloted) {
		this.alloted = alloted;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public Berthpreference getBerthPreference() {
		return berthpreference;
	}

	public void setBerthPreference(Berthpreference berthPreference) {
		berthpreference = berthPreference;
	}

	enum Berthpreference {
		LOWER, MIDDLE, UPPER;
	}

	enum Alloted {
		LOWER, MIDDLE, UPPER, RAC, WAITINGLIST;
	}

	enum Gender {
		MALE, FEMALE;
	}

}
