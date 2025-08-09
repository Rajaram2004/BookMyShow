package service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import main.BookMyShow;
import main.Booking;
import main.InputScanner;
import main.Movies;
import main.Operations;
import main.Theatre;
import main.Ticket;

public class TicketService {
    HashMap<Integer, Ticket> book;
    private List<Theatre> theatre;
    List<Movies> movies;
    
    static int paidAccountId;
    public int getPaidAccountId() {
		return paidAccountId;
	}


	public static void setPaidAccountId(int paidAccountId) {
		paidAccountId = paidAccountId;
	}


	public TicketService(HashMap<Integer, Ticket> booking, List<Theatre> theatre, List<Movies> movies) {
        this.book = booking;
        this.theatre = theatre;
        this.movies = movies;
    }
    
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

    public void bookTicket() {
        Theatre theatreId = getTheatre();
        Movies movieId = getMovie(theatreId);
        
        System.out.println("\n" + theatreId.toString());
        System.out.println(movieId.toString()+"\n");

        LocalDate bookingDate = getBookingDate(theatreId);
        int ticketCount=0;
        double withdrawAmount = 0;
        int accId=0;
        boolean flag=false;
        while(!flag) {
            ticketCount = getTicketCount(theatreId, bookingDate,movieId);
            withdrawAmount = ticketCount * theatreId.getPricePerTicket();
            flag= AccountService.withdrawMoney(withdrawAmount);
            accId=AccountService.paidAccountId;
            
        }
       
        int nextBookingId = BookingService.nextBookingId();
        String UserName = getUserName();
        
       
        Booking book =new Booking(nextBookingId,UserName,movieId,theatreId,
        		bookingDate,ticketCount,withdrawAmount,accId);
        
        BookingService.addBooking(book);
        
        
        //List<Theatre> theatreList = theatreId.getTheatreList();
 
        updateTicket(theatreId,bookingDate,ticketCount,movieId);
        System.out.println("Thank you "+UserName+" "+ticketCount+" Tickets Booked");
        int num = BookMyShow.Features();
		Operations.operation(num);
    }



//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private void updateTicket(Theatre theatreId,LocalDate bookingDate,int ticketCount,Movies movieId) {
    	Map<LocalDate, Map<Integer,Integer>>  availableSeats = theatreId.getAvailableTicketOnDate();
    	 int total = availableSeats.get(bookingDate).get(movieId.getMovieId());
    	 total-=ticketCount;
    	 System.err.println("Total seats : "+availableSeats.get(bookingDate));
    	 availableSeats.get(bookingDate).put(movieId.getMovieId(),total);
    	 System.err.println("Remaining Seats : "+availableSeats.get(bookingDate));
    }
    
    public String getUserName() {
        Scanner scanner = InputScanner.getScanner();
        String name;

        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();

            if (name.matches("^[A-Za-z ]{2,}$")) {
                break;
            } else {
                System.err.println("Invalid name. Only letters and spaces allowed, minimum 2 characters.");
            }
        }

        return name;
    }

    
    private LocalDate getBookingDate(Theatre theatre) {
        LocalDate bookingDate = null;
        Scanner scanner = InputScanner.getScanner();
        Map<LocalDate, Map<Integer,Integer>> availableSeats = theatre.getAvailableTicketOnDate();

        while (true) {
            try {
                System.out.println("Enter booking date (yyyy-MM-dd): ");
                String input = scanner.nextLine();
                bookingDate = LocalDate.parse(input);

                if (availableSeats.containsKey(bookingDate)) {
                    break; // valid date
                } else {
                    System.err.println("Selected date is not available in this theatre. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }

        return bookingDate;
    }

    private int getTicketCount(Theatre theatre, LocalDate date,Movies movieId) {
        Scanner sc = InputScanner.getScanner();
        System.out.println("Enter number of tickets: ");
        String input = sc.nextLine();
        try {
            int num = Integer.parseInt(input);
            if (num > 0 && isTicketAvailable(theatre, date, num,movieId)) {
                return num;
            } else {
                System.err.println("Not enough tickets available on selected date.");
                return getTicketCount(theatre, date, movieId);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number.");
            return getTicketCount(theatre, date,movieId) ;
        }
    }

    private boolean isTicketAvailable(Theatre theatre, LocalDate date, int count,Movies movieId) {
    	Map<LocalDate, Map<Integer,Integer>> dateWiseSeats = theatre.getAvailableTicketOnDate();
        if (!dateWiseSeats.containsKey(date)) return false;
        int available = dateWiseSeats.get(date).get(movieId.getMovieId());
        return available >= count;
    }

    private void availableMovieInTheatre(int theatreId) {
        System.out.println("\nAvailable Movies in Theatre ID " + theatreId);
        System.out.println("-----------------------------------------------");
        System.out.printf("| %-10s | %-30s |\n", "Movie ID", "Movie Title");
        System.out.println("-----------------------------------------------");

        boolean movieFound = false;

        for (Movies m : movies) {
            if (m.getListTheatre().contains(theatreId)) {
                System.out.printf("| %-10d | %-30s |\n", m.getMovieId(), m.getTitle());
                movieFound = true;
            }
        }

        if (!movieFound) {
            System.out.println("No movies found for the selected theatre.");
        }

        System.out.println("-----------------------------------------------\n");
    }

    private Theatre getTheatre() {
        Scanner sc = InputScanner.getScanner();
        System.out.println("Enter the Theatre Id : ");
        String input = sc.nextLine();

        try {
            int id = Integer.parseInt(input);
            for (Theatre t : theatre) {
                if (t.getTheatreId() == id) {
                    System.out.println("You have selected " + t.getName() + " Theatre");
                    return t;
                }
            }
            System.err.println("Theatre ID not found.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a valid integer.");
        }

        return getTheatre(); // Retry
    }

    private Movies getMovie(Theatre theatre) {
        int theatreId = theatre.getTheatreId();
        availableMovieInTheatre(theatreId);

        Scanner sc = InputScanner.getScanner();
        System.out.print("Enter the Movie Id : ");
        String input = sc.nextLine();

        try {
            int id = Integer.parseInt(input);
            for (Movies m : movies) {
                if (m.getMovieId() == id) {
                    if (m.getListTheatre().contains(theatreId)) {
                        System.out.println("You have selected " + m.getTitle() + " Movie");
                        return m;
                    } else {
                        System.err.println(m.getTitle() + " is not available in " + theatre.getName());
                    }
                }
            }
            System.err.println("Movie ID not found.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a valid integer.");
        }

        return getMovie(theatre); // Retry
    }
}
