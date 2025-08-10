package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bank.Account;
import login.User;
import service.AccountService;
import service.BookingService;
import service.MovieService;
import service.TheatreService;
import service.TicketService;
import service.UserService;

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
		
		Map<Integer, User> users =new HashMap<>();
		UserService userService = new UserService(users);

		
		boolean userValid =false;
		System.out.println("\n========= Welcome to Movie Booking System =========");
		System.out.println("|		  1.User Login                    |");
		System.out.println("|		  2.Admin Login                   |");
		System.out.println("|		  3.Create New User               |");
		System.out.println("|	   	  4.Exit                          |");
		System.out.println("---------------------------------------------------");
		int userId=0;
		int getChoice = getChoice();
		if(getChoice==1) {
			while(!userValid) {
				userId = getUserId(users.size());
				int password =getUserPassword();
				boolean user = userService.isValidUserId(userId);
				if(userService.validateUser(userId, password)) {
					userValid=true;
				}else {
					System.err.println("Pin Mismatch Please Enter Correct Pin ");
				}	
			}
		}
		else if(getChoice==2) {
			System.err.println("\nAdmin Operation Are Not Created Yet");
			System.exit(0);
		}else if(getChoice==3) {
			System.out.println("Creating New User");
			userService.addUser();
			
		}else if(getChoice==4) {
			System.out.println("\nYou have Selected Exit");
		    System.out.println("----------------------------------------------------");
		    System.out.println("Thanks for visiting. See you next time!");
		    System.out.println("----------------------------------------------------");
		    System.exit(0);
		}
		
		User user = users.get(userId);
		
		Operations op=new Operations(movie,theatres,accService,ticketService,user);
		int num = Features();
		Operations.operation(num);
		
		InputScanner.closeScanner();
	}
	
	
	private static int getChoice() {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Your Choice : ");
		
		String input = sc.nextLine();

		 try {
	            int num = Integer.parseInt(input);
	            if (num > 0 && num <= 4 ) {
	            	return num;
	            	
	            } else {
	                System.err.println("Please enter a valid number.");
	                 return getChoice();
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Not an integer.");
	             return getChoice();
	        }
	   
	}


	public static int getUserPassword() {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Your PIN : ");
		
		String input = sc.nextLine();

		 try {
	            int num = Integer.parseInt(input);
	            if (num > 0 ) {
	            	return num;
	            	
	            } else {
	                System.err.println("Please enter a valid number.");
	                 return getUserPassword();
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Not an integer.");
	             return getUserPassword();
	        }
	   }
	


	private static int getUserId(int size) {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter User Id : ");
		
		String input = sc.nextLine();

		 try {
	            int num = Integer.parseInt(input);
	            if (num > 0 && num <=size ) {
	            	return num;
	            	
	            } else {
	                System.err.println("Please enter a valid number.");
	                 return getUserId(size);
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Not an integer.");
	             return getUserId(size);
	        }
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
