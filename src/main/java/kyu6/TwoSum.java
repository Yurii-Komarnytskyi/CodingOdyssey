package kyu6;

import java.util.stream.IntStream;

public class TwoSum {
	// https://www.codewars.com/kata/52c31f8e6605bcc646000082/train/java
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		IntStream.rangeClosed(0, numbers.length - 1).forEach(i -> {
			IntStream.rangeClosed(i + 1, numbers.length - 1).forEach(j -> {
				if (numbers[i] + numbers[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			});
		});

		return result;
	}
}