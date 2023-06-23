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
        entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit-name");
    }

    public void addTicketFare(TicketFareDTO ticketFare) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(ticketFare);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new TicketBookingException("Failed to add ticket fare: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void updateTicketFare(TicketFareDTO ticketFare) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(ticketFare);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new TicketBookingException("Failed to update ticket fare: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void deleteTicketFare(int ticketFareId) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TicketFareDTO ticketFare = entityManager.find(TicketFareDTO.class, ticketFareId);
            entityManager.remove(ticketFare);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new TicketBookingException("Failed to delete ticket fare: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public TicketFareDTO getTicketFareById(int ticketFareId) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(TicketFareDTO.class, ticketFareId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TicketBookingException("Failed to get ticket fare by ID: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}

