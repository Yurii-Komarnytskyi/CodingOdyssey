package kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Keypad {
	// https://www.codewars.com/kata/54a2e93b22d236498400134b/train/java

	private static List<String> buttons = List.of("1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9",
			"*", " 0", "#");

	public static int presses(String phrase) {
		return Arrays.stream(phrase.split("")).mapToInt(character -> Keypad.convertToMultiTap(character.toUpperCase()))
				.sum();
	}

	private static int convertToMultiTap(String character) {
		Optional<String> button = buttons.stream().filter(str -> str.contains(character)).findFirst();
		return (button.isPresent()) ? button.get().indexOf(character) + 1 : 0;
	}
}