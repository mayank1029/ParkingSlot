package com.parkingslot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.parkingslot.model.Car;
import com.parkingslot.model.Slot;
import com.parkingslot.model.Ticket;

public class ParkingSlot {
	
	private List<Slot> listOfSlots;
	private int totalParkingLot;
	public Map<Integer,Slot> occupiedSlots;
	
	public ParkingSlot(int totalParkingLot) {
		this.listOfSlots=new ArrayList<Slot>(totalParkingLot);
		this.totalParkingLot=totalParkingLot;
		createSlots();
		occupiedSlots=new LinkedHashMap<Integer,Slot>();
	}

	private void createSlots() {
		for(int i=1;i<=totalParkingLot;i++) {
		listOfSlots.add(new Slot(i));
		}
		System.out.println("Created a parking lot with "+totalParkingLot+" slots");
	}
	
	public Ticket park(Car car) {
		
		return parkHelper(car,getFirstEmptySlot(listOfSlots));
	}
	
	public void unPark(Ticket ticket) {
		occupiedSlots.get(ticket.getSlot().getSlotNumber()).unPark();
		occupiedSlots.remove(ticket.getParkingSlotNumber());

	}
	
	private Slot getFirstEmptySlot(List<Slot> slots) {
		boolean isSlotFound = false;
		Slot emptySlot=null;
		Iterator<Slot> iterator=slots.iterator();
		
		/*slots.forEach(slot->{
			if(!slot.isOccupied() && !isSlotFound) {
				isSlotFound=true;
				emptySlot=slot;
			}
		});*/
		
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
	
	private Ticket parkHelper(Car car,Slot slot) {
		if(slot==null) {
			System.out.println("Sorry, parking lot is full");

			return null;
		}else {
		slot.park();
		occupiedSlots.put(slot.getSlotNumber(),slot);
		Ticket ticket=new Ticket(car,slot.getSlotNumber(),slot);
		
		System.out.println("Allocated slot number: "+slot.getSlotNumber());
		return ticket;
		}
	}
}
