package main;

import java.util.HashMap;

import bank.Account;
import service.BookingService;
import service.TicketService;

public class DataModule {
	HashMap<Integer,Theatre> theatre;
	HashMap<Integer,Movies> movies;
	HashMap<Integer, Account> bank;
	
	public DataModule(HashMap<Integer,Theatre> theatre,HashMap<Integer,Movies> movies,HashMap<Integer, Account> bank){
		this.theatre=theatre;
		this.movies=movies;
		this.bank=bank;
		
	}
	

	HashMap<Integer, Ticket> ticketMap = new HashMap<>();
	TicketService ticketService = new TicketService( theatre, movies);

	HashMap<Integer, Booking> booking = new HashMap<>();
	BookingService bookingService = new BookingService(booking, bank);
	
	

	public HashMap<Integer, Theatre> getTheatre() {
		return theatre;
	}
	public void setTheatre(HashMap<Integer, Theatre> theatre) {
		this.theatre = theatre;
	}
	public HashMap<Integer, Movies> getMovies() {
		return movies;
	}
	public void setMovies(HashMap<Integer, Movies> movies) {
		this.movies = movies;
	}
	public HashMap<Integer, Account> getBank() {
		return bank;
	}
	public void setBank(HashMap<Integer, Account> bank) {
		this.bank = bank;
	}
	public HashMap<Integer, Ticket> getTicketMap() {
		return ticketMap;
	}
	public void setTicketMap(HashMap<Integer, Ticket> ticketMap) {
		this.ticketMap = ticketMap;
	}
	public TicketService getTicketService() {
		return ticketService;
	}
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	public HashMap<Integer, Booking> getBooking() {
		return booking;
	}
	public void setBooking(HashMap<Integer, Booking> booking) {
		this.booking = booking;
	}
	public BookingService getBookingService() {
		return bookingService;
	}
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
}
