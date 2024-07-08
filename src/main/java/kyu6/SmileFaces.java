package kyu6;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SmileFaces {
	// https://www.codewars.com/kata/583203e6eb35d7980400002a/train/java
	static Predicate<String> gotSmilyFace = (s) -> {
		List<String> validFaces = List.of(":)", ";)", ":D", ";D", ":-)", ":~)", ";-)", ";~)", ":-D", ":~D", ";-D",
				";~D");
		return validFaces.contains(s);
	};

	public static int countSmileys(List<String> arr) {
		return arr.stream().filter(gotSmilyFace).collect(Collectors.toList()).size();
	}
}