package codewars.kyu7;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class UnluckyDays {
	// https://www.codewars.com/kata/56eb0be52caf798c630013c0/train/java
	
	private static final int UNLUCKY_DAY = 13;
	
	public static int unluckyDays(int year) {
		return (int) Arrays.stream(Month.values())
				.filter(month -> LocalDate.of(year, month, UNLUCKY_DAY).getDayOfWeek().equals(DayOfWeek.FRIDAY))
				.count();
	}
}
