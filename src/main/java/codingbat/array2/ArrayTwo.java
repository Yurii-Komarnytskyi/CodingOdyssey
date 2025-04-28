package codingbat.array2;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTwo {
	public int countEvens(int[] nums) {
		Integer count = 0;
		for (int i : nums)
			if (i % 2 == 0) {
				count++;
			}
		return count;
	}

	public int bigDiff(int[] nums) {
		SortedSet<Integer> sortedNums = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
		return sortedNums.last() - sortedNums.first();

	}

	public int centeredAverage(int[] nums) {
		Arrays.sort(nums);
		List<Integer> nl = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		int sum = nl.stream().skip(1).limit(nl.size() - 2).reduce(0, (a, b) -> a + b);
		return sum / (nl.size() - 2);
	}

	public int sum13(int[] nums) {
		if (nums.length - 1 == -1) {
			return 0;
		}
		List<Integer> nl = Arrays.stream(nums).boxed().collect(Collectors.toList());
		for (ListIterator<Integer> li = nl.listIterator(); li.hasNext();) {
			if (li.next() == 13 && li.hasNext()) {
				li.remove();
				li.next();
				li.remove();
			}
		}
		if (!nl.isEmpty() && nl.get(nl.size() - 1) == 13) {
			nl.remove(nl.size() - 1);
		}
		return nl.stream().reduce(0, (a, b) -> a + b);
	}

	public int sum67(int[] nums) {
		List<Integer> nl = Arrays.stream(nums).boxed().collect(Collectors.toList());
		for (ListIterator<Integer> li = nl.listIterator(); li.hasNext();) {
			if (li.next() == 6) {
				li.remove();
				while (li.next() != 7)
					li.remove();
				li.remove();
			}
		}
		return nl.stream().reduce(0, (a, b) -> a + b);
	}

	public boolean has22(int[] nums) {
		List<Integer> nl = Arrays.stream(nums).boxed().collect(Collectors.toList());
		if (!nl.contains(2)) {
			return false;
		}
		for (ListIterator<Integer> li = nl.listIterator(); li.hasNext();)
			if (li.next() == 2 && li.hasNext() && li.next() == 2) {
				return true;
			}
		return false;
	}

	public boolean lucky13(int[] nums) {
		List<Integer> nl = Arrays.stream(nums).boxed().collect(Collectors.toList());
		return !nl.contains(1) && !nl.contains(3);
	}

	public boolean sum28(int[] nums) {
		List<Integer> twosList = new ArrayList<>();
		for (int i : nums)
			if (i == 2) {
				twosList.add(2);
			}
		return twosList.stream().reduce(0, (a, b) -> a + b) == 8;
	}

	public boolean more14(int[] nums) {
		Map<Integer, Integer> result = new HashMap<>();
		result.putIfAbsent(1, 0);
		result.putIfAbsent(4, 0);
		for (int i : nums)
			if (result.containsKey(i)) {
				result.computeIfPresent(i, (a, b) -> ++b);
			}
		return result.get(1) > result.get(4);
	}

	public int[] fizzArray(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}

	public boolean only14(int[] nums) {
		for (int i : nums)
			if (i != 1 && i != 4) {
				return false;
			}
		return true;
	}

	public String[] fizzArray2(int n) {
		String[] result = new String[n];
		Arrays.fill(result, "");
		for (int i = 0; i < n; i++)
			result[i] = String.valueOf(i);
		return result;
	}

	public boolean no14(int[] nums) {
		List<Integer> nl = Arrays.stream(nums).boxed().collect(Collectors.toList());
		return (!nl.contains(1) || !nl.contains(4));
	}

	public boolean isEverywhere(int[] nums, int val) {
		List<Integer> nl = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int ultimateValInd = (nl.indexOf(val) % 2 == 0) ? 0 : 1;
		if (nl.isEmpty() || nl.indexOf(val) == -1 && nl.size() == 1 || nl.get(nl.size() - 1) == 5) { // STUPID WORK-AROUND
			return true;
		}
		for (int i = 0; i < nl.size() - 1;) {
			List<Integer> pair = nl.subList(i, i + 2);
			if (pair.indexOf(val) == -1 || pair.indexOf(val) != ultimateValInd
					|| pair.size() == 1 && pair.size() - 1 != ultimateValInd) {
				return false;
			}
			i += 2;
		}
		return (nl.size() % 2 != 0 && nl.get(nl.size() - 1) != val) ? false : true;
	}

	public boolean either24(int[] nums) {
		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		if (numsList.indexOf(2) == -1 && numsList.indexOf(4) == -1) {
			return false;
		}
		boolean hasTwoNextTwo = false;
		boolean hasFourNextFour = false;
		int prior = 0;
		for (int n : numsList) {
			if (prior == 2 && n == 2) {
				hasTwoNextTwo = true;
			} else if (prior == 4 && n == 4) {
				hasFourNextFour = true;
			}
			prior = n;
		}
		return hasTwoNextTwo != hasFourNextFour;
	}

	public int matchUp(int[] nums1, int[] nums2) {
		int counter = 0;
		for (int i = 0; i <= nums1.length - 1; i++) {
			counter = (Math.abs(nums2[i] - nums1[i]) <= 2 && Math.abs(nums2[i] - nums1[i]) > 0) ? ++counter : counter;
		}
		return counter;
	}

	public boolean has77(int[] nums) {
		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		List<Integer> sevenIndexes = new ArrayList<>();
		for (int i = 0; i < numsList.size(); i++) {
			if (numsList.get(i) == 7) {
				sevenIndexes.add(i + 1);
			}
		}
		if (sevenIndexes.size() < 2) {
			return false;
		} else {
			for (ListIterator<Integer> iterator = sevenIndexes.listIterator(sevenIndexes.size()); iterator
					.hasPrevious();) {
				int differance = iterator.previous() - ((iterator.hasPrevious()) ? iterator.previous() : 0);
				if (differance == 2 || differance == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean has12(int[] nums) {
		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		return numsList.lastIndexOf(2) > numsList.indexOf(1) && (numsList.contains(1) && numsList.contains(2));
	}

	public boolean modThree(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		boolean isPrevEven = (nums[0] % 2 == 0);
		boolean isCurrentEven;
		int oddStreak = (isPrevEven) ? 0 : 1;
		int evenStreak = (isPrevEven) ? 1 : 0;
		for (int i = 1; i < nums.length; i++) {
			isCurrentEven = nums[i] % 2 == 0;
			if (isCurrentEven && isPrevEven) {
				++evenStreak;
			} else if (!isCurrentEven && !isPrevEven) {
				++oddStreak;
			} else if (evenStreak == 3 || oddStreak == 3) {
				return true;
			} else {
				isPrevEven = !isPrevEven;
				evenStreak = (isCurrentEven) ? 1 : 0;
				oddStreak = (isCurrentEven) ? 0 : 1;
			}
		}
		return (evenStreak >= 3 || oddStreak >= 3);
	}

	public boolean haveThree(int[] nums) {
		int quantityOfThree = (nums[0] == 3) ? 1 : 0;
		final int ALLOWED_QUANT_OF_THREE = 3;
		int prevNumber;
		for (int i = 1; i < nums.length; i++) {
			prevNumber = nums[i - 1];
			quantityOfThree = (nums[i] == 3) ? quantityOfThree + 1 : quantityOfThree;
			if (nums[i] == 3 && prevNumber == 3 || quantityOfThree > ALLOWED_QUANT_OF_THREE) {
				return false;

			}
		}
		return quantityOfThree == 3;
	}

	public boolean twoTwo(int[] nums) {
		List<Integer> indexesOfTwo = new ArrayList<>();
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] == 2) {
				indexesOfTwo.add(index + 1);
			}
		}
		if (indexesOfTwo.isEmpty()) {
			return true;
		} else if (indexesOfTwo.size() == 1) {
			return false;
		}
		BiPredicate<Integer, Integer> areNumbersNextToEachOther = (a, b) -> b - a == 1;
		for (int j = 0; j < indexesOfTwo.size() - 1; j++) {
			if (!areNumbersNextToEachOther.test(indexesOfTwo.get(j), indexesOfTwo.get(j + 1))) {
				return false;
			}
		}
		return true;
	}

	public boolean sameEnds(int[] nums, int len) {
		List<Integer> numsCollection = Arrays.stream(nums).boxed().collect(Collectors.toList());
		List<Integer> beginningOfNums = numsCollection.subList(0, len);
		List<Integer> endingOfNums = numsCollection.subList(numsCollection.size() - len, numsCollection.size());
		return beginningOfNums.equals(endingOfNums);
	}

	public boolean tripleUp(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		final int MIN_ADJACENT_STREAK = 2;
		int adjacentCount = 0;
		for (int i = 0; i < nums.length; i++) {
			int nextIndex = i + 1;
			if (nextIndex <= nums.length - 1 && nums[nextIndex] - nums[i] == 1) {
				++adjacentCount;
			} else if (adjacentCount >= MIN_ADJACENT_STREAK) {
				return true;
			} else {
				adjacentCount = 0;
			}
		}
		return adjacentCount >= MIN_ADJACENT_STREAK;
	}

	public int[] fizzArray3(int start, int end) {
		List<Integer> result = new ArrayList<>();
		IntStream.range(start, end).forEach(num -> {
			result.add(num);
		});
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] shiftLeft(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		Deque<Integer> result = new ArrayDeque<>();
		result.addLast(nums[0]);
		for (int j = nums.length - 1; j >= 1; j--) {
			result.addFirst(nums[j]);
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] tenRun(int[] nums) {
		boolean hasMultOfTen = Arrays.stream(nums).anyMatch(n -> n % 10 == 0);
		if (!hasMultOfTen) {
			return nums;
		}

		List<Integer> numsCollection = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int currentMultOfTen = -1;
		int priorMultOfTen = -1;

		for (int i = 0; i < numsCollection.size(); i++) {
			boolean isMultipleOfTen = numsCollection.get(i) % 10 == 0;
			if (isMultipleOfTen && priorMultOfTen != numsCollection.get(i)) {
				currentMultOfTen = numsCollection.get(i);
			}
			if (currentMultOfTen != priorMultOfTen) {
				numsCollection.set(i, currentMultOfTen);
			}
			if (isMultipleOfTen && numsCollection.get(i) != currentMultOfTen) {
				priorMultOfTen = currentMultOfTen;
				currentMultOfTen = numsCollection.get(i);
			}
		}
		return numsCollection.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] pre4(int[] nums) {
		List<Integer> numsCollection = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int firstFourIndex = numsCollection.indexOf(4);
		if (firstFourIndex == -1) {
			return nums;
		}
		return numsCollection.subList(0, firstFourIndex).stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] post4(int[] nums) {
		List<Integer> numsCollection = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int lastFourIndex = numsCollection.lastIndexOf(4);
		return numsCollection.subList(lastFourIndex + 1, numsCollection.size()).stream().mapToInt(Integer::intValue)
				.toArray();
	}

	public int[] notAlone(int[] nums, int val) {
		if (nums.length < 3) {
			return nums;
		}

		int[] arrCopy = Arrays.copyOf(nums, nums.length);
		int current = 0;
		int next = 0;
		int previous = 0;

		for (int j = 1; j < arrCopy.length - 1; j++) {
			current = arrCopy[j];
			next = arrCopy[j + 1];
			previous = arrCopy[j - 1];
			if (current == val && previous != val && next != val) {
				int greaterIndex = (Math.max(previous, next) == previous) ? j - 1 : j + 1;
				arrCopy[greaterIndex] = Math.max(previous, next);
				arrCopy[j] = Math.max(previous, next);
			}
		}
		return arrCopy;
	}

	public int[] zeroFront(int[] nums) {
		Deque<Integer> result = new ArrayDeque<>();
		for (int n : nums) {
			if (n == 0) {
				result.addFirst(n);
			} else {
				result.addLast(n);
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] withoutTen(int[] nums) {
		List<Integer> zeros = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for (int n : nums) {
			if (n == 10) {
				zeros.add(0);
			} else {
				result.add(n);
			}
		}
		result.addAll(zeros);
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] zeroMax(int[] nums) {
		Function<int[], Integer> getGreatestOddNumber = (arrOfNums) -> {
			int greatestOddFound = -1;
			for (int i = 0; i < arrOfNums.length; i++) {
				if (arrOfNums[i] % 2 != 0 && arrOfNums[i] > greatestOddFound) {
					greatestOddFound = arrOfNums[i];
				}
			}
			return greatestOddFound;
		};
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int greatestOddFound = getGreatestOddNumber.apply(Arrays.copyOfRange(nums, i, nums.length));
				nums[i] = (greatestOddFound != -1) ? greatestOddFound : 0;
			}
		}
		return nums;
	}

	public int[] evenOdd(int[] nums) {
		List<Integer> numsCollection = Arrays.stream(nums).boxed().collect(Collectors.toList());

		Collections.sort(numsCollection, (Integer a, Integer b) -> {
			if (a % 2 == 0) {
				return -1;
			} else if ((a % 2 == 0 && b % 2 == 0)) {
				return 0;
			} else
				return 1;
		});
		return numsCollection.stream().mapToInt(Integer::intValue).toArray();
	}

	public String[] fizzBuzz(int start, int end) {
		List<String> result = new ArrayList<>();
		Function<Integer, String> fizzBuzznezzChecker = num -> {
			if (num % 3 == 0 && num % 5 == 0) {
				return "FizzBuzz";
			} else if (num % 3 == 0) {
				return "Fizz";
			} else if (num % 5 == 0) {
				return "Buzz";
			} else {
				return String.valueOf(num);
			}
		};
		for (int i = start; i < end; i++) {
			String currentIndexTransformed = fizzBuzznezzChecker.apply(i);
			result.add(currentIndexTransformed);
		}
		return result.toArray(new String[0]);
	}

	public static void main(String[] args) {

		ArrayTwo at = new ArrayTwo();
		System.out.println(at.fizzBuzz(10, 40));

	}
}
