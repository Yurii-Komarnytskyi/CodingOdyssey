package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PangramChecker {

	public boolean check(String sentence) {
		StringBuilder senteceFiltered = new StringBuilder(removeAllNonLetters(sentence.toLowerCase()));
		List<String> senteceSorted = new ArrayList<>(
				Arrays.stream(removeAllDuplicatedLetters(senteceFiltered.toString()).split("")).toList());
		Collections.sort(senteceSorted);
		return (int) senteceSorted.get(0).charAt(0) == 97
				&& (int) senteceSorted.get(senteceSorted.size() - 1).charAt(0) == 122 && senteceSorted.size() == 26;
	}

	static String removeAllDuplicatedLetters(final String str) {
		return str.replaceAll("(.)(?=.*\\1)", "");
	}

	static String removeAllNonLetters(final String str) {
		return str.replaceAll("[^a-zA-Z]", "");
	}
}