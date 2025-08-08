package bank;

public class Account {
	private int accountId;
	private String name;
	private double balance;
	private int password;
	
	public Account(int accountId, String name, double balance,int password) {
		this.accountId = accountId;
		this.name = name;
		this.balance = balance;
		this.password=password;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
