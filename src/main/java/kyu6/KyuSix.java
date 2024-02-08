package kyu6;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

class TenMinWalk {
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

class Solution {
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

class Kata {
	// https://www.codewars.com/kata/523f5d21c841566fde000009/train/java
	public static int[] arrayDiff(int[] a, int[] b) {
		List<Integer> aAsList = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> bAsList = Arrays.stream(b).boxed().collect(Collectors.toList());
		aAsList.removeAll(bAsList);
		return aAsList.stream().mapToInt(Integer::intValue).toArray();
	}

}

class CountingDuplicates {
	// https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/java

	public static int duplicateCount(String text) {
		Set<String> uniqueLetters = new HashSet<>();
		Set<String> duplicateLetters = new HashSet<>();
		for (String letter : text.toLowerCase().split("")) {
			if (!uniqueLetters.add(letter)) {
				duplicateLetters.add(letter);
			}
		}
		return duplicateLetters.size();
	}
}

class DuplicateEncoder {
	// https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java
	static String encode(String word) {
		StringBuilder result = new StringBuilder();
		List<String> wordLettersLowercased = Arrays.stream(word.toLowerCase().split("")).collect(Collectors.toList());
		List<String> duplicatedLetters = new ArrayList<>();
		Set<String> uniqueLetters = new HashSet<>();
		wordLettersLowercased.stream().forEach(letter -> {
			if (!uniqueLetters.add(letter))
				duplicatedLetters.add(letter);
		});
		wordLettersLowercased.stream().forEach(letter -> {
			result.append((duplicatedLetters.contains(letter) ? ")" : "("));
		});
		return result.toString();
	}
}

class Persist {
	// https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/java

	public static int persistence(long n) {
		int multiplicativePersistence = 0;
		long nCopy = n;
		while (nCopy > 9) {
			multiplicativePersistence++;
			nCopy = String.valueOf(nCopy).chars().map(Character::getNumericValue).reduce(1, (a, b) -> a * b);
		}
		return multiplicativePersistence;
	}
}

class Order {
	// https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java

	public static String order(String words) {

//		if(words.length() == 0) {
//			return words;
//		}
//		String[] wordsSplit = words.split(" ");
//		StringBuilder result = new StringBuilder();
//		List<String> wordsOrdered = new ArrayList<>(Arrays.stream(wordsSplit).toList());
//		for(int i = 1; i <= wordsSplit.length; i++) {
//			for(String word : wordsSplit) {
//				if(word.contains(String.valueOf(i))) {
//					wordsOrdered.set(i -1, word.concat(" "));
//				}
//			}
//		}
//		wordsOrdered.stream().forEach(word -> {result.append(word);});
//		return result.toString().trim();

		if (words.length() == 0) {
			return words;
		}
		Comparator<String> stringsWithAscendingNumbersFirst = (a, b) -> {
			return (parseDigitFromString(a) < parseDigitFromString(b)) ? -1 : 0;
		};
		StringBuilder result = new StringBuilder();
		List<String> wordsOrdered = new ArrayList<>(
				Arrays.stream(words.split(" ")).sorted(stringsWithAscendingNumbersFirst).toList());
		wordsOrdered.stream().forEach(word -> {
			result.append(word.concat(" "));
		});
		return result.toString().trim();
	}

	static int parseDigitFromString(String str) {
		int result = 0;
		for (int i = 1; i < 10; i++) {
			if (str.contains(String.valueOf(i))) {
				result = i;
			}
		}
		return result;
	}
}

class PangramChecker {

	public boolean check(String sentence) {
		StringBuilder senteceFiltered = new StringBuilder(removeAllNonLetters(sentence.toLowerCase()));
		List<String> senteceSorted = new ArrayList<>(
				Arrays.stream(removeAllDuplicatedLetters(senteceFiltered.toString()).split("")).toList());
		Collections.sort(senteceSorted);
		return (int) senteceSorted.get(0).charAt(0) == 97
				&& (int) senteceSorted.get(senteceSorted.size() - 1).charAt(0) == 122 && senteceSorted.size() == 26;
	}

	static String removeAllDuplicatedLetters(final String str) {
		return str.replaceAll("(.)(?=.*\\1)", "");
	}

	static String removeAllNonLetters(final String str) {
		return str.replaceAll("[^a-zA-Z]", "");
	}
}

class Kata1 {
//	https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/java
	public static int findEvenIndex(int[] arr) {
		boolean zeroSumOnTheRightSide = Arrays.stream(Arrays.copyOfRange(arr, 1, arr.length)).sum() == 0;
		boolean zeroSumOnTheLefttSide = Arrays.stream(Arrays.copyOfRange(arr, 0, arr.length - 1)).sum() == 0;
		if (zeroSumOnTheRightSide) {
			return 0;
		} else if (zeroSumOnTheLefttSide) {
			return arr.length - 1;
		}
		OptionalInt lowestEvenIndex = IntStream.range(0, arr.length - 1).filter(index -> {
			int leftSideSum = Arrays.stream(Arrays.copyOfRange(arr, 0, index)).sum();
			int rightSideSum = Arrays.stream(Arrays.copyOfRange(arr, index + 1, arr.length)).sum();
			return leftSideSum == rightSideSum;
		}).findFirst();
		return lowestEvenIndex.orElse(-1);
	}

}

class Kata2 {
//	https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java
	public static double findUniq(double arr[]) {
		Map<Double, Integer> occuranceCount = new HashMap<>();
		DoubleStream.of(arr).forEach(e -> {
			occuranceCount.computeIfPresent(e, (k, v) -> occuranceCount.get(e) + 1);
			occuranceCount.computeIfAbsent(e, (v) -> 1);
		});
		return DoubleStream.of(arr).filter(d -> {
			return occuranceCount.get(d) == 1;
		}).findFirst().orElse(-1);
	}

//	https://www.codewars.com/kata/585d8c8a28bc7403ea0000c3/train/javascript
//	thre's no Java language option, but I did it anyways
	static String findUniq(String[] arr) {
		Map<String, String> sortedStingsMapping = new HashMap<>();
		String[] arrSorted = Stream.of(arr).map(s -> {
			String t = Stream.of(s.trim().toLowerCase().split("")).sorted().collect(Collectors.joining());
			sortedStingsMapping.put(t, s);
			return t;
		}).sorted().toArray(s -> new String[s]);
		return sortedStingsMapping.get(arrSorted[arrSorted.length - 1]);
	}
}

class Kata3 {
//	https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java/
	public static int[] sortArray(int[] array) {
		Queue<Integer> sortedOddNumbers = Arrays.stream(array).boxed().filter(n -> n % 2 != 0).sorted()
				.collect(Collectors.toCollection(LinkedList::new));
		IntStream.range(0, array.length).forEach(i -> {
			if (array[i] % 2 != 0) {
				array[i] = sortedOddNumbers.poll();
			}
		});
		return array;
	}
}

class Kata4 {
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

class SmileFaces {
	// https://www.codewars.com/kata/583203e6eb35d7980400002a/train/java
	static Predicate<String> gotSmilyFace = (s) -> {
		List<String> validFaces = List.of(":)", ";)", ":D", ";D", ":-)", ":~)", ";-)", ";~)", ":-D", ":~D", ";-D",
				";~D");
		return validFaces.contains(s);
	};

	public static int countSmileys(List<String> arr) {
		return arr.stream().filter(gotSmilyFace).collect(Collectors.toList()).size();
	}
}

class Solution1 {
	// https://www.codewars.com/kata/5208f99aee097e6552000148/solutions/java
	public static String camelCase(String input) {
		if (input.length() == 0) {
			return "";
		}
		return Stream.of(input.split("")).reduce("",
				(a, ch) -> (Character.isUpperCase(ch.charAt(0)) ? a.concat(" ").concat(ch) : a.concat(ch)));
	}
}

class LongestConsec {
//	https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/java
	public static String longestConsec(String[] arr, int arrPortion) {
		if (arr.length == 0 || arrPortion > arr.length || arrPortion <= 0) {
			return "";
		}
		Map<String, Integer> coupledWords = new LinkedHashMap<>();
		IntStream.rangeClosed(0, arr.length - arrPortion).forEach(from -> {
			String concatinatedChunk = concatStringsOfArray(from, from + arrPortion, arr);
			coupledWords.computeIfAbsent(concatinatedChunk, (length) -> concatinatedChunk.length());
		});
		Optional<Integer> greatestVal = coupledWords.values().stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(v -> v)));
		return coupledWords.keySet().stream().filter(k -> k.length() == greatestVal.get()).findFirst().get();
	}

	static String concatStringsOfArray(int from, int to, String[] arr) {
		return Stream.of(Arrays.copyOfRange(arr, from, to)).collect(Collectors.joining());
	}
}

class Kata5 {
//	https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/java
	public static String high(String s) {
		return Stream.of(s.split(" ")).sorted((a, b) -> (getTotalLettersScore(a) > getTotalLettersScore(b)) ? -1 : 1)
				.findFirst().orElse("");
	}

	public static String anotherHighSolution(String s) {
		Map<Integer, List<String>> wordsScore = Stream.of(s.split(" "))
				.collect(Collectors.groupingBy(Kata5::getTotalLettersScore));
		return wordsScore.get(wordsScore.keySet().stream().mapToInt(Integer::intValue).max().orElse(0)).get(0);

	}

	private static int getTotalLettersScore(String word) {
		return (word.length() == 0) ? 0
				: Stream.of(word.split("")).mapToInt(letter -> (int) letter.charAt(0) - 96).sum();
	}
}

class Kata6 {
	// https://www.codewars.com/kata/5842df8ccbd22792a4000245
	public static String expandedForm(int num) {
		return breakDownNumber(num).stream().map(String::valueOf).collect(Collectors.joining(" + "));
	}

	static private List<Integer> breakDownNumber(int num) {
		List<Integer> result = new ArrayList<>();
		int amountOfDigits = (int) Math.log10(num) + 1;
		while ((amountOfDigits--) > 0) {
			int divisor = (int) Math.pow(10, amountOfDigits);
			int quotient = num / divisor;
			num %= divisor;
			int value = quotient * divisor;
			if (value != 0) {
				result.add(value);
			}
		}
		return result;
	}

}

class Max {
	// https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/train/java
	public static int sequence(int[] arr) {
		boolean gotAllNegativeNumbersOrAnEmptyArray = Arrays.stream(arr).allMatch(n -> n < 0) || arr.length == 0;
		if (gotAllNegativeNumbersOrAnEmptyArray) {
			return 0;
		}
		int currentElement = 0;
		int maxElement = 0;
		for (int n : arr) {
			currentElement += Math.max(0, n + currentElement);
			maxElement = Math.max(maxElement, currentElement);
		}
		return maxElement;
	}
}

class Solution2 {
	// https://www.codewars.com/kata/57b06f90e298a7b53d000a86/train/java
	public static int solveSuperMarketQueue(int[] customers, int n) {
		if (n == 1 || customers.length == 0) {
			return Arrays.stream(customers).sum();
		}
		List<Integer> registers = Arrays.stream(new int[n]).mapToObj(Integer::valueOf).collect(Collectors.toList());
		for (int nextCustomer : customers) {
			int availableRegister = registers.indexOf(registers.stream().mapToInt(Integer::intValue).min().getAsInt());
			registers.set(availableRegister, registers.get(availableRegister) + nextCustomer);
		}
		System.out.println(registers);
		return registers.stream().mapToInt(Integer::intValue).max().getAsInt();
	}
}

class Kata7 {

	// https://www.codewars.com/kata/52efefcbcdf57161d4000091/train/java
	public static Map<Character, Integer> count(String str) {
		if (str.length() == 0) {
			return new LinkedHashMap<>();
		}
		Map<String, Long> t = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Integer> result = new LinkedHashMap<>();
		t.entrySet().stream().forEach((entry) -> {
			result.put(entry.getKey().charAt(0), entry.getValue().intValue());
		});
		return result;
	}
}

class MexicanWave {
	// https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/java
	public static String[] wave(String str) {
		List<String> waves = new ArrayList<>();
		IntStream.rangeClosed(0, str.length() - 1).forEach(wave -> {
			if (str.charAt(wave) != ' ') {
				StringBuilder currentWave = new StringBuilder(str);
				currentWave.setCharAt(wave, Character.toUpperCase(str.charAt(wave)));
				waves.add(currentWave.toString());
			}
		});
		return waves.toArray(new String[0]);
	}

}

class Solution3 {
	// https://www.codewars.com/kata/52c31f8e6605bcc646000082/train/java
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		IntStream.rangeClosed(0, numbers.length - 1).forEach(i -> {
			IntStream.rangeClosed(i + 1, numbers.length - 1).forEach(j -> {
				if (numbers[i] + numbers[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			});
		});

		return result;
	}
}

class Solution4 {
	// https://www.codewars.com/kata/587731fda577b3d1b0001196/train/java
	public static String camelCase(String str) {
		return Arrays.stream(str.split(" ")).filter(s -> s != "").map(Solution4::capitalizeFisrtLetter)
				.collect(Collectors.joining());
	}

	private static String capitalizeFisrtLetter(String s) {
		StringBuilder result = new StringBuilder(s);
		result.setCharAt(0, Character.toUpperCase(s.charAt(0)));
		return result.toString();
	};

}

class Diamond {
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

class Kata8 {
// https://www.codewars.com/kata/57814d79a56c88e3e0000786/train/java

	public static String encrypt(final String text, final int n) {
		if (!validateEncryptOrDecryptVal(text, n)) {
			return text;
		}
		StringBuilder result = new StringBuilder(text);
		for (int i = 0; i < n; i++) {
			result = oddIndexedFirstThenEqualIndexed(result);
		}
		return result.toString();
	}

	public static String decrypt(final String encryptedText, final int n) {
		if (!validateEncryptOrDecryptVal(encryptedText, n)) {
			return encryptedText;
		}
		StringBuilder result = new StringBuilder(encryptedText);
		for (int i = 0; i < n; i++) {
			result = decryptIndexes(result);
		}

		return result.toString();
	}

	private static boolean validateEncryptOrDecryptVal(String text, int n) {
		return (text != null && !text.isEmpty() && n > 0);
	}

	private static StringBuilder oddIndexedFirstThenEqualIndexed(StringBuilder text) {
		StringBuilder oddIndexed = new StringBuilder();
		StringBuilder evenIndexed = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (i % 2 == 0) {
				evenIndexed.append(text.charAt(i));
			} else {
				oddIndexed.append(text.charAt(i));
			}
		}
		return oddIndexed.append(evenIndexed);
	}

	private static StringBuilder decryptIndexes(StringBuilder encryptedText) {
		int evenIndexedStartAt = encryptedText.length() / 2;
		StringBuilder result = new StringBuilder();
		Queue<String> wereOddIndexed = new LinkedList<>(
				Arrays.stream(encryptedText.subSequence(0, evenIndexedStartAt).toString().split(""))
						.collect(Collectors.toList()));
		Queue<String> wereEvenIndexed = new LinkedList<>(Arrays
				.stream(encryptedText.subSequence(evenIndexedStartAt, encryptedText.length()).toString().split(""))
				.collect(Collectors.toList()));
		for (int i = 0; i < encryptedText.length(); i++) {
			if (i % 2 == 0) {
				result.append(wereEvenIndexed.poll());
			} else {
				result.append(wereOddIndexed.poll());
			}
		}
		return result;
	}
}

public class KyuSix {

	public static void main(String[] args) {
		KyuSix kyuSix = new KyuSix();

	}
}