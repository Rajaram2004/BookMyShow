package service;

import java.util.HashMap;
import java.util.Scanner;

import bank.Account;
import main.BookMyShow;
import main.InputScanner;
import main.Operations;

public class AccountService {
	static HashMap<Integer, Account> account;
	static int paidAccountId;

	public AccountService(HashMap<Integer, Account> account) {
		this.account = account;
		account.put(1, new Account(101, "Alice Johnson", 1500000000000.75, 1234));
		account.put(2, new Account(102, "Bob Smith", 2500.50, 5678));
		account.put(3, new Account(103, "Charlie Brown", 3200.00, 0000));
	}

	public void deposit() {
		int accountNumber = getAccounNumber();
		Account acc = account.get(accountNumber);
		double balance = acc.getBalance();
		double newBalance = (getAmount() + balance);
		acc.setBalance(newBalance);
		System.out.println("Money Added To A Bank Account");

		int num = BookMyShow.Features();
		Operations.operation(num);

	}

	@Override
	public String toString() {
		return "AccountService [toString()=" + super.toString() + "]";
	}

	public static boolean checkPassword(int accountNumber) {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter the Account PIN : ");
		String input = sc.nextLine();

		try {
			int num = Integer.parseInt(input);
			int pass = account.get(accountNumber).getPassword();
			if (num > 0 && pass == num) {
				return true;
			} else {
				System.err.println("Please enter a valid PIN.");
				return checkPassword(accountNumber);
			}
		} catch (NumberFormatException e) {
			System.err.println("Not an integer.");
			return checkPassword(accountNumber);
		}
	}

	public void checkBalance() {
		int accountNumber = getAccounNumber();
		Account acc = account.get(accountNumber);
		if (checkPassword(accountNumber)) {
			System.out.println(acc.getBalance());
		}

		int num = BookMyShow.Features();
		Operations.operation(num);

	}

	public static int getAccounNumber() {
		int n=account.size();
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter the Account Number : ");
		String input = sc.nextLine();

		try {
			int num = Integer.parseInt(input);
			if (num > 0 && num <= n) {
				return num;
			} else {
				System.err.println("Please enter a valid number.");
				return getAccounNumber();
			}
		} catch (NumberFormatException e) {
			System.err.println("Not an integer.");
			return getAccounNumber();
		}
	}
	public static boolean withdrawMoney(double withdrawAmount) {
			int accountNumber=getAccounNumber();
			Account userAccount =account.get(accountNumber);
			if(checkPassword(accountNumber)) {
				double accountBalance = userAccount.getBalance();
				if(accountBalance > withdrawAmount) {
					accountBalance -= withdrawAmount;
					userAccount.setBalance(accountBalance);
					paidAccountId=accountNumber;
					TicketService.setPaidAccountId(accountNumber);
					System.out.println(withdrawAmount+" Rupees successfully Debited From Your Bank Account");
					return true;
				}else {
					System.err.println("Insufficient Amount In Your Bank Account");
					System.err.println("Please Re-Enter The Ticket Count.");
					return false;
				}
			
			}else {
				System.err.println("PIN Mismatch.Please Enter A Valid PIN");
				withdrawMoney(withdrawAmount);
			}
		return false;
		
	}
	private static double getAmount() {
		Scanner sc = InputScanner.getScanner();
		System.out.print("Enter The Amount You Want To Deposit / Withdraw : ");
		String input = sc.nextLine();

		try {
			double num = Double.parseDouble(input);
			if (num > 0) {
				return num;
			} else {
				System.err.println("Please enter a valid number.");
				return getAmount();
			}
		} catch (NumberFormatException e) {
			System.err.println("Not an integer.");
			return getAmount();
		}
	}

}
