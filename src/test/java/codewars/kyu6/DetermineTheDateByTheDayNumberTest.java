package codewars.kyu6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DetermineTheDateByTheDayNumberTest {

	@Test
	void basicTest() {
		assertEquals("January, 15", DetermineTheDateByTheDayNumber.getDay(15, false));
		assertEquals("February, 10", DetermineTheDateByTheDayNumber.getDay(41, false));
		assertEquals("February, 28", DetermineTheDateByTheDayNumber.getDay(59, false));
		assertEquals("March, 1", DetermineTheDateByTheDayNumber.getDay(60, false));
		assertEquals("February, 29", DetermineTheDateByTheDayNumber.getDay(60, true));
		assertEquals("December, 31", DetermineTheDateByTheDayNumber.getDay(365, false));
		assertEquals("December, 31", DetermineTheDateByTheDayNumber.getDay(366, true));
	}

}
