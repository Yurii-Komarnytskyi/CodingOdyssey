package codewars.kyu7;

import java.util.ArrayList;

public class Metro {
	// https://www.codewars.com/kata/5648b12ce68d9daa6b000099/train/java
	public static int countPassengers(ArrayList<int[]> stops) {
		Integer passengersInside = 0;		
		for(int[] stop : stops) {
			passengersInside = ((passengersInside + stop[0]) - stop[1]);			
		}
		return passengersInside;
	}
}