package busTicketBookingSystem.controller;

import java.util.List;
import java.util.Scanner;

import busTicketBookingSystem.dao.BusStopDAO;
import busTicketBookingSystem.dto.BusStopDTO;
import busTicketBookingSystem.exception.TicketBookingException;

public class BusStopController {
	
	static Scanner scanner=new Scanner(System.in);
	  private static BusStopDAO busStopDAO = new BusStopDAO();
	
	public void addBusStop() throws TicketBookingException {
        System.out.print("Enter Bus Stop Name: ");
        String busStopName = scanner.nextLine();

        BusStopDTO busStop = new BusStopDTO();
        busStop.setBusStopName(busStopName);
        busStopDAO.addBusStop(busStop);
        System.out.println("Bus Stop added successfully.");
    }

    public void updateBusStop() throws TicketBookingException {
        System.out.print("Enter Bus Stop ID: ");
        int busStopId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        BusStopDTO busStopById = busStopDAO.getBusStopById(busStopId);
        if(busStopById != null) {
        	System.out.print("Enter Bus Stop Name: ");
            String busStopName = scanner.nextLine();

            BusStopDTO busStop = new BusStopDTO();
            busStop.setBusStopId(busStopId);
            busStop.setBusStopName(busStopName);
            busStopDAO.updateBusStop(busStop);
            System.out.println("Bus Stop updated successfully.");
        }else {
        	System.out.println(busStopId+" ID not found");
        }
    }

    public void deleteBusStop() throws TicketBookingException {
        System.out.print("Enter Bus Stop ID: ");
        int busStopId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        BusStopDTO busStopById = busStopDAO.getBusStopById(busStopId);
        if(busStopById != null) {
        	 busStopDAO.deleteBusStop(busStopId);;
             System.out.println("Bus Stop deleted successfully.");
        }else {
        	System.out.println(busStopById+" ID not found");
        }
    }

    public void getAllBusStops() throws TicketBookingException {
        System.out.println("Bus Stops:");
        List<BusStopDTO> allBusStops = busStopDAO.getAllBusStops();
		
       if(!allBusStops.isEmpty()) {
    	   allBusStops.forEach(busStop -> {
               System.out.println("ID: " + busStop.getBusStopId() + ", Name: " + busStop.getBusStopName());
           });
       }else {
    	   System.out.println("No bus stop is present");
       }
    }

    public void getBusStopById() throws TicketBookingException {
        System.out.print("Enter Bus Stop ID: ");
        int busStopId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        BusStopDTO busStop = busStopDAO.getBusStopById(busStopId);
        if (busStop != null) {
            System.out.println("Bus Stop:");
            System.out.println("ID: " + busStop.getBusStopId() + ", Name: " + busStop.getBusStopName());
        } else {
            System.out.println("Bus Stop not found.");
        }
}
}
