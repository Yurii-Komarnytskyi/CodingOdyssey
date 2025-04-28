package codewars.kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDiff {
	// https://www.codewars.com/kata/523f5d21c841566fde000009/train/java
	public static int[] arrayDiff(int[] a, int[] b) {
		List<Integer> aAsList = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> bAsList = Arrays.stream(b).boxed().collect(Collectors.toList());
		aAsList.removeAll(bAsList);
		return aAsList.stream().mapToInt(Integer::intValue).toArray();
	}
}
