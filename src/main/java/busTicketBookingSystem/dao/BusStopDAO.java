package busTicketBookingSystem.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BusStopDAO {
	
	EntityManagerFactory emEntityManagerFactory=Persistence.createEntityManagerFactory("dev");
	
	
}
