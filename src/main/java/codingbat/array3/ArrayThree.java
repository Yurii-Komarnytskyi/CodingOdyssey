package codingbat.array3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayThree {

	public int maxSpan(int[] nums) {
		int greatestSpan = 0;
		if (nums.length - 1 == 0) {
			return 1;
		}
		BinaryOperator<Integer> getDifferenceInEnclosingIndex = (index, value) -> {
			int enclosingIndex = nums.length - 1;
			int startInclusive = 1;
			for (int backwardsIndex = enclosingIndex; value != nums[backwardsIndex]; backwardsIndex--) {
				enclosingIndex--;
			}
			return enclosingIndex - index + startInclusive;
		};
		for (int i = 0; i < nums.length - 1; i++) {
			int currentIndexDifference = getDifferenceInEnclosingIndex.apply(i, nums[i]);
			greatestSpan = (greatestSpan < currentIndexDifference) ? currentIndexDifference : greatestSpan;
		}
		return greatestSpan;
	}

	public int[] fix34(int[] nums) {
		List<Integer> copyOfNums = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
		BiFunction<Integer, List<Integer>, Queue<Integer>> leave_X_AndGetTheRestWhileReplasingWithNull = (x,
				source) -> {
			Queue<Integer> removedFromSource = new LinkedList<>();
			for (int index = 0; index < copyOfNums.size(); index++) {
				if (copyOfNums.get(index) != x) {
					removedFromSource.add(copyOfNums.get(index));
					copyOfNums.set(index, null);
				}
			}
			return removedFromSource;
		};
		BiFunction<Integer, Integer, List<Integer>> followEvery_X_With_Y = (x, y) -> {
			for (int index = 0; index < copyOfNums.size(); index++) {
				if (copyOfNums.get(index) == x) {
					copyOfNums.set(index + 1, y);
				}
			}
			return copyOfNums;
		};
		BiFunction<List<Integer>, Queue<Integer>, List<Integer>> changeSourcesNullsWithQueueContents = (source,
				qContents) -> {
			for (int index = 0; index < source.size(); index++) {
				if (source.get(index) == null) {
					source.set(index, qContents.poll());
				}
			}
			return source;
		};
		Queue<Integer> removedFromCopyOfNums = leave_X_AndGetTheRestWhileReplasingWithNull.apply(3, copyOfNums);
		removedFromCopyOfNums.removeIf((num) -> num == 4);
		followEvery_X_With_Y.apply(3, 4);
		changeSourcesNullsWithQueueContents.apply(copyOfNums, removedFromCopyOfNums);
		return copyOfNums.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] fix45(int[] nums) {
		List<Integer> copyOfNums = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
		BiFunction<Integer, List<Integer>, Queue<Integer>> leave_X_AndGetTheRestWhileReplasingWithNull = (x,
				source) -> {
			Queue<Integer> removedFromSource = new LinkedList<>();
			for (int index = 0; index < copyOfNums.size(); index++) {
				if (copyOfNums.get(index) != x) {
					removedFromSource.add(copyOfNums.get(index));
					copyOfNums.set(index, null);
				}
			}
			return removedFromSource;
		};
		BiFunction<Integer, Integer, List<Integer>> followEvery_X_With_Y = (x, y) -> {
			for (int index = 0; index < copyOfNums.size(); index++) {
				if (copyOfNums.get(index) == x) {
					copyOfNums.set(index + 1, y);
				}
			}
			return copyOfNums;
		};
		BiFunction<List<Integer>, Queue<Integer>, List<Integer>> changeSourcesNullsWithQueueContents = (source,
				qContents) -> {
			for (int index = 0; index < source.size(); index++) {
				if (source.get(index) == null) {
					source.set(index, qContents.poll());
				}
			}
			return source;
		};
		Queue<Integer> removedFromCopyOfNums = leave_X_AndGetTheRestWhileReplasingWithNull.apply(4, copyOfNums);
		removedFromCopyOfNums.removeIf((num) -> num == 5);
		followEvery_X_With_Y.apply(4, 5);
		changeSourcesNullsWithQueueContents.apply(copyOfNums, removedFromCopyOfNums);
		return copyOfNums.stream().mapToInt(Integer::intValue).toArray();
	}

	public boolean canBalance(int[] nums) {
		boolean isEvenlySplitable = false;
		List<Integer> copyOfNums = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
		if (copyOfNums.isEmpty() || copyOfNums.size() < 2) {
			return isEvenlySplitable;
		}
		ListIterator<Integer> numsListerator = copyOfNums.listIterator(1);
		while (numsListerator.hasNext()) {
			int sumBeforeCursor = copyOfNums.subList(0, numsListerator.nextIndex()).stream().mapToInt(Integer::intValue)
					.sum();
			int sumAfterCursor = copyOfNums.subList(numsListerator.nextIndex(), copyOfNums.size()).stream()
					.mapToInt(Integer::intValue).sum();
			numsListerator.next();
			if (sumBeforeCursor == sumAfterCursor) {
				isEvenlySplitable = true;
				break;
			}
		}
		return isEvenlySplitable;
	}

	public boolean linearIn(int[] outer, int[] inner) {
		Set<Integer> outerCopy = Arrays.stream(outer).boxed().collect(Collectors.toCollection(HashSet::new));
		Set<Integer> innerCopy = Arrays.stream(inner).boxed().collect(Collectors.toCollection(HashSet::new));
		int initialOuterSize = outerCopy.size() - 1;
		outerCopy.addAll(innerCopy);
		return initialOuterSize == outerCopy.size() - 1;
	}

	public int[] squareUp(int n) {

		List<Integer> result = new ArrayList<>();
		int[] zeros = new int[n];
		List<Integer> incrementedQuarters = new ArrayList<>();
		incrementedQuarters.addAll(Arrays.stream(zeros).boxed().collect(Collectors.toCollection(LinkedList::new)));

		Consumer<Integer> incrementQuartersAccordingToLap = (lap) -> {
			incrementedQuarters.set(incrementedQuarters.size() - lap, lap);
		};

		for (int lap = 1; lap <= n; lap++) {
			incrementQuartersAccordingToLap.accept(lap);
			result.addAll(incrementedQuarters);
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] seriesUp(int n) {
		List<Integer> result = new ArrayList<>();
		Function<Integer, List<Integer>> getListWithIntegersUpToApplied = (num) -> {
			List<Integer> seriePriorToNum = new ArrayList<>();
			for (int i = 1; i <= num; i++) {
				seriePriorToNum.add(i);
			}
			return seriePriorToNum;
		};
		for (int i = 1; i <= n; i++) {
			result.addAll(getListWithIntegersUpToApplied.apply(i));
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int maxMirror(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int maxMirrorCount = 0;
		for (int onwardsIndex = 0; onwardsIndex < nums.length; onwardsIndex++) {
			for (int backwardsIndex = nums.length - 1; backwardsIndex > onwardsIndex; backwardsIndex--) {
				int matchedLength = 0;
				int nextOnwardsIndex = onwardsIndex;
				int nextBackwardsIndex = backwardsIndex;
				Boolean oppositeIndexesMatch = nums[onwardsIndex] == nums[backwardsIndex];
				while (oppositeIndexesMatch) {
					matchedLength++;
					nextOnwardsIndex++;
					nextBackwardsIndex--;
					oppositeIndexesMatch = nextOnwardsIndex < nums.length && nextBackwardsIndex >= 0
							&& nums[nextOnwardsIndex] == nums[nextBackwardsIndex];
				}
				if (matchedLength > maxMirrorCount) {
					maxMirrorCount = matchedLength;
				}
			}
		}
		return maxMirrorCount;
	}

	public int countClumps(int[] nums) {
		int clumpsCount = 0;
		Integer foundClump = -1;

		for (int i = 0; i < nums.length - 1; i++) {
			int currentElement = nums[i];
			int nextElement = nums[i + 1];

			if (currentElement == nextElement && currentElement != foundClump) {
				clumpsCount++;
				foundClump = currentElement;
			} else if (currentElement != nextElement) {
				foundClump = -1;
			}

		}
		return clumpsCount;
	}

	public static void main(String[] args) {
		ArrayThree arrThree = new ArrayThree();
		int[] nums1 = { 1, 2, 1, 4 };
		System.out.println(arrThree.maxMirror(nums1));
	}

}
