package main;

public class Ticket {
	
	private int ticketId;
	private String bookingPersonName;
	private int numberOfTicket;
	private boolean isActive;
	private double amountPaid;
	
	public Ticket(int ticketId, String bookingPersonName, int numberOfTicket, boolean isActive, double amountPaid) {
		this.ticketId = ticketId;
		this.bookingPersonName = bookingPersonName;
		this.numberOfTicket = numberOfTicket;
		this.isActive = isActive;
		this.amountPaid = amountPaid;
	}
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getticketId() {
		return ticketId;
	}
	public void setticketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getBookingPersonName() {
		return bookingPersonName;
	}
	public void setBookingPersonName(String bookingPersonName) {
		this.bookingPersonName = bookingPersonName;
	}
	public int getNumberOfTicket() {
		return numberOfTicket;
	}
	public void setNumberOfTicket(int numberOfTicket) {
		this.numberOfTicket = numberOfTicket;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
}
