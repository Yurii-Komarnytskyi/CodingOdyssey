package codewars.kyu6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class EverybodyHatesMondays {

	private static final int WORKING_AGE = 22;
	private static final int RETIREMENT_AGE = 78;

	private static Predicate<LocalDate> dayOfWeekIsMonday = (date) -> date.getDayOfWeek().equals(DayOfWeek.MONDAY);
	
	static long count(final LocalDate birthday, final LocalDate today) {
		int ageOfWorker = Period.between(birthday, today).getYears();
		long mondayCount = 0L;
		if (ageOfWorker >= WORKING_AGE) {
			LocalDate startedWorking = birthday.plusYears(WORKING_AGE);
			LocalDate stoppedWorking = (ageOfWorker > RETIREMENT_AGE)? birthday.plusYears(RETIREMENT_AGE) : today;
			mondayCount = startedWorking.datesUntil(stoppedWorking.plusDays(1))
					.filter(date -> dayOfWeekIsMonday.test(date))
					.count();
			if(ageOfWorker >= RETIREMENT_AGE && dayOfWeekIsMonday.test(stoppedWorking)) {
				--mondayCount;
			}
			
		} 
		return mondayCount;
	}

}
