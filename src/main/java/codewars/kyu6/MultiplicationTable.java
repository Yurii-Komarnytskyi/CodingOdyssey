package codewars.kyu6;

import java.util.stream.IntStream;

public class MultiplicationTable {
	// https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08/train/java
	
	public static int[][] multiplicationTable(int n) {
		int[][] result = new int[n][n];
		IntStream.range(0, n).forEach(firstLevelIndex -> {
			int firstLevelIncrement = firstLevelIndex + 1;
			IntStream.range(0, n).forEach(secondLevelIndex -> {
				int secondLevelIncrement = (secondLevelIndex + 1) * firstLevelIncrement;
				result[firstLevelIndex][secondLevelIndex] += secondLevelIncrement;
			});
		});

		return result;
	}
}
