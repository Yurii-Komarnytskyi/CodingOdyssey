package codewars.kyu4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class Snail {
	// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java

	public static int[] snail(int[][] array) {
		if (array.length <= 1) {
			return (array.length == 0) ? new int[0] : array[0];
		}
		List<Integer> list = traverse2dArrayClockwise(array);
		int[][] subArray = dissectRemainderOfTheShellPattern(array);

		while(subArray.length != 0) {
			list.addAll(traverse2dArrayClockwise(subArray));
			subArray = dissectRemainderOfTheShellPattern(subArray);
		}

		return list.stream().mapToInt(Integer::valueOf).toArray();
	}
	
	private static int[][] dissectRemainderOfTheShellPattern(int[][] array) {
		boolean is3x3Array = array.length == 3 && Stream.of(array).allMatch(a -> a.length == 3);
		if (array.length <= 2) {
			return new int[][]{};
		}
		else if (is3x3Array) {
			return new int[][] {{array[1][1]}};
		}
		
		int[][] result = new int[array.length-2][];

		for(int yAxis = 1, resultYAxis = 0; yAxis <= array.length-2; yAxis++, resultYAxis++) {
			result[resultYAxis] = Arrays.copyOfRange(array[yAxis], 1, array[yAxis].length-1);
		}
		
		return result;
	}
	
	private static List<Integer> traverse2dArrayClockwise(int[][] array) {
		List<Integer> list = new ArrayList<>();
		list.addAll(arrayTopToListForwards(array));
		list.addAll(arrayToDequeRightTopToBottom(array));
		list.addAll(arrayBottomToDequeBackwards(array));
		list.addAll(arrayToDequeLeftBottomToTop(array));
		return list;
	}

	private static List<Integer> arrayTopToListForwards(int[][] array) {
		return (array.length == 0) 
				? Collections.emptyList()
				: Arrays.stream(array[0]).boxed().toList();
	}

	private static Deque<Integer> arrayBottomToDequeBackwards(int[][] array) {
		Deque<Integer> deq = new ArrayDeque<>();
		if (array.length <= 1) {
			return deq;
		} else {
			for(int i : array[array.length-1]) {
				deq.push(i);
			} 
			return deq;
		}
	}

	private static Deque<Integer> arrayToDequeRightTopToBottom(int[][] array) {
		Deque<Integer> deq = new ArrayDeque<>();
		for(int[] subArray : array) {
			deq.offer(subArray[subArray.length-1]);
		}
		deq.pollFirst();
		deq.pollLast();
		return deq;
	}

	private static Deque<Integer> arrayToDequeLeftBottomToTop(int[][] array) {
		Deque<Integer> deq = new ArrayDeque<>();
		for(int[] subArray : array) {
			deq.offerFirst(subArray[0]);
		}
		deq.pollFirst();
		deq.pollLast();
		return deq;
	}
}
