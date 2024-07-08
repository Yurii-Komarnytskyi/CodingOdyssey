package kyu6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LongestConsec {
//	https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/java
	
	public static String longestConsec(String[] arr, int arrPortion) {
		if (arr.length == 0 || arrPortion > arr.length || arrPortion <= 0) {
			return "";
		}
		Map<String, Integer> coupledWords = new LinkedHashMap<>();
		IntStream.rangeClosed(0, arr.length - arrPortion).forEach(from -> {
			String concatinatedChunk = concatStringsOfArray(from, from + arrPortion, arr);
			coupledWords.computeIfAbsent(concatinatedChunk, (length) -> concatinatedChunk.length());
		});
		Optional<Integer> greatestVal = coupledWords.values().stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(v -> v)));
		return coupledWords.keySet().stream().filter(k -> k.length() == greatestVal.get()).findFirst().get();
	}

	static String concatStringsOfArray(int from, int to, String[] arr) {
		return Stream.of(Arrays.copyOfRange(arr, from, to)).collect(Collectors.joining());
	}
}