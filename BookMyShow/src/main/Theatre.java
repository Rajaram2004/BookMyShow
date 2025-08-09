package main;

import java.time.LocalDate;
import java.util.Map;

public class Theatre {
	private int theatreId;
	private String name;
	private String location;
	private int totalSeats;
	private double pricePerTicket;
	Map<LocalDate, Map<Integer,Integer>> dateWiseSeats;
	
	public Theatre(int theatreId,String name, String location, int totalSeats,double pricePerTicket, Map<LocalDate, Map<Integer,Integer>> dateWiseSeats) {
		this.theatreId=theatreId;
		this.name = name;
		this.location = location;
	    this.totalSeats=totalSeats;
		this.pricePerTicket=pricePerTicket;
		this.dateWiseSeats=dateWiseSeats;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Map<LocalDate, Map<Integer,Integer>> getdateWiseSeats() {
		return dateWiseSeats;
	}

	public void setdateWiseSeats(Map<LocalDate, Map<Integer,Integer>> dateWiseSeats) {
		this.dateWiseSeats = dateWiseSeats;
	}
	
	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public void settotalSeats(int totalSeats) {
		totalSeats = totalSeats;
	}

	public double getPricePerTicket() {
		return pricePerTicket;
	}
	public void setPricePerTicket(double pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int gettotalSeats() {
		return totalSeats;
	}
	public Map<LocalDate, Map<Integer,Integer>> getAvailableTicketOnDate(){
		return dateWiseSeats;
	}
	
	@Override
	public String toString() {
		return "============================================================================\n"+"Theatre [ name = " + name + ", location = " + location + ", totalSeats = " + totalSeats + " ]";
	}
	
}
