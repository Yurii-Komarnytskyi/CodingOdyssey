package codewars.kyu6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterWithLongestConsecutiveRepetition {
	// https://www.codewars.com/kata/586d6cefbcc21eed7a001155/train/java

	public static Object[] longestRepetition(String str) {
		Object[] result = { "", 0 };
		if (str.isEmpty()) {
			return result;
		}
		Matcher matcher = Pattern.compile("(.)\\1*").matcher(str);
		while (matcher.find()) {
			if (matcher.group().length() > (int) result[1]) {
				result[0] = String.valueOf(matcher.group().charAt(0));
				result[1] = matcher.group().length();
			}
		}
		return result;
	}
}