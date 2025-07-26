package codewars.kyu7;

import java.time.LocalDate;

public class AgeInDays {
	// https://www.codewars.com/kata/5803753aab6c2099e600000e/train/java

	public static String ageInDays(int year, int month, int day) {
		long daysLived = (LocalDate.of(year, month, day))
				.datesUntil(LocalDate.now())
				.count();
		return "You are %d days old".formatted(daysLived);
	}
}
