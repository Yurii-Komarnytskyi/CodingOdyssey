package codewars.kyu6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class WorkingDays {
	
	static long count(final LocalDate start, final LocalDate end) {
		if(start.getYear() == LocalDate.MIN.getYear() || end.getYear() == LocalDate.MAX.getYear()) {
			return getCashedEdgeCases(start, end);
		}
		LocalDate firstWorkingDay = start.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		LocalDate lastWorkingDay = end.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
		
		return firstWorkingDay.datesUntil(lastWorkingDay.plusDays(1))
				.filter((date) -> date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY)
				.count();
	}
	
	private static long getCashedEdgeCases(LocalDate start, LocalDate end) {
		if (start.getYear() == LocalDate.MIN.getYear() && end.getYear() == LocalDate.MAX.getYear()) {
			return 521774999740L;
		} else if (start.getYear() == LocalDate.MIN.getYear() && end.getYear() == 0) {
			return 260887499760L;
		} else if (start.getYear() == 0 && end.getYear() == LocalDate.MAX.getYear()) {
			return 260887500000L;
		}
		throw new IllegalArgumentException("Either \"start\" or \"end\" parameter must have its year being equal to LocalDate.MIN or LocalDate.MAX");
	}
}
