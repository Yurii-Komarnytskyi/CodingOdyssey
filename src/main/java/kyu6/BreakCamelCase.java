package kyu6;

import java.util.stream.Stream;

public class BreakCamelCase  {
	// https://www.codewars.com/kata/5208f99aee097e6552000148/solutions/java
	public static String camelCase(String input) {
		if (input.length() == 0) {
			return "";
		}
		return Stream.of(input.split("")).reduce("",
				(a, ch) -> (Character.isUpperCase(ch.charAt(0)) ? a.concat(" ").concat(ch) : a.concat(ch)));
	}
}