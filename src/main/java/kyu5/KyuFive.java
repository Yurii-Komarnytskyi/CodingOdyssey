package kyu5;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

class SimpleEncryptionQwerty {
	// https://www.codewars.com/SimpleEncryptionQwerty/57f14afa5f2f226d7d0000f4/train/java

	private static Map<Integer, String> qwertyRows = Stream
			.of(new AbstractMap.SimpleEntry<>(0, "qwertyuiop"), new AbstractMap.SimpleEntry<>(1, "asdfghjkl"),
					new AbstractMap.SimpleEntry<>(2, "zxcvbnm,."))
			.collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

	private static Map<Integer, String> qwertyRowsShiftOn = Stream
			.of(new AbstractMap.SimpleEntry<>(0, "QWERTYUIOP"), new AbstractMap.SimpleEntry<>(1, "ASDFGHJKL"),
					new AbstractMap.SimpleEntry<>(2, "ZXCVBNM<>"))
			.collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

	public static String encrypt(String text, int key) {
		if (key == 0) {
			return text;
		}

		StringBuilder result = new StringBuilder();
		List<Integer> encryptionKeys = decryptRowKeys(key);
		IntStream.rangeClosed(0, text.length() - 1).forEach(i -> {
			String currentLetter = String.valueOf(text.charAt(i));
			if (currentLetter.isBlank()) {
				result.append(currentLetter);
			} else {
				Entry<Integer, String> rowEntry = findApropriateEntry(currentLetter);
				String row = rowEntry.getValue();
				char encryptedLetter = row.charAt(pickNextEncryptedIndex(row.indexOf(currentLetter),
						encryptionKeys.get(rowEntry.getKey()), row.length() - 1));
				result.append(encryptedLetter);
			}
		});
		return result.toString();
	}

	public static String decrypt(String encryptedText, int key) {
		if (key == 0) {
			return encryptedText;
		}

		StringBuilder result = new StringBuilder();
		List<Integer> encryptionKeys = decryptRowKeys(key);
		IntStream.rangeClosed(0, encryptedText.length() - 1).forEach(i -> {
			String currentLetter = String.valueOf(encryptedText.charAt(i));
			if (currentLetter.isBlank()) {
				result.append(currentLetter);
			} else {
				Entry<Integer, String> rowEntry = findApropriateEntry(currentLetter);
				String row = rowEntry.getValue();
				char encryptedLetter = row.charAt(pickNextDecryptedIndex(row.indexOf(currentLetter),
						encryptionKeys.get(rowEntry.getKey()), row.length() - 1));
				result.append(encryptedLetter);
			}
		});
		return result.toString();
	}

	private static int pickNextEncryptedIndex(int qwertyIndex, int shiftToRight, int rowLength) {
		boolean overlap = (qwertyIndex + shiftToRight) > rowLength;
		if (overlap) {
			return ((qwertyIndex + shiftToRight) - rowLength) - 1;
		}
		return qwertyIndex + shiftToRight;
	}
	
	private static int pickNextDecryptedIndex(int qwertyIndex, int shiftToLeft, int rowLength) {
		boolean overlap = (qwertyIndex - shiftToLeft) < 0;
		if (overlap) {
			return rowLength - shiftToLeft + qwertyIndex + 1;
		}
		return Math.abs(qwertyIndex - shiftToLeft);
	}

	private static Entry<Integer, String> findApropriateEntry(String letter) {
		if (qwertyRows.values().stream().anyMatch(values -> values.contains(letter))) {
			return qwertyRows.entrySet().stream().filter(entry -> entry.getValue().contains(letter)).findFirst().get();
		} else {
			return qwertyRowsShiftOn.entrySet().stream().filter(entry -> entry.getValue().contains(letter)).findFirst()
					.orElse(new AbstractMap.SimpleEntry<>(0, String.join("", Collections.nCopies(10, letter))));
		}
	}

	private static List<Integer> decryptRowKeys(int key) {
		return Arrays.stream(String.valueOf(key).split("")).mapToInt(Integer::valueOf).boxed()
				.collect(Collectors.toList());
	}

}

class SumOfK { // NEEDS SOME POLISH
	
	// https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa/train/java

	private static List<int[]> allPossibleTownsCombinations = new ArrayList<>();
	
    public static Integer chooseBestSum(int maxDistanceCovered, int townsToVisit, List<Integer> distancesBetweenTowns) {
        if(distancesBetweenTowns.size() < townsToVisit) {
        	return null;
        }
        combinations(distancesBetweenTowns, townsToVisit, 0, new int[townsToVisit]);
    	OptionalInt result =  allPossibleTownsCombinations.stream()
    			.mapToInt(townCombinations -> Arrays.stream(townCombinations).sum())  			
    			.filter(distanceToCover -> distanceToCover <= maxDistanceCovered)
    			.max();
    	return (result.isPresent())? result.getAsInt() : null;
    }
        
    static void combinations(List<Integer> distancesBetweenTowns, int townsToVisit, int startPosition, int[] result) {
		if (townsToVisit == 0) {
			String resultToString = Arrays.toString(result);
			allPossibleTownsCombinations
					.add(Arrays.stream(resultToString.substring(1, resultToString.length() - 1).split(", "))
							.mapToInt(Integer::valueOf).toArray());
			return;
		}
		for (int i = startPosition; i <= distancesBetweenTowns.size() - townsToVisit; i++) {
			result[result.length - townsToVisit] = distancesBetweenTowns.get(i);
			combinations(distancesBetweenTowns, townsToVisit - 1, i + 1, result);
		}
	}
}

public class KyuFive {
	

	public static void main(String[] args) {

	}

}
