package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if(!findByName(user.name)) {
            if (user.isAuthenticate) {
                data.add(user);
            }
            else
                System.out.println("Пользователь не авторизован");
        }
        else
            System.out.println("Пользователь есть в базе");
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutIfNotAdmin() {
        for (User user : data) {
            if (!user.isAdmin)
                user.isAuthenticate = false;
        }
    }
}