package codewars.kyu6;

import java.util.HashSet;
import java.util.Set;

public class CountingDuplicates {
	// https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/java

	public static int duplicateCount(String text) {
		Set<String> uniqueLetters = new HashSet<>();
		Set<String> duplicateLetters = new HashSet<>();
		for (String letter : text.toLowerCase().split("")) {
			if (!uniqueLetters.add(letter)) {
				duplicateLetters.add(letter);
			}
		}
		return duplicateLetters.size();
	}
}