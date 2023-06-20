package busTicketBookingSystem.controller;

import java.util.Scanner;

import busTicketBookingSystem.dao.TicketFareDAO;
import busTicketBookingSystem.dto.TicketFareDTO;
import busTicketBookingSystem.exception.TicketBookingException;

public class TicketFareController {
	
	static Scanner scanner=new Scanner(System.in);
	private static TicketFareDAO ticketFareDAO=new TicketFareDAO();
	private static TicketFareDTO ticketFareDTO=new TicketFareDTO();
	
	public void addTicketFare() throws TicketBookingException{
	System.out.println("Enter per km ticket fare for child");
	int perKmTicketFareForChild = scanner.nextInt();
	System.out.println("Enter per km ticket fare for adult");
	int perKmTicketFareForAdult = scanner.nextInt();
	
	ticketFareDTO.setPerKMTicketFareForAdult(perKmTicketFareForAdult);
	ticketFareDTO.setPerKMTicketFareForChild(perKmTicketFareForChild);
	
	ticketFareDAO.addTicketFare(ticketFareDTO);
	System.out.println("Ticket fare is successfully inserted");
	}
}
