package kyu5;

import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeightSort {
	// https://www.codewars.com/kata/55c6126177c9441a570000cc
	
	private static ToIntFunction<String> measureNumberWeightFunction = (str) -> Stream.of(str.split("")).mapToInt(Integer::valueOf).sum();
	private static int compareAlphabetically(String strA, String strB) {
		if (strA.isEmpty() || strA.isBlank()) {
			return -1;
		} else if (strB.isEmpty() || strB.isBlank()) {
			return 1;
		}
		
		for(int i = 0; i < Math.max(strA.length()-1, strB.length()-1);) {
			if (String.valueOf(strA.charAt(i)).compareTo(String.valueOf(strB.charAt(i))) != 0) {
				return String.valueOf(strA.charAt(i)).compareTo(String.valueOf(strB.charAt(i)));
			} else {
				return compareAlphabetically(strA.substring(i + 1), strB.substring(i + 1));
			}
		}
		return 0;
	}
	public static String orderWeight(String str) {
		return Stream.of(str.replaceAll("(?<=\\d)\\D+|\\D+(?=\\d)", " ").split(" "))
				.sorted((strA, strB) -> {
					Integer aWeight = measureNumberWeightFunction.applyAsInt(strA);
					Integer bWeight = measureNumberWeightFunction.applyAsInt(strB);
					if (aWeight.equals(bWeight)) {
						int alphabeticalOrdering = String.valueOf(strA.charAt(0)).compareTo(String.valueOf(strB.charAt(0))); 
						return (alphabeticalOrdering == 0)? compareAlphabetically(strA, strB) : alphabeticalOrdering;
					}
					return aWeight.compareTo(bWeight);
				})
				.collect(Collectors.joining(" "));
	}
}
