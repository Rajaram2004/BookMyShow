package service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.BookMyShow;
import main.Movies;
import main.Operations;
import main.Theatre;

public class TheatreService {
	private static List<Theatre> theatre;
	private List<Movies> movies;
	HashMap<Integer,Set<Integer>> moviesInOurTheatre=new HashMap<>();
	
	public TheatreService(List<Theatre> theatre,List<Movies> movies) {
		this.theatre = theatre;
		this.movies=movies;
		
		Map<LocalDate, Integer> dateWise1 = new HashMap<>();
		
		dateWise1.put(LocalDate.of(2025, 8, 11), 120);
		dateWise1.put(LocalDate.of(2025, 8, 12), 120);
		dateWise1.put(LocalDate.of(2025, 8, 13), 120);

		Map<LocalDate, Integer> dateWise2 = new HashMap<>();
		dateWise2.put(LocalDate.of(2025, 8, 11), 150);
		dateWise2.put(LocalDate.of(2025, 8, 12), 150);
		dateWise2.put(LocalDate.of(2025, 8, 13), 150);

		Map<LocalDate, Integer> dateWise3 = new HashMap<>();
		dateWise3.put(LocalDate.of(2025, 8, 11), 100);
		dateWise3.put(LocalDate.of(2025, 8, 12), 100);
		dateWise3.put(LocalDate.of(2025, 8, 13), 100);

		Map<LocalDate, Integer> dateWise4 = new HashMap<>();
		dateWise4.put(LocalDate.of(2025, 8, 11), 180);
		dateWise4.put(LocalDate.of(2025, 8, 12), 180);
		dateWise4.put(LocalDate.of(2025, 8, 13), 180);

		Map<LocalDate, Integer> dateWise5 = new HashMap<>();
		dateWise5.put(LocalDate.of(2025, 8, 11), 200);
		dateWise5.put(LocalDate.of(2025, 8, 12), 200);
		dateWise5.put(LocalDate.of(2025, 8, 13), 200);


        theatre.add(new Theatre(101, "INOX", "Chennai", 120, 200.0, dateWise1));
        theatre.add(new Theatre(102, "PVR", "Bangalore", 150, 200.0, dateWise2));
        theatre.add(new Theatre(103, "SPI Cinemas", "Hyderabad", 100, 200.0, dateWise3));
        theatre.add(new Theatre(104, "Escape", "Mumbai", 180, 200.0, dateWise4));
        theatre.add(new Theatre(105, "Cinepolis", "Delhi", 200, 200.0, dateWise5));
		

	}

	public void displayAllTheatres() {
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("| %-5s | %-12s |%-15s | %-15s | %-15s |\n", "ID", "Theatre Name", "Location", "Total Seats", "PricePerTicket");
	    System.out.println("-----------------------------------------------------------------------------");

	    for (Theatre t : theatre) {
	        System.out.printf("| %-5d | %-12s |%-15s | %-15d | %-15.2f |\n",
	                t.getTheatreId(), t.getName(), t.getLocation(), t.gettotalSeats(), t.getPricePerTicket());
	    }

	    System.out.println("-----------------------------------------------------------------------------");

	    int num = BookMyShow.Features();
	    Operations.operation(num);
	}


	
	public void moviesInTheatre() {
		
	    for (Theatre tempTheatre : theatre) {
	    	
	        int id = tempTheatre.getTheatreId();
	        moviesInOurTheatre.put(id, new HashSet<>());
	    }
	   
	    for (Movies tempMovies : movies) {
	        for (Integer id : tempMovies.listTheatre) {
	            if (moviesInOurTheatre.containsKey(id)) {
	                moviesInOurTheatre.get(id).add(tempMovies.getMovieId());
	            }
	        }
	    }
	    
	}

	public static List<Theatre> getTheatre() {
		return theatre;
	}

	public void setTheatre(List<Theatre> theatre) {
		this.theatre = theatre;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

	public HashMap<Integer, Set<Integer>> getMoviesInOurTheatre() {
		return moviesInOurTheatre;
	}

	public void setMoviesInOurTheatre(HashMap<Integer, Set<Integer>> moviesInOurTheatre) {
		this.moviesInOurTheatre = moviesInOurTheatre;
	}

	@Override
	public String toString() {
		return "TheatreService [toString()=" + super.toString() + "]";
	}

	public void displayTheatreWiseMovies(boolean callOperation) {
		moviesInTheatre();
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("| %-10s | %-20s | %-30s |\n", "Theatre ID", "Theatre Name", "Movie IDs");
		System.out.println("----------------------------------------------------------------------");

		for (Theatre t : theatre) {
		    int id = t.getTheatreId();
		    Set<Integer> movieIds = moviesInOurTheatre.getOrDefault(id, new HashSet<>());
		    System.out.printf("| %-10d | %-20s | %-30s |\n", id, t.getName(), movieIds.toString());
		}

		System.out.println("----------------------------------------------------------------------");
		if(callOperation) {
	    	 int num = BookMyShow.Features();
	 		Operations.operation(num);
	    }
	   
	}



}
