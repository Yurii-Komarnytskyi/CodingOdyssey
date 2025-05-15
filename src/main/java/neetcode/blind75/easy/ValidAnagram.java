package neetcode.blind75.easy;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ValidAnagram {
	// https://neetcode.io/problems/is-anagram
	private static UnaryOperator<String> sortString = str -> 
		 str.chars()
         .mapToObj(ch -> String.valueOf((char) ch))
         .sorted()
         .collect(Collectors.joining());
	
	public boolean isAnagram(String s, String t) {
		return sortString.apply(s).equals(sortString.apply(t));
    }
}
