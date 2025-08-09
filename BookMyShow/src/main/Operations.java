package main;

import service.AccountService;
import service.BookingService;
import service.TicketService;
import service.MovieService;
import service.TheatreService;


public class Operations {
	private static MovieService movie;
	private static TheatreService theatres;
	private static AccountService accService;
	private static int userchoice=0;
	private static TicketService booking;
	public Operations(MovieService movie,TheatreService theatres,AccountService accService,TicketService booking){
		this.movie=movie;
		this.theatres=theatres;
		this.accService=accService;
		this.booking=booking;
	}
	
	@Override
	public String toString() {
		return "Operations [toString()=" + super.toString() + "]";
	}

	public Operations(int userChoice) {
		this.userchoice=userChoice;
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
			movie.displayAllMovie(true);
		    break;
		  case 2:
		    System.out.println("You have Selected Search Movie By Name");
		    movie.searchMovie();
		    break;
		  case 3:
			System.out.println("You have Selected View Movie By Genre");
			movie.movieByGenre();
			break;
		  case 4:
			System.out.println("You have Selected Display All Theatre");
			theatres.displayAllTheatres();
			 break;
		  case 5:
			  System.out.println("You have Selected Display Theatre Wise Movies");
			  theatres.displayTheatreWiseMovies(true);
			 
			  break;
		  case 6:
		    System.out.println("You have Selected Book Ticket");
		    movie.displayAllMovie(false);
		    theatres.displayTheatreWiseMovies(false);
		    booking.bookTicket();
		    break;
		  case 7:
		    System.out.println("You have Selected Check Ticket Status");
		    int BookingId = BookingService.checkBookingKey();
		    BookingService.SearchByBookingId(BookingId);
		    int num = BookMyShow.Features();
			Operations.operation(num);
		    break;
		  case 8:
			  System.out.println("You have Selected View Booking");
			  BookingService.printAllBookings();
			  int num1 = BookMyShow.Features();
		        Operations.operation(num1);
			  break;
		  case 9:
			  System.out.println("You have Selected Cancel Ticket");
			  BookingService.cancelTicket();
			    int num2 = BookMyShow.Features();
		        Operations.operation(num2);
			  break;
		  case 10:
			    System.out.println("You have Selected Deposit Amount In Account");
			    accService.deposit();
			    break;
		  case 11:
			  System.out.println("You have Selected Check Balance In Bank Account");
			  accService.checkBalance();
		  case 12:
		    System.out.println("\nYou have Selected Exit");
		    System.out.println("----------------------------------------------------");
		    System.out.println("Thanks for visiting. See you next time!");
		    System.out.println("----------------------------------------------------");
		    System.exit(0);
		}
	}
	
}
