package miniprojectRailWayTicketReservation;

public class Ticket {
	 private final String startPlace;
	    private final String destination;
	    private final int numSeats;
	    private final double cost;

	    public Ticket(String startPlace, String destination, int numSeats, double cost) {
	        this.startPlace = startPlace;
	        this.destination = destination;
	        this.numSeats = numSeats;
	        this.cost = cost;
	    }

	    public String getStartPlace() {
	        return this.startPlace;
	    }

	    public String getDestination() {
	        return this.destination;
	    }

	    public int getNumSeats() {
	        return this.numSeats;
	    }

	    public double getCost() {
	        return this.cost;
	    }

	    @Override
	    public String toString() {
	        return "Start: " + startPlace + ", Destination: " + destination + ", Seats: " + numSeats + ", Cost: " + cost;
	    }

		public int getTrainNumber() {
			// TODO Auto-generated method stub
			return 0;
		}
}
