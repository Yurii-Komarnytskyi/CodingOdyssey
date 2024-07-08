package kyu6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortTheOdd {
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