package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp() { someService = new SomeService(); }

    @Test
    void testFirstLast6First() {
        assertTrue(someService.firstLast6(new int[] {6,1,2,3}));
    }

    @Test
    void testFirstLast6Last() {
        assertTrue(someService.firstLast6(new int[] {3,1,2,6}));
    }

    @Test
    void testFirstLast6FirstNLast() {
        assertTrue(someService.firstLast6(new int[] {6,1,2,6}));
    }

    @Test
    void testFirstLast6Middle() {
        assertFalse(someService.firstLast6(new int[] {1,6,2,3}));
    }

    @Test
    void testFirstLast6NoSixes() {
        assertFalse(someService.firstLast6(new int[] {1,1,2,3}));
    }

    @Test
    void testCalculatingPurchaseLessZero() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void testCalculatingDiscountLessZero() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(100, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100");
    }

    @Test
    void testCalculatingDiscountMore100() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(100, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100");
    }

    @Test
    void testCalculatingDiscountZero() {
        assertThat(someService.calculatingDiscount(100, 0))
                .isEqualTo(100);
    }

    @Test
    void testCalculatingDiscount100() {
        assertThat(someService.calculatingDiscount(100, 100))
                .isEqualTo(0);
    }

    @Test
    void testCalculatingDiscountNormal() {
        assertThat(someService.calculatingDiscount(100, 50))
                .isEqualTo(50);
    }


    @Test
    void testReturnFizz() { assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz"); }

    @Test
    void testReturnBuzz() { assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz"); }

    @Test
    void testReturnFizzBuzz() { assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz"); }

    @Test
    void testReturnEcho() { assertThat(someService.fizzBuzz(14)).isEqualTo("" + 14); }

    // 3.2
    @Test
    void testStartSixArray() {
        assertTrue(someService.firstLast6(new int[] {6, 1, 2, 3}));
    }

    @Test
    void testEndSixArray() {
        assertTrue(someService.firstLast6(new int[] {1, 2, 3, 6}));
    }

    @Test
    void testWithoutSixArray() {
        assertFalse(someService.firstLast6(new int[] {1, 2, 3, 4}));
    }

    @Test
    void testMiddleSixArray() {
        assertFalse(someService.firstLast6(new int[] {1, 6, 2, 3}));
    }

    @Test
    void luckySumA() {
        assertThat(someService.luckySum(13, 2, 3)).isEqualTo(5);
    }

    @Test
    void luckySumB() {
        assertThat(someService.luckySum(2, 13, 3)).isEqualTo(5);
    }

    @Test
    void luckySumC() {
        assertThat(someService.luckySum(2, 3, 13)).isEqualTo(5);
    }

    @Test
    void luckySumNoThirteen() {
        assertThat(someService.luckySum(1, 2, 3)).isEqualTo(6);
    }
}