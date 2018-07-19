package com.parkingslot.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

	private Car car;
	private int parkingSlotNumber;
	private String time;
	SimpleDateFormat dateFormat=null;
	private Slot slot;
	
	
	public Ticket(Car car, int parkingSlotNumber,Slot slot) {
		super();
		this.car = car;
		this.parkingSlotNumber = parkingSlotNumber;
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		this.time  = dateFormat.format(new Date());
		this.slot=slot;
		
	}

	public Car getCar() {
		return car;
	}




	public void setCar(Car car) {
		this.car = car;
	}


	public Slot getSlot() {
		return slot;
	}


	public void setSlot(Slot slot) {
		this.slot = slot;
	}	


	public int getParkingSlotNumber() {
		return parkingSlotNumber;
	}

	public void setParkingSlotNumber(int parkingSlotNumber) {
		this.parkingSlotNumber = parkingSlotNumber;
	}

	@Override
	public String toString() {
		return "Ticket [car=" + car + ", parkingSlotNumber=" + parkingSlotNumber + ", time=" + time  + ", slot=" + slot + "]";
	}

	
	
}
