package codewars.kyu6;

import java.util.Arrays;

public class ConsonantValue {
	// https://www.codewars.com/kata/59c633e7dcc4053512000073/train/java

	public static int solve(final String word) {
		String[] consonantsSplitted = word.replaceAll("[aieoue]", ";").split(";");
		return Arrays.stream(consonantsSplitted).filter(s -> !s.isBlank()).mapToInt(ConsonantValue::countLetters).max()
				.orElse(0);
	}

	private static int countLetters(String str) {
		return Arrays.stream(str.split("")).mapToInt(s -> (int) s.charAt(0) - 96).sum();
	}
}