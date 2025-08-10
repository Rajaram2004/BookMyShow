package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import login.User;

public class UserService {

    private Map<Integer, User> users ;
    private Scanner scanner = new Scanner(System.in);

    public UserService(Map<Integer, User> users ) {
    	this.users=users;
        users.put(1, new User(1, "Alice", 1234));
        users.put(2, new User(2, "Bob", 5678));
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }

    public Map<Integer, User> getAllUsers() {
        return users;
    }

    public boolean isValidUserId(int userId) {
        return users.containsKey(userId);
    }

    public void addUser() {
        int newId = users.size() + 1;

        System.out.print("Enter username: ");
        String name = scanner.nextLine().trim();

        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter again: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("Enter password (only numbers) : ");
        String passwordInput = scanner.nextLine().trim();

        while (!passwordInput.matches("\\d+")) {
            System.out.print("Invalid password. Only digits allowed. Enter again: ");
            passwordInput = scanner.nextLine().trim();
        }

        int password = Integer.parseInt(passwordInput);

        users.put(newId, new User(newId, name, password));
        System.out.println("User added successfully! ID = " + newId);
    }

    public boolean validateUser(int userId, int password) {
        User user = users.get(userId);
        return user != null && user.getPassword() == password;
    }
}
