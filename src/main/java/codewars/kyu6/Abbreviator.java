package codewars.kyu6;

import java.util.Arrays;

public class Abbreviator {
	// https://www.codewars.com/kata/5375f921003bf62192000746/train/java

	static public String abbreviate(String string) {
		String[] words = string.split("[^a-zA-Z]+");
		String[] separators = string.split("[a-zA-Z]+");
		StringBuilder result = new StringBuilder();
		System.out.println(Arrays.toString(separators));

		int i = 1;
		for (String word : words) {
			result.append(abbreviateSingleWord(word));
			if (i < separators.length) {
				result.append(separators[i++]);
			}
		}
		return result.toString();
	}

	private static String abbreviateSingleWord(String word) {
		if (word.length() < 4) {
			return word;
		}
		return (new StringBuilder(word)).delete(1, word.length() - 1).insert(1, word.length() - 2).toString();
	}

}
