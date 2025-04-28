package codewars.kyu5;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scramblies {
	// https://www.codewars.com/kata/55c04b4cc56a697bb0000048
	
	public static boolean scramble(String str1, String targetArg) {
		boolean result = true;
		Set<String> lettersStr1 = Stream.of(str1.split("")).collect(Collectors.toSet());
		Set<String> target = Stream.of(targetArg.split("")).collect(Collectors.toSet());
		
		for(String letter : target ) {
			if (lettersStr1.contains(letter)) {
				if( !(targetArg.indexOf(letter) == targetArg.lastIndexOf(letter) || countLetterInStr(letter, str1) >= countLetterInStr(letter, targetArg))) {
					result = false;
					break;
				} 
			} else {
				result = false;
				break;
			}
		}
		return result;
	}
	
	private static int countLetterInStr(String letter, String targetString) {
		int result = 0;
		int i = targetString.indexOf(letter);
		while(i != -1) {
			i = targetString.indexOf(letter, ++i);
			result++;
		}
		return result;
	}
}
