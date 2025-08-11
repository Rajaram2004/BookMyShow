package main;

import java.util.Scanner;

import login.User;
import service.AccountService;
import service.BookingService;
import service.TicketService;
import service.MovieService;
import service.TheatreService;

public class Operations {
	private static MovieService movie;
	private static TheatreService theatres;
	private static AccountService accService;
	private static int userchoice = 0;
	private static TicketService booking;
	public static User user;

	public Operations(MovieService movie, TheatreService theatres, AccountService accService, TicketService booking,
			User user) {
		this.movie = movie;
		this.theatres = theatres;
		this.accService = accService;
		this.booking = booking;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Operations [toString()=" + super.toString() + "]";
	}

	public Operations(int userChoice) {
		this.userchoice = userChoice;
	}

	public int getUserchoice() {
		return userchoice;
	}

	public void setUserchoice(int userchoice) {
		this.userchoice = userchoice;
	}

	public static void operation(int userchoice) {
		switch (userchoice) {
		case 1:
			movie.displayAllMovie();
			int num1 = Features();
			Operations.operation(num1);
			break;
		case 2:
			System.out.println("You have Selected Search Movie By Name");
			movie.searchMovie();
			int num2 = Features();
			Operations.operation(num2);
			break;
		case 3:
			System.out.println("You have Selected View Movie By Genre");
			movie.movieByGenre();
			int num3 = Features();
			Operations.operation(num3);
			break;
		case 4:
			System.out.println("You have Selected Display All Theatre");
			theatres.displayAllTheatres();
			int num4 = Features();
			Operations.operation(num4);
			break;
		case 5:
			System.out.println("You have Selected Display Seat Availability");
			theatres.displayTheatreWiseMovies();

			int num5 = Features();
			Operations.operation(num5);
			break;
		case 6:
			System.out.println("You have Selected Book Ticket");
			movie.displayAllMovie();
			theatres.displayTheatreWiseMovies();
			booking.bookTicket(user);
			int num6 = Features();
			Operations.operation(num6);
			break;
		case 7:
			System.out.println("You have Selected Check Ticket Status");
			int BookingId = BookingService.checkBookingKey();
			if (BookingId > 0) {
				BookingService.SearchByBookingId(BookingId);
			}
			int num7 = Features();
			Operations.operation(num7);
			break;
		case 8:
			System.out.println("You have Selected View My Booking");
			//BookingService.printAllBookings();
			BookingService.printMyBookings();
			int num8 = Features();
			Operations.operation(num8);
			break;
		case 9:
			System.out.println("You have Selected Cancel Ticket");
			BookingService.cancelTicket();
			int num9 = Features();
			Operations.operation(num9);
			break;
		case 10:
			System.out.println("You have Selected Deposit Amount In Account");
			accService.deposit();
			int num10 = Features();
			Operations.operation(num10);
			break;
		case 11:
			System.out.println("You have Selected Check Balance In Bank Account");
			accService.checkBalance();
			int num11 = Features();
			Operations.operation(num11);
		case 12:
			System.out.println("\nYou have Selected Exit");
			System.out.println("----------------------------------------------------");
			System.out.println("Thanks for visiting. See you next time!");
			System.out.println("----------------------------------------------------");
			//System.exit(0);
		}
	}

	public static int Features() {
		System.out.println("\n========= Welcome to Movie Booking System =========");
		System.out.println("Please select one of the following options:\n");

		String[] features = { "1 . View All Movies", "2 . Search Movie By Name", "3 . View Movie By Genre",
				"4 . Display All Theatre", "5 . Display Seat Availability", "6 . Book Ticket", "7 . Ticket Status",
				"8 . View Booking", "9 . Cancel Movie Ticket", "10. Deposit Amount In Account",
				"11. Check Balance In Bank Account", "12. Exit" };

		int n = features.length;
		for (int i = 0; i < features.length; i++) {
			System.out.println("  " + features[i]);
		}

		System.out.println("\n====================================================\n");

		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Your Choice : ");

		String input = sc.nextLine();

		try {
			int num = Integer.parseInt(input);
			if (num > 0 && num <= n) {
				return num;

			} else {
				System.err.println("Please enter a valid number.");
				return Features();
			}
		} catch (NumberFormatException e) {
			System.err.println("Not an integer.");
			return Features();
		}
	}

}
