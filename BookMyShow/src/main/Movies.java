package main;

import java.util.List;

public class Movies {
	private int movieId;
	private String title;
	private String duration;
	private String genre;
	private String language;
	public List<Integer> listTheatre;
	public Movies(int movieId, String title, String duration, String genre, String language,List<Integer> listTheatre) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.duration = duration;
		this.genre = genre;
		this.language = language;
		this.listTheatre=listTheatre;
	}
	@Override
	public String toString() {
		return "\n============================================================================\n"+"Movies [movieId=" + movieId + ", title=" + title + ", duration=" + duration + ", genre=" + genre
				+ ", language=" + language +  "]"+"\n============================================================================\n";
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<Integer> getListTheatre() {
		return listTheatre;
	}
	public void setListTheatre(List<Integer> listTheatre) {
		this.listTheatre = listTheatre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	

}
