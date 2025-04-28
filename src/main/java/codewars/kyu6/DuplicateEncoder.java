package codewars.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateEncoder {
	// https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java
	static String encode(String word) {
		StringBuilder result = new StringBuilder();
		List<String> wordLettersLowercased = Arrays.stream(word.toLowerCase().split("")).collect(Collectors.toList());
		List<String> duplicatedLetters = new ArrayList<>();
		Set<String> uniqueLetters = new HashSet<>();
		wordLettersLowercased.stream().forEach(letter -> {
			if (!uniqueLetters.add(letter))
				duplicatedLetters.add(letter);
		});
		wordLettersLowercased.stream().forEach(letter -> {
			result.append((duplicatedLetters.contains(letter) ? ")" : "("));
		});
		return result.toString();
	}
}
