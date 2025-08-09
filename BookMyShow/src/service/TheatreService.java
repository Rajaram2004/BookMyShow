package service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
		
		initializeTheatre();
		

	}
	
	public void initializeTheatre(){
		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre1=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre1);
        initializeSeats(LocalDate.of(2025, 8, 13), new int[]{1,2, 3}, 100,moviesInOurTheatre1);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre2=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{4, 5, 6}, 120,moviesInOurTheatre2);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{4, 5}, 100,moviesInOurTheatre2);
        initializeSeats(LocalDate.of(2025, 8, 13), new int[]{4,5, 6}, 100,moviesInOurTheatre2);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre3=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre3);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre3);
        initializeSeats(LocalDate.of(2025, 8, 13), new int[]{1,2, 3}, 100,moviesInOurTheatre3);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre4=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre4);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre4);
        initializeSeats(LocalDate.of(2025, 8, 13), new int[]{1,2, 3}, 100,moviesInOurTheatre4);
        

		Map<LocalDate, Map<Integer,Integer>> moviesInOurTheatre5=new HashMap<>();
		
		initializeSeats(LocalDate.of(2025, 8, 11), new int[]{1, 2, 3}, 120,moviesInOurTheatre5);
        initializeSeats(LocalDate.of(2025, 8, 12), new int[]{2, 3}, 100,moviesInOurTheatre5);
        initializeSeats(LocalDate.of(2025, 8, 13), new int[]{1,2, 3}, 100,moviesInOurTheatre5);
        

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
	    System.out.println("----------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-20s | %-30s |\n", "Movie ID", "Title", "Theatre IDs");
	    System.out.println("----------------------------------------------------------------------");

	    for (Movies m : movies) {
	        System.out.printf("| %-10d | %-20s | %-30s |\n",
	                m.getMovieId(),
	                m.getTitle(),
	                m.getListTheatre());
	    }

	    System.out.println("----------------------------------------------------------------------");
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

	

	@Override
	public String toString() {
		return "TheatreService [toString()=" + super.toString() + "]";
	}

	public void displayTheatreWiseMovies() {
	    moviesInTheatre();

	    System.out.println("\n--------------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-20s | %-30s |\n", "Theatre ID", "Theatre Name", "Date-wise Movie Seats");
	    System.out.println("---------------------------------------------------------------------------");

	    for (Theatre t : theatre) {
	        Map<LocalDate, Map<Integer, Integer>> dateWiseSeats = t.getAvailableTicketOnDate();

	        boolean firstRow = true;
	        for (Map.Entry<LocalDate, Map<Integer, Integer>> entry : dateWiseSeats.entrySet()) {
	            if (firstRow) {
	               
	                System.out.printf("| %-10d | %-20s | %s : %s |\n",
	                        t.getTheatreId(),
	                        t.getName(),
	                        entry.getKey(),
	                        entry.getValue());
	                firstRow = false;
	            } else {
	                
	                System.out.printf("| %-10s | %-20s | %s : %s |\n",
	                        "",
	                        "",
	                        entry.getKey(),
	                        entry.getValue());
	            }
	        }
	        System.out.println("--------------------------------------------------------------------------");
	    }
	}


}



