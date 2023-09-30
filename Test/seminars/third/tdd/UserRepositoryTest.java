package seminars.third.tdd;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {
    @Test
    void testAddAuthenticated() {
        User user = new User("Ivan", "qwerty", false);
        UserRepository repo = new UserRepository();
        user.authenticate("Ivan", "qwerty");
        repo.addUser(user);
        assertThat(user).isIn(repo.data);
    }

    @Test
    void testAddAuthenticatedDouble() {
        User user = new User("Ivan", "qwerty", false);
        UserRepository repo = new UserRepository();
        user.authenticate("Ivan", "qwerty");
        repo.addUser(user);
        int size1 = repo.data.size();
        repo.addUser(user);
        int size2 = repo.data.size();
        assertThat(size1).isEqualTo(size2);
    }

    @Test
    void testAddUnauthenticated() {
        User user = new User("Petr", "asdf", false);
        UserRepository repo = new UserRepository();
        user.authenticate("Petr", "qwerty");
        repo.addUser(user);
        assertThat(user).isNotIn(repo.data);
    }

    @Test
    void testLogOutIfNotAdmin() {
        User userAdmin = new User("Ivan", "password", true);
        User userUser = new User("Petr", "qwerty", false);
        UserRepository repo = new UserRepository();

        userAdmin.authenticate("Ivan", "password");
        userUser.authenticate("Petr", "qwerty");
        repo.addUser(userAdmin);
        repo.addUser(userUser);
        repo.logoutIfNotAdmin();

        assertFalse(repo.data.get(1).isAuthenticate);
        assertTrue(repo.data.get(0).isAuthenticate);
    }
}
