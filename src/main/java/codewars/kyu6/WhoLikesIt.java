package codewars.kyu6;

import java.util.function.Function;

public class WhoLikesIt {
	// https://www.codewars.com/kata/5266876b8f4bf2da9b000362/train/java

	public static String whoLikesIt(String... names) {
		return getWhoLikesItConsideringQty.apply(names);
	}

	static Function<String[], String> getWhoLikesItConsideringQty = (names) -> {
		StringBuilder whoLikesIt = new StringBuilder();
		if (names.length <= 1) {
			String singlePersonOrNoOne = (names.length == 1) ? names[0] : "no one";
			whoLikesIt = new StringBuilder(singlePersonOrNoOne.concat(" likes this"));
		} else if (names.length == 2) {
			whoLikesIt = new StringBuilder(String.format("%s and %s like this", names[0], names[1]));
		} else if (names.length == 3) {
			whoLikesIt = new StringBuilder(String.format("%s, %s and %s like this", names[0], names[1], names[2]));
		} else if (names.length > 3) {
			whoLikesIt = new StringBuilder(
					String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2));
		}
		return whoLikesIt.toString();
	};
}
