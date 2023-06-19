package busTicketBookingSystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import busTicketBookingSystem.dto.BusStopDTO;
import busTicketBookingSystem.exception.TicketBookingException;

import java.util.List;

public class BusStopDAO {
    private EntityManagerFactory entityManagerFactory;

    public BusStopDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    }

    public void addBusStop(BusStopDTO busStop) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(busStop);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new TicketBookingException("Failed to add bus stop: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void updateBusStop(BusStopDTO busStop) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(busStop);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new TicketBookingException("Failed to update bus stop: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void deleteBusStop(int busStopId) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            BusStopDTO busStop = entityManager.find(BusStopDTO.class, busStopId);
            entityManager.remove(busStop);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new TicketBookingException("Failed to delete bus stop: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<BusStopDTO> getAllBusStops() throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT bs FROM BusStopDTO bs", BusStopDTO.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TicketBookingException("Failed to retrieve bus stops: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public BusStopDTO getBusStopById(int busStopId) throws TicketBookingException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(BusStopDTO.class, busStopId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TicketBookingException("Failed to retrieve bus stop: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}

