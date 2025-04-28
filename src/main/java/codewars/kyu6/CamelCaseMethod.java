package codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseMethod {
	// https://www.codewars.com/kata/587731fda577b3d1b0001196/train/java
	
	public static String camelCase(String str) {
		return Arrays.stream(str.split(" ")).filter(s -> s != "").map(CamelCaseMethod::capitalizeFisrtLetter)
				.collect(Collectors.joining());
	}

	private static String capitalizeFisrtLetter(String s) {
		StringBuilder result = new StringBuilder(s);
		result.setCharAt(0, Character.toUpperCase(s.charAt(0)));
		return result.toString();
	};

}