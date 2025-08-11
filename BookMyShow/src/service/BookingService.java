package service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bank.Account;
import main.BookMyShow;
import main.Booking;
import main.InputScanner;
import main.Operations;
import main.Theatre;

public class BookingService {

	static HashMap<Integer, Booking> booking;
	static HashMap<Integer, Account> bank;

	public BookingService(HashMap<Integer, Booking> booking, HashMap<Integer, Account> bank) {
		this.booking = booking;
		this.bank = bank;
	}

	public static void addBooking(Booking book) {
		int bookingId = booking.size() + 1;
		booking.put(bookingId, book);
	}

	public static int nextBookingId() {
		return booking.size() + 1;
	}

	public static int checkBookingKey() {
		if (booking.isEmpty()) {
			System.err.println("No bookings available.");
			return 0;
		}

		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Your Ticket Id : ");

		String input = sc.nextLine();

		try {
			int num = Integer.parseInt(input);
			if (num > 0 && booking.containsKey(num)) {
				return num;

			} else {
				System.err.println("Please Enter A Valid Ticket Id.");
				return checkBookingKey();
			}
		} catch (NumberFormatException e) {
			System.err.println("Not an Integer.");
			return checkBookingKey();
		}

	}

	public static void SearchByBookingId(int key) {

		Booking ticket = booking.get(key);

		System.out.println("=====================================");
		System.out.println("            Booking Details          ");
		System.out.println("=====================================");
		System.out.printf("Booking ID      : %d%n", ticket.getBookingId());
		System.out.printf("User Name       : %s%n", ticket.getUserName());
		System.out.printf("Booking Date    : %s%n", ticket.getBookingDate());
		System.out.printf("Tickets Booked  : %d%n", ticket.getNumberOfTickets());
		System.out.printf("Total Amount    : ₹%.2f%n", ticket.getTotalAmount());
		System.out.printf("Bank Account Id : %d%n", ticket.getPaidAccountId());
		System.out.printf("Booking Status  : %s%n", ticket.isActive() ? "Active" : "Cancelled");
		System.out.println("=====================================");
	}
	
	
	
	
	public static void printMyBookings() {
	    if (booking.isEmpty()) {
	        System.err.println("No bookings available.");
	        return;
	    }
	    
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-2s | %-9s | %-12s | %-20s | %-13s | %-9s | %-12s | %-11s | %-8s |\n", 
	        "ID", "User Name", "Booking Date", "Movie Name", "No. of Tickets", "Theatre", "Paid AccountId", "Total Amount", "Status");
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

	    for (Booking b : booking.values()) {
	        if (b.getUserId() == Operations.user.getUserId()) {
	            System.out.printf("| %-2d | %-9s | %-12s | %-20s | %-13d | %-9s | %-12s | %-11.2f | %-8s |\n", 
	                b.getBookingId(),
	                b.getUserName(),
	                b.getBookingDate(),
	                b.getMovie().getTitle(), 
	                b.getNumberOfTickets(),
	                b.getTheatre().getName(),
	                b.getPaidAccountId(), 
	                b.getTotalAmount(),
	                b.isActive() ? "Active" : "Cancelled");
	        }
	    }

	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	}
	   
	public static void printAllBookings() {
	    if (booking.isEmpty()) {
	        System.err.println("No bookings available.");
	        return;
	    }
	    
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-2s | %-9s | %-12s | %-20s | %-13s | %-9s | %-12s | %-11s | %-8s |\n", 
	        "ID", "User Name", "Booking Date", "Movie Name", "No. of Tickets", "Theatre", "Paid AccountId", "Total Amount", "Status");
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

	    for (Booking b : booking.values()) {
	       
	            System.out.printf("| %-2d | %-9s | %-12s | %-20s | %-13d | %-9s | %-12s | %-11.2f | %-8s |\n", 
	                b.getBookingId(),
	                b.getUserName(),
	                b.getBookingDate(),
	                b.getMovie().getTitle(), 
	                b.getNumberOfTickets(),
	                b.getTheatre().getName(),
	                b.getPaidAccountId(), 
	                b.getTotalAmount(),
	                b.isActive() ? "Active" : "Cancelled");
	    }

	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	}


	

	public static void cancelTicket() {
		System.err.println("Cancellation, you will bear a deduction of 25% from your total amount.");
		if (booking.isEmpty()) {
			System.err.println("No tickets available, so cancellation cannot be performed");
			return;
		}
		int bookingId = checkBookingKey();
		boolean isPasswordValid = false;
		while (!isPasswordValid) {
			System.out.println("Hai " + Operations.user.getName());
			int password = LoginService.getUserPassword();
			if (password == Operations.user.getPassword()) {
				isPasswordValid = true;
			} else {
				System.err.println("Invalid Pin , Please Re-Enter Your PIN");
			}
		}
		
		Booking userBooking = booking.get(bookingId);
		if(Operations.user.getUserId()==userBooking.getBookingId()) {
			bank = AccountService.getAccount();
			if (userBooking.isActive()) {
				Account account = bank.get(userBooking.getBookingId());
				
				double amount = userBooking.getTotalAmount();

				double afterDectect = 0.25 * amount;
				System.err.println("Amount Detected " + afterDectect);
				afterDectect = amount - afterDectect;
				System.out.print("Amount going to add " + afterDectect);
				System.out.println();
				double remainingAmount = account.getBalance();
				account.setBalance(remainingAmount + afterDectect);
				userBooking.setActive(false);

				// return ticket to theatre;

				returnTicket(userBooking);

				System.out.println("75% of the amount has been credited to your bank account");
			} else {
				System.err.println("This ticket has already been cancelled ");
			}
		}else {
			System.err.println("You are not the person who created this ticket , So you cannot cancel");
		}
		

	}

	private static void returnTicket(Booking userBooking) {
		int userTicketCount = userBooking.getNumberOfTickets();
		LocalDate bookedDate = userBooking.getBookingDate();
		Theatre theatre = userBooking.getTheatre();
		int movieId = userBooking.getMovie().getMovieId();
		Map<LocalDate, Map<Integer, Integer>> availableTicketOnDate = theatre.getAvailableTicketOnDate();
		int noOfTicket = availableTicketOnDate.get(bookedDate).get(movieId);
		noOfTicket += userTicketCount;
		availableTicketOnDate.get(bookedDate).put(movieId, noOfTicket);

		System.out.println("Tickets returned successfully. Updated availability:");

	}
}
