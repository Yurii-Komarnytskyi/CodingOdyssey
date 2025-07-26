package codewars.kyu6;

import java.time.LocalDate;
import java.time.Month;

public class DetermineTheDateByTheDayNumber {
	// https://www.codewars.com/kata/602afedfd4a64d0008eb4e6e/train/java
	
	public static String getDay(int day, boolean isLeap) {
		LocalDate year = LocalDate.ofYearDay((isLeap)? 2024 : 2025 , day);
		return  formatMonthName(year.getMonth()) +  ", " + year.getDayOfMonth();
	}
	
	private static String formatMonthName(Month month) {
		return month.toString().charAt(0) + month.toString().substring(1).toLowerCase();
	}
}
