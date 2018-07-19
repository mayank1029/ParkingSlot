package com.parkingslot.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.parkingslot.model.Car;
import com.parkingslot.model.Ticket;
import com.parkingslot.service.ParkingSlot;

/**
 * Hello world!
 *
 */
public class StartApplication 
{
	public static String output=null;

	public static void main( String[] args ) throws Exception
	{

		File f=new File("C:\\Users\\pa64991\\Desktop\\preeti\\file_inputs.txt");

		BufferedReader br=new BufferedReader(new FileReader(f));
		String command=null;
		String[] splitted=null;
		Map<Integer,Ticket> issueTicket = new LinkedHashMap<>();
		ParkingSlot ps=null;

		while((command=br.readLine())!=null) {
			System.out.println(command);
			splitted=command.split(" ");

			if("create_parking_lot".equalsIgnoreCase(splitted[0])) {
				ps=new ParkingSlot(Integer.parseInt(splitted[1])); 
			}


			if("park".equalsIgnoreCase(splitted[0])) {
				Ticket ticket=ps.park(new Car(splitted[2],splitted[1]));
				if(ticket!=null)
				issueTicket.put(ticket.getParkingSlotNumber(),ticket);
			}


			if("leave".equalsIgnoreCase(splitted[0])) {
				Ticket ticket=issueTicket.get(Integer.parseInt(splitted[1]));
				issueTicket.remove(ticket.getParkingSlotNumber());
				ticket.getSlot().unPark();
			}


			if("status".equalsIgnoreCase(splitted[0])) {
				System.out.println("Slot No.     "+"Registration No.     "+"Colour");

				issueTicket.forEach((k,v)->{
					System.out.println(k+"    "+v.getCar().getRegistrationNumber()+"    "+v.getCar().getColour());

				});
			}
			
			
		}

		br.close();



	}
}
