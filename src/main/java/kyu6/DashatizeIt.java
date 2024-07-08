package kyu6;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DashatizeIt {
	// https://www.codewars.com/kata/58223370aef9fc03fd000071/train/java
	
	private static final String DASH_SIGN = "-";
	private static final String DOUBLE_DASH_SIGN = "--";

	public static String dashatize(int num) {
		String numToString = String.valueOf(num);
		String rawResult = Stream.of(numToString.split("")).filter(str -> Character.isDigit(str.charAt(0)))
				.map(str -> (Integer.valueOf(str) % 2 == 0) ? str
						: (new StringBuilder(str)).insert(0, DASH_SIGN).append(DASH_SIGN))
				.collect(Collectors.joining());
		return trimDashes(rawResult).replaceAll(DOUBLE_DASH_SIGN, DASH_SIGN);

	}

	private static String trimDashes(String str) {
		StringBuilder result = new StringBuilder(str);
		if (str.startsWith(DASH_SIGN)) {
			result.delete(0, 1);
		}
		if (str.endsWith(DASH_SIGN)) {
			result.delete(result.length() - 1, result.length());
		}
		return result.toString();
	}
}