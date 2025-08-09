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
	private  List<Theatre> theatre;
	private List<Movies> movies;
	
	public TheatreService(List<Theatre> theatre,List<Movies> movies) {
		this.theatre = theatre;
		this.movies=movies;
		
		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre1=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{1,2, 3}, 100,moviesInOurTheatre1);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre2=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{4, 5, 6}, 120,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{4, 5}, 100,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{4,5, 6}, 100,moviesInOurTheatre1);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre3=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{1,2, 3}, 100,moviesInOurTheatre1);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre4=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{1,2, 3}, 100,moviesInOurTheatre1);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre5=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{1,2, 3}, 100,moviesInOurTheatre1);
        

        theatre.add(new Theatre(101, "INOX", "Chennai", 120, 200.0, moviesInOurTheatre1));
        theatre.add(new Theatre(102, "PVR", "Bangalore", 150, 200.0, moviesInOurTheatre2));
        theatre.add(new Theatre(103, "SPI Cinemas", "Hyderabad", 100, 200.0, moviesInOurTheatre3));
        theatre.add(new Theatre(104, "Escape", "Mumbai", 180, 200.0, moviesInOurTheatre4));
        theatre.add(new Theatre(105, "Cinepolis", "Delhi", 200, 200.0, moviesInOurTheatre5));
		

	}
	
	
	 public void initializeSeats(LocalDate date, int[] movieIds, int seatsPerMovie,Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre) {
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



//	    public void printSeats() {
//	        for (Map.Entry<LocalDate, Map<Integer, Integer>> entry : moviesInOurTheatre.entrySet()) {
//	            System.out.println("Date: " + entry.getKey());
//	            for (Map.Entry<Integer, Integer> movieEntry : entry.getValue().entrySet()) {
//	                System.out.println("  Movie " + movieEntry.getKey() + " -> " + movieEntry.getValue() + " seats");
//	            }
//	        }
//	    }
	
	

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

	public  List<Theatre> getTheatreList() {
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

	public Map<LocalDate, Map<Integer,Integer>> getMoviesInOurTheatre() {
		return moviesInOurTheatre;
	}

	public void setMoviesInOurTheatre(Map<LocalDate, Map<Integer,Integer>>moviesInOurTheatre) {
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
