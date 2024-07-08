package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReverse {
	// https://www.codewars.com/kata/569d488d61b812a0f7000015/train/java
	
	public static int[] dataReversed(int[] data) {
		List<int[]> result = new ArrayList<>();
		for (int i = data.length; i > 0; i -= 8) {
			result.add(Arrays.copyOfRange(data, i - 8, i));
		}
		return result.stream().flatMapToInt(arr -> Arrays.stream(arr)).toArray();
	}
}