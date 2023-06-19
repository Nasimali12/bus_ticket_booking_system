package busTicketBookingSystem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class TicketFareDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketFareId;
	
	@Column(nullable = false)
    private double perKMTicketFareForChild;
	
	@Column(nullable = false)
    private double perKMTicketFareForAdult;

	public TicketFareDTO(int ticketFareId, double perKMTicketFareForChild, double perKMTicketFareForAdult) {
		super();
		this.ticketFareId = ticketFareId;
		this.perKMTicketFareForChild = perKMTicketFareForChild;
		this.perKMTicketFareForAdult = perKMTicketFareForAdult;
	}

	public int getTicketFareId() {
		return ticketFareId;
	}

	public void setTicketFareId(int ticketFareId) {
		this.ticketFareId = ticketFareId;
	}

	public double getPerKMTicketFareForChild() {
		return perKMTicketFareForChild;
	}

	public void setPerKMTicketFareForChild(double perKMTicketFareForChild) {
		this.perKMTicketFareForChild = perKMTicketFareForChild;
	}

	public double getPerKMTicketFareForAdult() {
		return perKMTicketFareForAdult;
	}

	public void setPerKMTicketFareForAdult(double perKMTicketFareForAdult) {
		this.perKMTicketFareForAdult = perKMTicketFareForAdult;
	}

	public TicketFareDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
