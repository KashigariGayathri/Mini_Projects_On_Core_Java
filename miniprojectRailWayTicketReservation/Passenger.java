package miniprojectRailWayTicketReservation;

public class Passenger {
	 private final String name;
	    private double balance;
	    private Ticket bookedTicket;

	    public Passenger(String name, double balance) {
	        this.name = name;
	        this.balance = balance;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public double getBalance() {
	        return this.balance;
	    }

	    public void setBalance(double newBalance) {
	        this.balance = newBalance;
	    }

	    public Ticket getBookedTicket() {
	        return this.bookedTicket;
	    }

	    public void bookTicket(Ticket ticket) {
	        this.bookedTicket = ticket;
	    }

	    public void cancelTicket() {
	        this.bookedTicket = null;
	    }
}
