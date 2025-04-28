package codewars.kyu6;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GiveMeADiamond {
	// https://www.codewars.com/kata/5503013e34137eeeaa001648/train/java
	
	private static String STAR = "*";
	private static String BREAK_LINE = "\n";
	private static String SPACE = " ";

	public static String print(int n) {
		if (n < 1 || n % 2 == 0) {
			return null;
		}
		return IntStream.rangeClosed(1, n).mapToObj(i -> {
			return createPartOfDiamond(i, n);
		}).collect(Collectors.joining());
	}

	private static String repeatStringNTimes(int n, String s) {
		return String.join("", Collections.nCopies(n, s));
	}

	private static String createPartOfDiamond(int currentPart, int maxPartWidth) {
		StringBuilder result = new StringBuilder();
		boolean priorToMaxWidth = currentPart < Math.ceil((double) maxPartWidth / 2.00d);
		boolean atMaxWidth = currentPart == Math.ceil((double) maxPartWidth / 2.00d);
		boolean pastToMaxWidth = currentPart > Math.ceil((double) maxPartWidth / 2.00d);
		boolean gotDiamondsTopOrBottom = currentPart == 1 || currentPart == maxPartWidth;

		if (gotDiamondsTopOrBottom) {
			result.append(repeatStringNTimes(maxPartWidth / 2, SPACE)).append(STAR).append(BREAK_LINE).toString();
		} else if (priorToMaxWidth) {
			int amountOfStars = currentPart + (currentPart - 1);
			result.append(repeatStringNTimes((maxPartWidth - amountOfStars) / 2, SPACE))
					.append(repeatStringNTimes(amountOfStars, STAR)).append(BREAK_LINE).toString();
		} else if (atMaxWidth) {
			result.append(repeatStringNTimes(maxPartWidth, STAR)).append(BREAK_LINE).toString();
		} else if (pastToMaxWidth) {
			int amountOfStars = maxPartWidth - (currentPart - ((int) Math.ceil((double) maxPartWidth / 2.00d))) * 2;
			result.append(repeatStringNTimes((maxPartWidth - amountOfStars) / 2, SPACE))
					.append(repeatStringNTimes(amountOfStars, STAR)).append(BREAK_LINE).toString();
		}
		return result.toString();
	}

}