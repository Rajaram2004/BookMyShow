package main;
import java.util.Scanner;

public class InputScanner {
	private static final Scanner SCANNER = new Scanner(System.in);
	private InputScanner() {
		
	}
	 public static Scanner getScanner() {
	        return SCANNER;
	    }

	    public static void closeScanner() {
	        SCANNER.close();
	    }
}
