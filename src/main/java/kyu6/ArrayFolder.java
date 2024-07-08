package kyu6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayFolder {
	// https://www.codewars.com/kata/57ea70aa5500adfe8a000110/train/java

	public static int[] foldArray(int[] array, int foldNTimes) {
		List<Integer> result = Arrays.stream(array).boxed().collect(Collectors.toList());

		for (int i = 0; i < foldNTimes; i++) {
			result = foldSingleTime(result);
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	private static List<Integer> foldSingleTime(List<Integer> beingFolded) {
		int theMiddle = (beingFolded.size() % 2 == 0) ? beingFolded.size() / 2 : (beingFolded.size() / 2) + 1;
		Deque<Integer> secondHalf = new ArrayDeque<>(beingFolded.subList(theMiddle, beingFolded.size()));
		if (beingFolded.size() % 2 == 0) {
			return beingFolded.stream().limit(theMiddle).map(item -> item += secondHalf.pollLast())
					.collect(Collectors.toList());
		} else {
			return beingFolded.stream().limit(theMiddle)
					.map(item -> item += Optional.ofNullable(secondHalf.pollLast()).orElse(0))
					.collect(Collectors.toList());
		}
	}
}
