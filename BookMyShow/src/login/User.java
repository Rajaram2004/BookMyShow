package login;
public class User {
    private int userId;
    private String name;
    private int password; 

    public User(int userId, String name, int password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
               "userId=" + userId +
               ", name='" + name + '\'' +
               '}';
    }
}
