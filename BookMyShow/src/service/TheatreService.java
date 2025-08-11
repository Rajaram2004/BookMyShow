package service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import main.InputScanner;
import main.Movies;
import main.Theatre;

public class TheatreService {
	private static HashMap<Integer,Theatre> theatre;
	private static HashMap<Integer,Movies> movies;

	public TheatreService(HashMap<Integer,Theatre> theatre, HashMap<Integer, Movies> movies) {
		this.theatre = theatre;
		this.movies = movies;
		
	}

	public static HashMap<Integer, Theatre> getTheatre() {
		return theatre;
	}

	public static void initializeTheatre() {
		Map<LocalDate, Map<Integer, Integer>> moviesInOurTheatre1 = new HashMap<>();

		initializeSeats(LocalDate.of(2025, 8, 11), new int[] { 1, 2, 4, 6, 8 }, 120, moviesInOurTheatre1);
		initializeSeats(LocalDate.of(2025, 8, 12), new int[] { 1, 2, 4, 6, 8 }, 100, moviesInOurTheatre1);
		initializeSeats(LocalDate.of(2025, 8, 13), new int[] { 1, 2, 4, 6, 8 }, 200, moviesInOurTheatre1);

		Map<LocalDate, Map<Integer, Integer>> moviesInOurTheatre2 = new HashMap<>();

		initializeSeats(LocalDate.of(2025, 8, 11), new int[] { 1, 3, 5, 7, 8 }, 120, moviesInOurTheatre2);
		initializeSeats(LocalDate.of(2025, 8, 12), new int[] { 1, 3, 5, 7, 8 }, 100, moviesInOurTheatre2);
		initializeSeats(LocalDate.of(2025, 8, 13), new int[] { 1, 3, 5, 7, 8 }, 200, moviesInOurTheatre2);

		Map<LocalDate, Map<Integer, Integer>> moviesInOurTheatre3 = new HashMap<>();

		initializeSeats(LocalDate.of(2025, 8, 11), new int[] { 2, 3, 6, 8 }, 120, moviesInOurTheatre3);
		initializeSeats(LocalDate.of(2025, 8, 12), new int[] { 2, 3, 6, 8 }, 100, moviesInOurTheatre3);
		initializeSeats(LocalDate.of(2025, 8, 13), new int[] { 2, 3, 6, 8 }, 200, moviesInOurTheatre3);

		Map<LocalDate, Map<Integer, Integer>> moviesInOurTheatre4 = new HashMap<>();

		initializeSeats(LocalDate.of(2025, 8, 11), new int[] { 2, 4, 7 }, 120, moviesInOurTheatre4);
		initializeSeats(LocalDate.of(2025, 8, 12), new int[] { 2, 4, 7 }, 100, moviesInOurTheatre4);
		initializeSeats(LocalDate.of(2025, 8, 13), new int[] { 2, 4, 7 }, 200, moviesInOurTheatre4);

		Map<LocalDate, Map<Integer, Integer>> moviesInOurTheatre5 = new HashMap<>();

		initializeSeats(LocalDate.of(2025, 8, 11), new int[] { 4, 5, 6 }, 120, moviesInOurTheatre5);
		initializeSeats(LocalDate.of(2025, 8, 12), new int[] { 4, 5, 6 }, 100, moviesInOurTheatre5);
		initializeSeats(LocalDate.of(2025, 8, 13), new int[] { 4, 5, 6 }, 200, moviesInOurTheatre5);

		TheatreService.theatre.put(101,new Theatre(101, "INOX", "Chennai", 120, 200.0, moviesInOurTheatre1));
		TheatreService.theatre.put(102,new Theatre(102, "PVR", "Bangalore", 150, 200.0, moviesInOurTheatre2));
		TheatreService.theatre.put(103,new Theatre(103, "SPI Cinemas", "Hyderabad", 100, 200.0, moviesInOurTheatre3));
		TheatreService.theatre.put(104,new Theatre(104, "Escape", "Mumbai", 180, 200.0, moviesInOurTheatre4));
		TheatreService.theatre.put(105,new Theatre(105, "Cinepolis", "Delhi", 200, 200.0, moviesInOurTheatre5));
	}

	public static void initializeSeats(LocalDate date, int[] movieIds, int seatsPerMovie,
			Map<LocalDate, Map<Integer, Integer>> moviesInOurTheatre) {
		Map<Integer, Integer> movieSeats = new HashMap<>();
		for (int movieId : movieIds) {
			movieSeats.put(movieId, seatsPerMovie);
		}
		moviesInOurTheatre.put(date, movieSeats);
	}

	public void printSeats(Map<LocalDate, Map<Integer, Integer>> dateWiseSeats) {
		for (Map.Entry<LocalDate, Map<Integer, Integer>> dateEntry : dateWiseSeats.entrySet()) {
			System.out.println("Date: " + dateEntry.getKey());
			for (Map.Entry<Integer, Integer> movieEntry : dateEntry.getValue().entrySet()) {
				System.out.printf("  Movie %-3d | %-3d seats%n", movieEntry.getKey(), movieEntry.getValue());
			}
		}
	}

	public void displayAllTheatres() {
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("| %-5s | %-12s | %-15s | %-15s | %-15s |\n", 
	                      "ID", "Theatre Name", "Location", "Total Seats", "PricePerTicket");
	    System.out.println("-----------------------------------------------------------------------------");

	    for (Theatre t : theatre.values()) { 
	        System.out.printf("| %-5d | %-12s | %-15s | %-15d | %-15.2f |\n", 
	                          t.getTheatreId(), t.getName(),
	                          t.getLocation(), t.gettotalSeats(), t.getPricePerTicket());
	    }

	    System.out.println("-----------------------------------------------------------------------------");
	}


	public void moviesInTheatre() {
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("| %-10s | %-20s | %-30s |\n", "Movie ID", "Title", "Theatre IDs");
		System.out.println("----------------------------------------------------------------------");

		for (Movies m : movies.values()) {
			System.out.printf("| %-10d | %-20s | %-30s |\n", m.getMovieId(), m.getTitle(), m.getListTheatre());
		}

		System.out.println("----------------------------------------------------------------------");
	}

	public HashMap<Integer,Theatre> getTheatreList() {
		return theatre;
	}

	public void setTheatre(HashMap<Integer,Theatre> theatre) {
		this.theatre = theatre;
	}

	public HashMap<Integer,Movies> getMovies() {
		return movies;
	}

	public void setMovies(HashMap<Integer,Movies> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "TheatreService [toString()=" + super.toString() + "]";
	}

	public void displayTheatreWiseMovies() {
		moviesInTheatre();

		System.out.println("\n--------------------------------------------------------------------------");
		System.out.printf("| %-10s | %-20s | %-30s |\n", "Theatre ID", "Theatre Name", "Date-wise Movie Seats");
		System.out.println("---------------------------------------------------------------------------");
		movies = MovieService.movies;
		for (Theatre t : theatre.values()) {
			Map<LocalDate, Map<Integer, Integer>> dateWiseSeats = t.getAvailableTicketOnDate();

			boolean firstRow = true;
			for (Map.Entry<LocalDate, Map<Integer, Integer>> entry : dateWiseSeats.entrySet()) {
				if (firstRow) {

					System.out.printf("| %-10d | %-20s | %s : %s |\n", t.getTheatreId(), t.getName(), entry.getKey(),
							entry.getValue());
					firstRow = false;
				} else {

					System.out.printf("| %-10s | %-20s | %s : %s |\n", "", "", entry.getKey(), entry.getValue());
				}
			}
			System.out.println("--------------------------------------------------------------------------");
		}
	}
	
	public static void addTheatreWithMovies() {
	    Scanner sc = InputScanner.getScanner();

	    int newTheatreId = theatre.size() + 101; // keep your numbering scheme

	    // --- Theatre name ---
	    String theatreName;
	    while (true) {
	        System.out.print("Enter Theatre Name: ");
	        theatreName = sc.nextLine().trim();
	        if (theatreName.isEmpty()) {
	            System.err.println("Name cannot be empty. Try again.");
	        } else {
	            break;
	        }
	    }

	    // --- Location ---
	    String location;
	    while (true) {
	        System.out.print("Enter Location: ");
	        location = sc.nextLine().trim();
	        if (location.isEmpty()) {
	            System.err.println("Location cannot be empty. Try again.");
	        } else {
	            break;
	        }
	    }

	    // --- Total seats ---
	    int totalSeats;
	    while (true) {
	        System.out.print("Enter Total Seats: ");
	        String seatsInput = sc.nextLine().trim();
	        try {
	            totalSeats = Integer.parseInt(seatsInput);
	            if (totalSeats <= 0) {
	                System.err.println("Total seats must be a positive integer.");
	                continue;
	            }
	            break;
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid number. Enter a valid integer for seats.");
	        }
	    }

	    // --- Price per ticket ---
	    double pricePerTicket;
	    while (true) {
	        System.out.print("Enter Price Per Ticket: ");
	        String priceInput = sc.nextLine().trim();
	        try {
	            pricePerTicket = Double.parseDouble(priceInput);
	            if (pricePerTicket <= 0) {
	                System.err.println("Price must be a positive number.");
	                continue;
	            }
	            break;
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid amount. Enter a valid number for price.");
	        }
	    }

	    // --- Dates and movies ---
	    Map<LocalDate, List<Integer>> dateMovieMap = new LinkedHashMap<>(); // keep insertion order

	    while (true) {
	        System.out.print("Enter show date (YYYY-MM-DD) after 2025-08-11 or 'done' to finish: ");
	        String dateInput = sc.nextLine().trim();
	        if (dateInput.equalsIgnoreCase("done")) {
	            break;
	        }

	        LocalDate showDate;
	        try {
	            showDate = LocalDate.parse(dateInput);
	        } catch (Exception e) {
	            System.err.println("Invalid date format. Use YYYY-MM-DD. Try again.");
	            continue;
	        }

	        if (!showDate.isAfter(LocalDate.of(2025, 8, 11))) {
	            System.err.println("Date must be after 2025-08-11. Try again.");
	            continue;
	        }

	        // collect movie IDs for this date
	        Set<Integer> movieSet = new LinkedHashSet<>();
	        while (true) {
	            System.out.print("Enter Movie ID(s) for " + showDate + " (1–8). You can enter multiple separated by space/comma, or 'done' to finish this date: ");
	            String movieInputLine = sc.nextLine().trim();
	            if (movieInputLine.equalsIgnoreCase("done")) {
	                break;
	            }

	            // support comma or whitespace separated multiple ids in one line (e.g. "6 7 8" or "6,7,8")
	            String[] tokens = movieInputLine.split("[,\\s]+");
	            boolean anyValid = false;
	            for (String tok : tokens) {
	                if (tok.isEmpty()) continue;
	                try {
	                    int movieId = Integer.parseInt(tok);
	                    // validate movie id range and existence in MovieService
	                    if (movieId < 1 || movieId > 8) {
	                        System.err.println("Movie id " + movieId + " is out of range (1-8). Ignored.");
	                        continue;
	                    }
	                    if (MovieService.getMovies() == null || !MovieService.getMovies().containsKey(movieId)) {
	                        System.err.println("Movie id " + movieId + " does not exist in MovieService. Ignored.");
	                        continue;
	                    }
	                    movieSet.add(movieId);
	                    anyValid = true;
	                } catch (NumberFormatException nfe) {
	                    System.err.println("'" + tok + "' is not a valid number. Ignored.");
	                }
	            }

	            if (!anyValid) {
	                System.err.println("No valid movie IDs entered. Try again or type 'done' to cancel this date.");
	            } else {
	                // you may allow the user to add more movie IDs for same date in subsequent iterations
	                System.out.print("Add more movies for this date? (y/n): ");
	                String more = sc.nextLine().trim();
	                if (!more.equalsIgnoreCase("y")) {
	                    break;
	                }
	            }
	        } // end movie input loop

	        if (movieSet.isEmpty()) {
	            System.err.println("No movies added for date " + showDate + ". Skipping date.");
	        } else {
	            dateMovieMap.put(showDate, new ArrayList<>(movieSet));
	            System.out.println("Added " + movieSet.size() + " movie(s) for " + showDate);
	        }
	    } // end dates loop

	    if (dateMovieMap.isEmpty()) {
	        System.err.println("No dates were added. Theatre creation cancelled.");
	        return;
	    }

	    // --- Build dateWiseSeats: date -> (movieId -> availableSeats) ---
	    Map<LocalDate, Map<Integer, Integer>> dateWiseSeats = new LinkedHashMap<>();
	    for (Map.Entry<LocalDate, List<Integer>> e : dateMovieMap.entrySet()) {
	        Map<Integer, Integer> seatMap = new HashMap<>();
	        for (Integer movieId : e.getValue()) {
	            seatMap.put(movieId, totalSeats);
	        }
	        dateWiseSeats.put(e.getKey(), seatMap);
	    }

	    // --- Create theatre and store ---
	    Theatre newTheatre = new Theatre(newTheatreId, theatreName, location, totalSeats, pricePerTicket, dateWiseSeats);
	    theatre.put(newTheatreId, newTheatre);

	    // --- Update MovieService: add theatre id to each movie's theatre list ---
	    dateMovieMap.values().stream()
	            .flatMap(List::stream)
	            .distinct()
	            .forEach(movieId -> {
	                Movies movie = MovieService.getMovies().get(movieId);
	                if (movie != null) {
	                    // ensure list is mutable
	                    if (movie.getListTheatre() == null) {
	                        movie.setListTheatre(new ArrayList<>());
	                    }
	                    if (!movie.getListTheatre().contains(newTheatreId)) {
	                        movie.getListTheatre().add(newTheatreId);
	                    }
	                }
	            });

	    System.out.println("Theatre added successfully! ID = " + newTheatreId);
	    // optional: print the newly added schedule
	    System.out.println("Schedule for " + theatreName + ":");
	    for (Map.Entry<LocalDate, Map<Integer, Integer>> e : dateWiseSeats.entrySet()) {
	        System.out.println(" " + e.getKey() + " -> " + e.getValue());
	    }
	}


}
