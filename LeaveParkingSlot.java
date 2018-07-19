package com.parkingslot.actions;

import com.parkingslot.model.Ticket;

public class LeaveParkingSlot implements ProcessAction {

	private int parkingSlotNumber;
	private Ticket ticket;

	public LeaveParkingSlot(Ticket ticket) {
		this.ticket=ticket;
	}

	public String process() {
		ticket.getSlot().unPark();
		this.parkingSlotNumber=ticket.getParkingSlotNumber();
		return "Slot number "+this.parkingSlotNumber+" is free";
	}
	
	
}
