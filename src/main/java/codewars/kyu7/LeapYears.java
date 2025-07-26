package codewars.kyu7;

import java.time.Year;

public class LeapYears {
	// https://www.codewars.com/kata/526c7363236867513f0005ca/train/java
	
	public static boolean isLeapYear(int year) {
	    return Year.isLeap(year);
	  }

}
