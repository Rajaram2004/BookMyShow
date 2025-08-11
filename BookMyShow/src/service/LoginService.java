package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bank.Account;
import login.User;
import main.AdminOperations;
import main.DataModule;
import main.InputScanner;
import main.Movies;
import main.Operations;
import main.Theatre;

public class LoginService {

	public static void Start() {

		HashMap<Integer, Movies> movies = new HashMap<>();
		MovieService movieService = new MovieService(movies);
		MovieService.initializeMovies();

		HashMap<Integer, Theatre> theatre = new HashMap<>();
		
		TheatreService theatreService = new TheatreService(theatre, movies);
		TheatreService.initializeTheatre();

		HashMap<Integer, Account> bank = new HashMap<>();
		AccountService accService = new AccountService(bank);

		Map<Integer, User> users = new HashMap<>();
		UserService userService = new UserService(users);

		HashMap<Integer, DataModule> dataModule = new HashMap<>();
		dataModule.put(1,new DataModule(theatre,movies,bank));
		dataModule.put(2,new DataModule(theatre,movies,bank));
		
		boolean clickExit = false;
		
		while(!clickExit) {
			int newId=0;
			boolean userValid = false;
			System.out.println("\n========= Welcome to Movie Booking System =========");
			System.out.println("|		  1.User Login                    |");
			System.out.println("|		  2.Admin Login                   |");
			System.out.println("|		  3.Create New User               |");
			System.out.println("|	   	  4.Exit                          |");
			System.out.println("---------------------------------------------------");
			int userId = 0;
			int getChoice = getChoice();
			

			if (getChoice == 2) {
				boolean isPinValid =false;
				while(!isPinValid) {
					System.out.println("Enter the Admin PIN  : ");
					int adminPin =getUserPassword();
					if(adminPin==1234) {
						isPinValid=true;
						AdminOperations.adminOperations();
					}else {
						System.err.println("PIN is Wrong Please ReEnter");
					}
				}
				
				
			} else if (getChoice == 3) {
				System.out.println("Creating New User");
				newId = userService.addUser();
				dataModule.put(newId,new DataModule(theatre,movies,bank));
				getChoice = 1;
			} else if (getChoice == 4) {
				
				System.out.println("\nYou have Selected Exit");
				System.out.println("----------------------------------------------------");
				System.out.println("Thanks for visiting. See you next time!");
				System.out.println("----------------------------------------------------");
				break;
				//System.exit(0);
			}

			if (getChoice == 1) {
				while (!userValid) {

					System.out.println("---------------User Login-----------------------");
					userId = getUserId(users.size());
					int password = getUserPassword();
					boolean user = userService.isValidUserId(userId);
					if (userService.validateUser(userId, password)) {
						userValid = true;
						newId = userId;
					} else {
						System.err.println("Pin Mismatch Please Enter Correct Pin ");
					}
				}
				TicketService ts = dataModule.get(newId).getTicketService();
				System.out.println(ts);
				
				User user = users.get(newId);
				Operations op = new Operations(movieService, theatreService, accService,ts , user);
				
				int num = Operations.Features();
				Operations.operation(num);
				
			}
			
			

		}
		
		
		InputScanner.closeScanner();
	}

	private static int getChoice() {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Your Choice : ");

		String input = sc.nextLine();

		try {
			int num = Integer.parseInt(input);
			if (num > 0 && num <= 4) {
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
			if (num > 0) {
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
			if (num > 0 && num <= size) {
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

}
