package com.parkingslot.actions;

import java.util.List;

import com.parkingslot.model.Slot;

public class CreatParkingLot implements ProcessAction {
	
	private int totalParkingLot;
	private List<Slot> listOfSlots;
	
	public CreatParkingLot(int totalParkingLot) {
		this.totalParkingLot=totalParkingLot;
	}

	@Override
	public String process() {
		for(int i=1;i<=totalParkingLot;i++) {
			listOfSlots.add(new Slot(i));
			}
		return "Created a parking lot with "+totalParkingLot+" slots";
	}

	public List<Slot> getListOfSlots() {
		return listOfSlots;
	}

	public void setListOfSlots(List<Slot> listOfSlots) {
		this.listOfSlots = listOfSlots;
	}
	
	

}
