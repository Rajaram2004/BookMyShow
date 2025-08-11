package main;

import java.util.Scanner;

import service.BookingService;
import service.TheatreService;

public class AdminOperations {
	AdminOperations(){
		
	}
	
	public static void adminOperations(){
		int adminChoice =adminFeatures();
		switch(adminChoice) {
		case 1:
			BookingService.printAllBookings();
			adminOperations();
			break;
		case 2:
			TheatreService.addTheatreWithMovies();
		case 3:
			System.out.println("Thank you");
			break;
			
		}
	}
	
	
	public static int adminFeatures() {
		System.out.println("\n========= Welcome to Movie Booking System Admin =============");
		System.out.println("Please select one of the following options:\n");

		String[] features = { "1 . View All Bookings ","2 . Add new Theatre "
				,"3 . Exit" };

		int n = features.length;
		for (int i = 0; i < features.length; i++) {
			System.out.println("  " + features[i]);
		}

		System.out.println("\n===========================================================\n");

		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Your Choice : ");

		String input = sc.nextLine();

		try {
			int num = Integer.parseInt(input);
			if (num > 0 && num <= n) {
				return num;

			} else {
				System.err.println("Please enter a valid number.");
				return adminFeatures();
			}
		} catch (NumberFormatException e) {
			System.err.println("Not an integer.");
			return adminFeatures();
		}
	}
	
}
