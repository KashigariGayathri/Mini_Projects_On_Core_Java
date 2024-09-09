package miniprojectRailWayTicketReservation;
import java.util.Scanner;
public class MainPage {

	public static void main(String[] args) throws InsufficientSeatsException, NegativeAmountException, InsufficientBalanceException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Railway railway = new Railway();
        boolean exitRequested = false;
        System.out.println("****************");
        System.out.println("*      Welcome to Railway Reservation System      *");
        System.out.println("****************");
        while (!exitRequested) {
            PrintServices.printMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    railway.registerPassenger();
                    break;
                case 2:
                    railway.bookTicket();
                    break;
                case 3:
                    railway.cancelTicket();
                    break;
                case 4:
                    railway.checkAvailableSeats();
                    break;
                case 5:
                    railway.displayTrains();
                    break;
                case 6:
                    exitRequested = true;
                    break;
                default:
                    System.out.println("Your input was not recognized. Please try again.");
                    break;
            }
        }
	}

}
