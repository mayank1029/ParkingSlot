package com.parkingslot.actions;

import java.util.Map;
import java.util.stream.Collectors;

import com.parkingslot.model.Ticket;

public class Status implements ProcessAction {
	
	private Map<Integer,Ticket> issueTicket;
	
	public Status(Map<Integer,Ticket> issueTicket) {
		this.issueTicket=issueTicket;
	}

	@Override
	public String process() {
		String output="Slot No.     "+"Registration No.     "+"Colour";
		issueTicket.forEach((k,v)->{
			output=output+"%n"+k+"    "+v.getCar().getRegistrationNumber()+"    "+v.getCar().getColour();
			
			issueTicket.entrySet().stream().
			map(x->x.getValue().getCar().getRegistrationNumber()).collect(Collectors.joining(", "));

		});
		
		return output;
	}

}
