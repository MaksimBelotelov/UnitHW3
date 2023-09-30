package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user;

    @BeforeEach
    void init() {
        user = new User("Ivanov", "qwerty", true);
    }

    @Test
    void testWrongLogin() {
        assertFalse(user.authenticate("Ivan", "qwerty"));
    }

    @Test
    void testWrongPassword() {
        assertFalse(user.authenticate("Ivanov", "qwert"));
    }

    @Test
    void testWrongLoginAndPass() {
        assertFalse(user.authenticate("Petrov", "123"));
    }

    @Test
    void testRight() {
        assertTrue(user.authenticate("Ivanov", "qwerty"));
    }
}