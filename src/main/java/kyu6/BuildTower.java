package kyu6;

import java.util.Collections;
import java.util.stream.IntStream;

public class BuildTower {
//	https://www.codewars.com/kata/576757b1df89ecf5bd00073b/train/java
	
	static final String STAR = "*";

	public static String[] towerBuilder(int nFloors) {
		if (nFloors == 0) {
			return new String[0];
		}
		String[] result = new String[nFloors];
		result[nFloors - 1] = repeatStringNTimes(nFloors * 2 - 1, STAR);
		int greatestFloorLength = result[nFloors - 1].length() - 1;
		result[0] = surroundStarsWithPadding(0, greatestFloorLength);
		IntStream.range(1, nFloors - 1).forEach(floor -> {
			String repeatedAccordingToFloor = surroundStarsWithPadding(floor, greatestFloorLength);
			result[floor] = repeatedAccordingToFloor;
		});
		return result;
	}

	static String surroundStarsWithPadding(int index, int greatestFloorLength) {
		StringBuilder stars = new StringBuilder(repeatStringNTimes((++index) * 2 - 1, STAR));
		String padding = repeatStringNTimes((greatestFloorLength + 1 - stars.length()) / 2, " ");
		stars.insert(0, padding);
		stars.append(padding);
		return stars.toString();
	}

	static String repeatStringNTimes(int n, String s) {
		return String.join("", Collections.nCopies(n, s));
	}
}