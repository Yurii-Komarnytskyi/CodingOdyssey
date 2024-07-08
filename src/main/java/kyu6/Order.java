package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Order {
	// https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java

	public static String order(String words) {

		if (words.length() == 0) {
			return words;
		}
		Comparator<String> stringsWithAscendingNumbersFirst = (a, b) -> {
			return (parseDigitFromString(a) < parseDigitFromString(b)) ? -1 : 0;
		};
		StringBuilder result = new StringBuilder();
		List<String> wordsOrdered = new ArrayList<>(
				Arrays.stream(words.split(" ")).sorted(stringsWithAscendingNumbersFirst).toList());
		wordsOrdered.stream().forEach(word -> {
			result.append(word.concat(" "));
		});
		return result.toString().trim();
	}

	static int parseDigitFromString(String str) {
		int result = 0;
		for (int i = 1; i < 10; i++) {
			if (str.contains(String.valueOf(i))) {
				result = i;
			}
		}
		return result;
	}
}
