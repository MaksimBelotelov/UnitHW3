package seminars.third.hw;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    @Test
    void testEvenOddNumberEvenTrue() {
        assertTrue(MainHW.evenOddNumber(4));
    }

    @Test
    void testEvenOddNumberEvenFalse() {
        assertFalse(MainHW.evenOddNumber(3));
    }

    @Test
    void testNumberInIntervalLess() {
        assertFalse(MainHW.numberInInterval(1));
    }

    @Test
    void testNumberInIntervalLowBound() {
        assertFalse(MainHW.numberInInterval(25));
    }

    @Test
    void testNumberInIntervalIn() {
        assertTrue(MainHW.numberInInterval(50));
    }

    @Test
    void testNumberInIntervalHiBound() {
        assertFalse(MainHW.numberInInterval(100));
    }

    @Test
    void testNumberInIntervalMore() {
        assertFalse(MainHW.numberInInterval(120));
    }

}
