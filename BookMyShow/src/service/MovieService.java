package service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.BookMyShow;
import main.InputScanner;
import main.Movies;
import main.Operations;

public class MovieService {
	static HashMap<Integer,Movies> movies;

	@Override
	public String toString() {
		return "MovieService [toString()=" + super.toString() + "]";
	}

	List<Integer> listTheatre;

	public MovieService(HashMap<Integer,Movies> movie) {
		this.movies = movie;

	}

	static void initializeMovies() {

		movies.put(1,new Movies(1, "Inception", "2h 28m", "Sci-Fi", "English", Arrays.asList(101, 102)));
		movies.put(2,new Movies(2, "3 Idiots", "2h 45m", "Comedy", "Hindi", Arrays.asList(101, 103, 104)));
		movies.put(3,new Movies(3, "Vikram", "2h 55m", "Action", "Tamil", Arrays.asList(102, 103)));
		movies.put(4,new Movies(4, "RRR", "3h 2m", "Action", "Telugu", Arrays.asList(101, 104, 105)));
		movies.put(5,new Movies(5, "Spirited Away", "2h 5m", "Fantasy", "Japanese", Arrays.asList(102, 105)));
		movies.put(6,new Movies(6, "Bahubali", "2h 40m", "Historical", "Telugu", Arrays.asList(101, 103, 105)));
		movies.put(7,new Movies(7, "Interstellar", "2h 49m", "Sci-Fi", "English", Arrays.asList(102, 104)));
		movies.put(8,new Movies(8, "Jawan", "2h 30m", "Action", "Hindi", Arrays.asList(101, 102, 103)));

	}

	public void displayAllMovie() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("| %-4s | %-15s |%-8s | %-10s | %-10s | %-15s |\n", "ID", "Title", "Duration", "Genre",
				"Language", "Theatres");
		System.out.println("--------------------------------------------------------------------------------");

		for (Movies movie : movies.values()) {
			String theatres = movie.listTheatre.toString().replace("[", "").replace("]", "");
			System.out.printf("| %-4d | %-15s |%-8s | %-10s | %-10s | %-15s |\n", movie.getMovieId(), movie.getTitle(),
					movie.getDuration(), movie.getGenre(), movie.getLanguage(), theatres);
		}

		System.out.println("--------------------------------------------------------------------------------\n");
	}

	public static HashMap<Integer, Movies> getMovies() {
		return movies;
	}

	public static void setMovies(HashMap<Integer, Movies> movies) {
		MovieService.movies = movies;
	}

	public List<Integer> getListTheatre() {
		return listTheatre;
	}

	public void setListTheatre(List<Integer> listTheatre) {
		this.listTheatre = listTheatre;
	}

	public void searchMovie() {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter Movie Name : ");
		String movieName = sc.nextLine();
		boolean found = false;
		for (int i = 1; i <= movies.size(); i++) {
			Movies mov = movies.get(i);
			String mo = mov.getTitle();

			if (mo.equalsIgnoreCase(movieName)) {
				found = true;
				System.out.println("\n" + mov.toString());
			}
		}

		if (!found) {
			System.err.println("Movie not found or invalid. Please check the name and try again.");
			displayAllMovie();
			searchMovie();
		}
	}

	public void movieByGenre() {
		HashMap<Integer, String> listGenre = new HashMap<>();
		int count = 0;

		for (Movies movie : movies.values()) {
			String genre = movie.getGenre();
			if (!listGenre.containsValue(genre)) {
				listGenre.put(++count, genre);
			}
		}

		System.out.println("\nAvailable Genres:");
		listGenre.forEach((key, value) -> System.out.println(key + ". " + value));

		System.out.print("Enter the Genre number: ");
		Scanner sc = InputScanner.getScanner();
		boolean found = false;

		try {
			int genNumber = sc.nextInt();
			String selectedGenre = listGenre.get(genNumber);
			sc.nextLine();

			if (selectedGenre != null) {
				System.out.println("\nMovies in " + selectedGenre + " Genre:\n");

				for (Movies mov : movies.values()) {
					if (mov.getGenre().equalsIgnoreCase(selectedGenre)) {
						found = true;
						System.out.println(mov.toString());
					}
				}

				if (!found) {
					System.err.println("No movies found for selected genre.");
				}
			} else {
				System.err.println("Invalid genre selection.");
			}

		} catch (InputMismatchException e) {
			System.err.println("Invalid input. Please enter a number.");
			sc.nextLine();
		}
		if (!found) {
			movieByGenre();
		}
	}

}
