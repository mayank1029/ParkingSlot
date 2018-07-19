package com.parkingslot.actions;

import java.util.Iterator;
import java.util.List;

import com.parkingslot.model.Car;
import com.parkingslot.model.Slot;
import com.parkingslot.model.Ticket;

public class AlotParkingSlot implements ProcessAction {

	private String regNum;
	private String color;
	private List<Slot> listOfSlots; 
	private Ticket ticket;

	public AlotParkingSlot(String regNum,String color,List<Slot> listOfSlots) {
		this.regNum=regNum;
		this.color=color;
		this.listOfSlots=listOfSlots;
	}

	public String process() {
		String output=null;
		Slot slot=getFirstEmptySlot();
		if(slot==null) {
			output="Sorry, parking lot is full";
		}else {
			slot.park();
			Ticket ticket=new Ticket(new Car(color,regNum),slot.getSlotNumber(),slot);
			this.ticket=ticket;
			output="Allocated slot number: "+slot.getSlotNumber();
		}
		return output;
	}
	
	private Slot getFirstEmptySlot() {
		boolean isSlotFound = false;
		Slot emptySlot=null;
		Iterator<Slot> iterator=listOfSlots.iterator();
		
		while(iterator.hasNext() && !isSlotFound) {
			emptySlot=iterator.next();
			if(!emptySlot.isOccupied()) {
				isSlotFound=true;
			}
		}
		if(!isSlotFound) {
		 return null;
		}
				
		return emptySlot;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

}
