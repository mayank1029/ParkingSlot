package com.parkingslot.model;

public class Slot {

	private boolean isOccupied;
	private int slotNumber;
	
	public Slot(int slotNumber){
		isOccupied=false;
		this.slotNumber=slotNumber;
	}
	
	public boolean isOccupied() {
		return isOccupied;
	}
	
	public int getSlotNumber() {
		return this.slotNumber;
	}
	
	public void park() {
		this.isOccupied=true;
	}
	
	public void unPark() {
		this.isOccupied=false;
		System.out.println("Slot number "+this.slotNumber+" is free");
	}

	@Override
	public String toString() {
		return "Slot [isOccupied=" + isOccupied + ", slotNumber=" + slotNumber + "]";
	}
	
	
}
