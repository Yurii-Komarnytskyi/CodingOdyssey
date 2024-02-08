package kyu7;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

class Metro {
	// https://www.codewars.com/kata/5648b12ce68d9daa6b000099/train/java
	public static int countPassengers(ArrayList<int[]> stops) {
		Integer passengersInside = 0;		
		for(int[] stop : stops) {
			passengersInside = ((passengersInside + stop[0]) - stop[1]);			
		}
		return passengersInside;
	}
}

public class KyuSeven {

	@Test
	public void test1() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 10, 0 });
		list.add(new int[] { 3, 5 });
		list.add(new int[] { 2, 5 });

		assertEquals(5, Metro.countPassengers(list));
	}

	public static void main(String[] args) {
		KyuSeven kyuSeven = new KyuSeven();
		kyuSeven.test1();

	}

}
