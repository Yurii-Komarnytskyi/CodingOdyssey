package kyu6;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharactersInYourString {
	// https://www.codewars.com/kata/52efefcbcdf57161d4000091/train/java
	
	public static Map<Character, Integer> count(String str) {
		if (str.length() == 0) {
			return new LinkedHashMap<>();
		}
		Map<String, Long> map = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Integer> result = new LinkedHashMap<>();
		map.entrySet().stream().forEach((entry) -> {
			result.put(entry.getKey().charAt(0), entry.getValue().intValue());
		});
		return result;
	}
}