package codewars.kyu6;

import java.util.Arrays;

public class BackspacesInString {
	// https://www.codewars.com/kata/5727bb0fe81185ae62000ae3/train/java

	private static final String BACKSPACE = "#";

	public String cleanString(String text) {
		long amountOfBackspaces = Arrays.stream(text.split("")).filter(s -> s.equals(BACKSPACE)).count();
		if (text.isEmpty() || text.isBlank()) {
			return "";
		}
		if (amountOfBackspaces == 0) {
			return text;
		}
		StringBuilder result = new StringBuilder(text);
		while (result.indexOf(BACKSPACE) != -1) {
			int currentBackspaceIndex = result.indexOf(BACKSPACE);
			if (currentBackspaceIndex > 0 && (currentBackspaceIndex + 1) <= text.length() - 1) {
				result.delete(currentBackspaceIndex - 1, currentBackspaceIndex + 1);

			} else {
				result.deleteCharAt(currentBackspaceIndex);
			}
		}
		return result.toString();
	}

}