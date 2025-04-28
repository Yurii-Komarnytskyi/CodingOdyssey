package codewars.kyu5;

import java.util.Arrays;

public class PigLatin {
	// https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/java
	
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	
	public static String pigIt(String str) {
		String resuslt = Arrays.stream(str.split(" ")).reduce("", (String res, String element) -> {
			STRING_BUILDER.delete(0, STRING_BUILDER.length());
			
			if (Character.isLetter(element.charAt(0))) {
				STRING_BUILDER
				.append(element.substring(1))
				.append(element.charAt(0))
				.append("ay ");
				return res.concat(STRING_BUILDER.toString());
			} else {
				return res.concat(element);
			}
		});

		return resuslt.trim();
    }
}