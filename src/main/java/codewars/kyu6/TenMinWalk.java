package codewars.kyu6;

import java.util.function.Function;

public class TenMinWalk {
//	https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java

	public static boolean isValid(char[] walk) {
		if (walk.length != 10) {
			return false;
		}
		int startingPoint = 0;
		int northSouthAxis = culculateNorthSouthAxis.apply(walk);
		int westEastAxis = culculateWestEastAxis.apply(walk);
		return northSouthAxis == startingPoint && westEastAxis == startingPoint;
	}

	static Function<char[], Integer> culculateNorthSouthAxis = (moves) -> {
		int northSouthAxis = 0;
		for (char direction : moves) {
			if (direction == 'n') {
				northSouthAxis++;
			} else if (direction == 's') {
				northSouthAxis--;
			}
		}
		return northSouthAxis;
	};

	static Function<char[], Integer> culculateWestEastAxis = (moves) -> {
		int westEastAxis = 0;
		for (char direction : moves) {
			if (direction == 'w') {
				westEastAxis++;
			} else if (direction == 'e') {
				westEastAxis--;
			}
		}
		return westEastAxis;
	};

}
