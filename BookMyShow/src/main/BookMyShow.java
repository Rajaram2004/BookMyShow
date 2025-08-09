package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import bank.Account;
import service.AccountService;
import service.BookingService;
import service.MovieService;
import service.TheatreService;
import service.TicketService;

public class BookMyShow {

	public static void main(String[] args) {
		List<Movies> movies=new ArrayList<>();
		MovieService movie =new MovieService(movies);
		
		List<Theatre> theatre=new ArrayList<>();
		TheatreService theatres=new TheatreService(theatre,movies);
		
		HashMap<Integer,Account> bank = new HashMap<>();
		AccountService accService = new AccountService(bank);
		
		HashMap<Integer,Ticket> ticketMap = new HashMap<>();
		TicketService ticketService = new TicketService(ticketMap,theatre,movies);
		
		
		HashMap<Integer,Booking> booking =new HashMap<>();
		BookingService bookingService = new BookingService(booking,bank);

		
		
		Operations op=new Operations(movie,theatres,accService,ticketService);
		int num = Features();
		Operations.operation(num);
		
		InputScanner.closeScanner();
	}
	
	
	public static int Features() {
		System.out.println("\n========= Welcome to Movie Booking System =========");
		System.out.println("Please select one of the following options:\n");

		String[] features = {
		    "1 . View All Movies",
		    "2 . Search Movie By Name",
		    "3 . View Movie By Genre",
		    "4 . Display All Theatre",
		    "5 . Display Seat Availability",
		    "6 . Book Ticket",
		    "7 . Ticket Status",
		    "8 . View Booking",
		    "9 . Cancel Movie Ticket",
		    "10. Deposit Amount In Account",
		    "11. Check Balance In Bank Account",
		    "12. Exit"
		};
		
		int n=features.length;
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
