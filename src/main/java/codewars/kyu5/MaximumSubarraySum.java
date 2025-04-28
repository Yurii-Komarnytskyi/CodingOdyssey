package codewars.kyu5;

import java.util.Arrays;

public class MaximumSubarraySum {
	// https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/train/java
	
	public static int sequence(int[] arr) {
		boolean gotAllNegativeNumbersOrAnEmptyArray = Arrays.stream(arr).allMatch(n -> n < 0) || arr.length == 0;
		if (gotAllNegativeNumbersOrAnEmptyArray) {
			return 0;
		}
		int currentElement = 0;
		int maxElement = 0;
		for (int n : arr) {
			currentElement += Math.max(0, n + currentElement);
			maxElement = Math.max(maxElement, currentElement);
		}
		return maxElement;
	}
}