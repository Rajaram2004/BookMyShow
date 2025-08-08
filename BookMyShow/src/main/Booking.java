package main;

import java.time.LocalDate;

public class Booking {
	int bookingId;
	String userName;
	Movies Movie;
	Theatre theatre;
	LocalDate bookingDate;
	int numberOfTickets;
	double totalAmount;
	boolean isActive;
	private int paidAccountId;
	public int getPaidAccountId() {
		return paidAccountId;
	}

	public void setPaidAccountId(int paidAccountId) {
		this.paidAccountId = paidAccountId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Booking(int bookingId, String userName, Movies movie, Theatre theatre,
			LocalDate bookingDate,int numberOfTickets, double totalAmount,int paidAccountId ){
		
		this.bookingId = bookingId;
		this.userName = userName;
		this.Movie = movie;
		this.theatre = theatre;
		this.bookingDate = bookingDate;
		this.numberOfTickets = numberOfTickets;
		this.totalAmount = totalAmount;
		this.paidAccountId=paidAccountId;
		this.isActive=true;
	}
	
	@Override
	public String toString() {
		return "BookingService [bookingId=" + bookingId + ", userName=" + userName + ", Movie=" + Movie + ", theatre="
				+ theatre + ", bookingDate=" + bookingDate + ", numberOfTickets=" + numberOfTickets + ", totalAmount="
				+ totalAmount + "]";
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Movies getMovie() {
		return Movie;
	}
	public void setMovie(Movies movie) {
		Movie = movie;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
