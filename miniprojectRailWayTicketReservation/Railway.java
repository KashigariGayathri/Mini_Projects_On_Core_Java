package miniprojectRailWayTicketReservation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Railway {
	 private final List<Train> trains;
	    private final List<Passenger> passengers;
	    private final Scanner sc;

	    public Railway() {
	        trains = new ArrayList<>();
	        passengers = new ArrayList<>();
	        sc = new Scanner(System.in);
	        initializeTrains();
	    }

	    private void initializeTrains() {
	        trains.add(new Train(1, "CityA", "CityB", 100));
	        trains.add(new Train(2, "CityC", "CityD", 200));
	    }

	    public Passenger isPassengerExist(String name) {
	        for (Passenger passenger : passengers) {
	            if (passenger.getName().equals(name)) {
	                return passenger;
	            }
	        }
	        return null;
	    }

	    public Train getTrainByNumber(int trainNumber) {
	        for (Train train : trains) {
	            if (train.getTrainNumber() == trainNumber) {
	                return train;
	            }
	        }
	        return null;
	    }

	    public void registerPassenger() {
	        System.out.println("---------Passenger Registration---------");
	        System.out.println("Name?");
	        String name = sc.next();
	        System.out.println("Initial Balance?");
	        double balance = sc.nextDouble();
	        passengers.add(new Passenger(name, balance));
	        System.out.println("Passenger registered successfully!");
	    }

	    public void bookTicket() throws InsufficientSeatsException, NegativeAmountException, InsufficientBalanceException {
	        System.out.println("---------Book Ticket---------");
	        System.out.println("Please enter your name:");
	        String name = sc.next();
	        Passenger passenger = isPassengerExist(name);
	        if (passenger == null) {
	            System.out.println("Passenger not found. Please register first.");
	            return;
	        }
	        System.out.println("Please enter train number:");
	        int trainNumber = sc.nextInt();
	        Train train = getTrainByNumber(trainNumber);
	        if (train == null) {
	            System.out.println("Train not found.");
	            return;
	        }
	        System.out.println("Enter number of seats to book:");
	        int numSeats = sc.nextInt();
	        System.out.println("Enter cost per seat:");
	        double costPerSeat = sc.nextDouble();
	        double totalCost = numSeats * costPerSeat;
	        if (passenger.getBalance() < totalCost) {
	            throw new InsufficientBalanceException("Not enough balance to book tickets.");
	        }
	        train.bookSeats(numSeats);
	        passenger.setBalance(passenger.getBalance() - totalCost);
	        passenger.bookTicket(new Ticket(train.getStartPlace(), train.getDestination(), numSeats, totalCost));
	        System.out.println("Tickets booked successfully!");
	    }

	    public void cancelTicket() {
	        System.out.println("---------Cancel Ticket---------");
	        System.out.println("Please enter your name:");
	        String name = sc.next();
	        Passenger passenger = isPassengerExist(name);
	        if (passenger == null || passenger.getBookedTicket() == null) {
	            System.out.println("No ticket found for cancellation.");
	            return;
	        }
	        Ticket ticket = passenger.getBookedTicket();
	        Train train = getTrainByNumber(ticket.getTrainNumber());
	        if (train != null) {
	            train.cancelSeats(ticket.getNumSeats());
	            passenger.setBalance(passenger.getBalance() + ticket.getCost());
	            passenger.cancelTicket();
	            System.out.println("Ticket cancelled and money refunded.");
	        }
	    }

	    public void checkAvailableSeats() {
	        System.out.println("---------Check Available Seats---------");
	        System.out.println("Please enter train number:");
	        int trainNumber = sc.nextInt();
	        Train train = getTrainByNumber(trainNumber);
	        if (train == null) {
	            System.out.println("Train not found.");
	            return;
	        }
	        System.out.println("Available seats: " + train.getAvailableSeats());
	    }

	    public void displayTrains() {
	        System.out.println("---------Available Trains---------");
	        for (Train train : trains) {
	            System.out.println("Train Number: " + train.getTrainNumber() + ", Start: " + train.getStartPlace() + ", Destination: " + train.getDestination() + ", Available Seats: " + train.getAvailableSeats());
	        }
}
}
