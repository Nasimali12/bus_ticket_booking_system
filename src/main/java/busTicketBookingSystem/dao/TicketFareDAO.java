package busTicketBookingSystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import busTicketBookingSystem.dto.TicketFareDTO;
import busTicketBookingSystem.exception.TicketBookingException;

public class TicketFareDAO {
	
	 private EntityManagerFactory entityManagerFactory;

	public TicketFareDAO() {
		entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	}
	
	public void addTicketFare(TicketFareDTO ticketFareDTO) throws TicketBookingException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(ticketFareDTO);
			entityTransaction.commit();
		} catch (Exception e) {
			if(entityTransaction !=null) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
			throw new TicketBookingException("Failed to add ticket fare: " + e.getMessage());
		}finally {
			entityManager.close();
		}
	} 
}
