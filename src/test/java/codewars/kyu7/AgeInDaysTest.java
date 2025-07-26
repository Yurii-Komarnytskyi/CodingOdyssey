package codewars.kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AgeInDaysTest {

	@Test
	void ageInDaysShouldReturnYouAre2DaysOldWhenYourBirthdayIsTwoDaysAgo() {
		LocalDate birthday = LocalDate.now().minusDays(2);
		assertEquals("You are 2 days old",
				AgeInDays.ageInDays(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
	}

	@Test
	void ageInDaysShouldReturnCorrectNumberOfDaysWhenYourBirthdayIsOneYearAgo() {
		LocalDate birthday = LocalDate.now().minusYears(1);
		if (LocalDate.now().isLeapYear()) {
			assertEquals("You are 366 days old",
					AgeInDays.ageInDays(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
		} else {
			assertEquals("You are 365 days old",
					AgeInDays.ageInDays(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
		}
	}

}
