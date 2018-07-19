package com.parkingslot.model;

public class Car {
	
	private String colour;
	private String registrationNumber;
	
	public Car(String colour, String registrationNumber) {
		this.colour=colour;
		this.registrationNumber=registrationNumber;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	

	@Override
	public String toString() {
		return "Car [colour=" + colour + ", registrationNumber=" + registrationNumber+"]";
	}

}
