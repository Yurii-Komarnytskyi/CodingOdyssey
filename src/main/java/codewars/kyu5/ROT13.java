package codewars.kyu5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ROT13 {
	// https://www.codewars.com/kata/52223df9e8f98c7aa7000062/train/java
	private static final List<String> LOVER_CASE = Stream.of("abcdefghijklmnopqrstuvwxyz".split("")).toList();
	private static final List<String> UPPER_CASE = LOVER_CASE.stream().map(String::toUpperCase).toList();
	private static final List<String> LOVER_CASE_CIPHER = Stream.of("nopqrstuvwxyzabcdefghijklm".split("")).toList();
	private static final List<String> UPPER_CASE_CIPHER = LOVER_CASE_CIPHER.stream().map(String::toUpperCase).toList();

	public static String rot13(String message) {
		return Stream.of(message.split("")).map(ROT13::rotateLetter).collect(Collectors.joining());
	}

	private static String rotateLetter(String str) {
		char letter = str.charAt(0);
		final int LETTER_INDEX = letter;
		if (!(str.length() == 1 && (LETTER_INDEX >= 97 && LETTER_INDEX  <= 122) 
				|| ((LETTER_INDEX >= 65 && LETTER_INDEX  <= 90))) ) {
			return str;
		} else if (Character.isLowerCase(letter)) {
			return LOVER_CASE_CIPHER.get(LOVER_CASE.indexOf(str));
		} else {
			return UPPER_CASE_CIPHER.get(UPPER_CASE.indexOf(str));
		}
	}
}
