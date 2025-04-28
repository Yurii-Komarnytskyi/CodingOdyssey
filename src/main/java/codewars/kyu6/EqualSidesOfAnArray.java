package codewars.kyu6;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class EqualSidesOfAnArray {
//	https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/java
	
	public static int findEvenIndex(int[] arr) {
		boolean zeroSumOnTheRightSide = Arrays.stream(Arrays.copyOfRange(arr, 1, arr.length)).sum() == 0;
		boolean zeroSumOnTheLefttSide = Arrays.stream(Arrays.copyOfRange(arr, 0, arr.length - 1)).sum() == 0;
		if (zeroSumOnTheRightSide) {
			return 0;
		} else if (zeroSumOnTheLefttSide) {
			return arr.length - 1;
		}
		OptionalInt lowestEvenIndex = IntStream.range(0, arr.length - 1).filter(index -> {
			int leftSideSum = Arrays.stream(Arrays.copyOfRange(arr, 0, index)).sum();
			int rightSideSum = Arrays.stream(Arrays.copyOfRange(arr, index + 1, arr.length)).sum();
			return leftSideSum == rightSideSum;
		}).findFirst();
		return lowestEvenIndex.orElse(-1);
	}

}