package com.parkingslot.actions;

import java.util.Map;

import com.parkingslot.model.Ticket;

public class FilterSlotNumBasedOnRegNum implements ProcessAction{
	
	private String inputVal;
	private Map<Integer,Ticket> issueTicket;
	
	public FilterSlotNumBasedOnRegNum(String inputVal, Map<Integer, Ticket> issueTicket) {
		this.inputVal=inputVal;
		this.issueTicket=issueTicket;
	}

	@Override
	public String process() {
		
		String output=issueTicket.entrySet().stream().
				filter(x->inputVal.equals(x.getValue().getCar().getRegistrationNumber())).
				map(x->String.valueOf(x.getValue().getParkingSlotNumber())).
				findAny().orElse("Not found");

		System.out.println(output);
		
		return output;
	}

	
}
