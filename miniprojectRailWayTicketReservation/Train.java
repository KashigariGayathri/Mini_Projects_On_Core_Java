package miniprojectRailWayTicketReservation;

public class Train {
	 private final int trainNumber;
	    private final String startPlace;
	    private final String destination;
	    private int availableSeats;

	    public Train(int trainNumber, String startPlace, String destination, int availableSeats) {
	        this.trainNumber = trainNumber;
	        this.startPlace = startPlace;
	        this.destination = destination;
	        this.availableSeats = availableSeats;
	    }

	    public int getTrainNumber() {
	        return this.trainNumber;
	    }

	    public String getStartPlace() {
	        return this.startPlace;
	    }

	    public String getDestination() {
	        return this.destination;
	    }

	    public int getAvailableSeats() {
	        return this.availableSeats;
	    }

	    public void bookSeats(int numSeats) throws InsufficientSeatsException {
	        if (numSeats > availableSeats) {
	            throw new InsufficientSeatsException("Not enough seats available.");
	        }
	        this.availableSeats -= numSeats;
	    }

	    public void cancelSeats(int numSeats) {
	        this.availableSeats += numSeats;
	    }
}
