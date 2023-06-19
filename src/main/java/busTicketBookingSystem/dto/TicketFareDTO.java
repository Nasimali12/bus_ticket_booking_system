package busTicketBookingSystem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class TicketFareDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketFareId;
	
	@ManyToOne
	BusStopDTO busStopDTO;
	
	@Column(nullable = false)
	private double fareForChild;
	
//	@Column(nullable = false)
//	private double fareForHandicap;
}
