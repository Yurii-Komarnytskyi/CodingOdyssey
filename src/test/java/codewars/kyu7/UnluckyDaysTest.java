package codewars.kyu7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnluckyDaysTest {

	@Test
    public void testSomething() {
        assertEquals(3, UnluckyDays.unluckyDays(2015));
        assertEquals(1, UnluckyDays.unluckyDays(1986));
    }
}
