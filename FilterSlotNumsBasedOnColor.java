package com.parkingslot.actions;

import java.util.Map;
import java.util.stream.Collectors;

import com.parkingslot.model.Ticket;

public class FilterSlotNumsBasedOnColor implements ProcessAction {
	
	private String inputVal;
	private Map<Integer,Ticket> issueTicket;
	
	public FilterSlotNumsBasedOnColor(String inputVal, Map<Integer, Ticket> issueTicket) {
		this.inputVal=inputVal;
		this.issueTicket=issueTicket;
	}

	@Override
	public String process() {
		String output=issueTicket.entrySet().stream().
				filter(x->inputVal.equals(x.getValue().getCar().getColour())).
				map(x->String.valueOf(x.getValue().getParkingSlotNumber())).collect(Collectors.joining(", "));

		System.out.println(output);
		return output;
	}

}
