package codewars.kyu6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestScoringWord {
//	https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/java
	
	public static String high(String s) {
		return Stream.of(s.split(" ")).sorted((a, b) -> (getTotalLettersScore(a) > getTotalLettersScore(b)) ? -1 : 1)
				.findFirst().orElse("");
	}

	public static String anotherHighSolution(String s) {
		Map<Integer, List<String>> wordsScore = Stream.of(s.split(" "))
				.collect(Collectors.groupingBy(HighestScoringWord::getTotalLettersScore));
		return wordsScore.get(wordsScore.keySet().stream().mapToInt(Integer::intValue).max().orElse(0)).get(0);

	}

	private static int getTotalLettersScore(String word) {
		return (word.length() == 0) ? 0
				: Stream.of(word.split("")).mapToInt(letter -> (int) letter.charAt(0) - 96).sum();
	}
}