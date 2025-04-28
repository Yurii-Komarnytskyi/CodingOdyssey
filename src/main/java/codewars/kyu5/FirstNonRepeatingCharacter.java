package codewars.kyu5;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatingCharacter {
	// https://www.codewars.com/kata/52bc74d4ac05d0945d00054e/train/java
	
	public static String firstNonRepeatingLetter(String str){
		final String EMPTY_STRING = "";
		if(Objects.isNull(str) || str.isEmpty() ) {
			return EMPTY_STRING;
		}
		
		Optional<Integer> first = new LinkedHashMap<>(Stream.of(str.toLowerCase().split(EMPTY_STRING))
				.collect(Collectors.groupingBy(String::toString, Collectors.counting()))).entrySet().stream()
				.filter(entry -> entry.getValue() == 1L)
				.map(entry -> (str.indexOf(entry.getKey()) == -1)  
						? str.indexOf(entry.getKey().toUpperCase())
						: str.indexOf(entry.getKey()))
				.sorted().findFirst();

		return (first.isPresent())? Character.toString(str.charAt(first.get())) : EMPTY_STRING;
	  }
}
