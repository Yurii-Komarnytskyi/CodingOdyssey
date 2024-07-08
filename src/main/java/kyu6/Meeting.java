package kyu6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Meeting {
	// https://www.codewars.com/kata/59df2f8f08c6cec835000012/train/java
	
	private static final String DELIMITER = ";";
	private static final String NAMES_DELIMITER = ":";

	public static String meeting(String friendsInvited) {
		return Arrays.stream(friendsInvited.split(DELIMITER)).map(guest -> {
			String[] personInfo = guest.split(NAMES_DELIMITER);
			return new Guest(personInfo[0], personInfo[1]);
		}).sorted(Guest::compareTo).map(Guest::toString).collect(Collectors.joining());
	}

	static class Guest implements Comparable<Guest> {
		private String name;
		private String surname;

		public String getName() {
			return name.toLowerCase();
		}

		public String getSurname() {
			return surname.toLowerCase();
		}

		Guest(String name, String surname) {
			this.name = name;
			this.surname = surname;
		}

		@Override
		public String toString() {
			return String.format("(%s, %s)", surname, name).toUpperCase();
		}

		@Override
		public int compareTo(Guest guest) {
			Comparator<Guest> compareByNames = Comparator.comparing(Guest::getName);
			Comparator<Guest> compareBySurnames = Comparator.comparing(Guest::getSurname);
			return (Objects.compare(this, guest, compareBySurnames) == 0) ? Objects.compare(this, guest, compareByNames)
					: Objects.compare(this, guest, compareBySurnames);
		}
	}
}