package busTicketBookingSystem;

import java.util.Scanner;

import busTicketBookingSystem.controller.BusStopController;
import busTicketBookingSystem.exception.TicketBookingException;

public class Application {

	public static void main(String[] args) throws TicketBookingException {
		Scanner scanner = new Scanner(System.in);
		BusStopController busStopController=new BusStopController();
        int choice;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                	busStopController.addBusStop();
                    break;
                case 2:
                	busStopController.updateBusStop();
                    break;
                case 3:
                	busStopController.deleteBusStop();
                    break;
                case 4:
                	busStopController.getAllBusStops();
                    break;
                case 5:
                	busStopController.getBusStopById();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Bus Stop");
        System.out.println("2. Update Bus Stop");
        System.out.println("3. Delete Bus Stop");
        System.out.println("4. Get All Bus Stops");
        System.out.println("5. Get Bus Stop by ID");
        System.out.println("0. Exit");
    }

	}


