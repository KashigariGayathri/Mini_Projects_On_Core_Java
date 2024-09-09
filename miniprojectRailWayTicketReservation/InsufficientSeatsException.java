package miniprojectRailWayTicketReservation;

public class InsufficientSeatsException extends Exception {
    private static final long serialVersionUID = 1L;

    public InsufficientSeatsException(String message) {
        super(message);
    }

}
