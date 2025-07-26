package codewars.kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class WorkingDaysTest {

	@Test
	void countTest() {
		assertEquals(20, WorkingDays.count(LocalDate.of(2017, 6, 1), LocalDate.of(2017, 6, 1)));
		assertEquals(60, WorkingDays.count(LocalDate.of(2012, 2, 1), LocalDate.of(2012, 4, 1)));
		assertEquals(280, WorkingDays.count(LocalDate.of(2078, 1, 1), LocalDate.of(2079, 1, 1)));
		assertEquals(7805, WorkingDays.count(LocalDate.of(-1000, 6, 1), LocalDate.of(-970, 4, 1)));
	}

}
