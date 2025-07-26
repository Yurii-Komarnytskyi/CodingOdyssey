package codewars.kyu6;

public class WhatCenturyIsIt {
	// https://www.codewars.com/kata/52fb87703c1351ebd200081f/train/java

	public static String whatCentury(int year) {
		return formatCenturySuffix((year - 1) / 100 + 1);
	}

	private static String formatCenturySuffix(int century) {
		String suffix = "";
		if (century / 10 == 1) {
			suffix = "th";
		} else {
			suffix = switch (century % 10) {
				case 1 -> "st";
				case 2 -> "nd";
				case 3 -> "rd";
				default -> "th";
			};
		}

		return century + suffix;

	}

}
