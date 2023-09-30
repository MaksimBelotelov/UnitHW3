package seminars.third.tdd;

public class User {

    String name;
    String password;
    boolean isAdmin = false;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (name.equals(this.name))
            if(password.equals(this.password)) {
                this.isAuthenticate = true;
                return true;
            }
        return false;
    }

}