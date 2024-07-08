package kyu6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WriteNumberinExpandedForm {
	// https://www.codewars.com/kata/5842df8ccbd22792a4000245
	
	public static String expandedForm(int num) {
		return breakDownNumber(num).stream().map(String::valueOf).collect(Collectors.joining(" + "));
	}

	static private List<Integer> breakDownNumber(int num) {
		List<Integer> result = new ArrayList<>();
		int amountOfDigits = (int) Math.log10(num) + 1;
		while ((amountOfDigits--) > 0) {
			int divisor = (int) Math.pow(10, amountOfDigits);
			int quotient = num / divisor;
			num %= divisor;
			int value = quotient * divisor;
			if (value != 0) {
				result.add(value);
			}
		}
		return result;
	}
}

