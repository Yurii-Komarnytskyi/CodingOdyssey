package codingbat.array1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;


public class ArrayOne {
	public boolean firstLast6(int[] nums) {
		return nums[0] == 6 || nums[nums.length - 1] == 6;
	}

	public boolean sameFirstLast(int[] nums) {
		return nums.length >= 1 && nums[0] == nums[nums.length - 1];
	}

	public int[] makePi() {
		int[] result = { 3, 1, 4 };
		return result;
	}

	public boolean commonEnd(int[] a, int[] b) {
		return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
	}

	public int sum3(int[] nums) {
		int result = 0;
		for (int n : nums)
			result += n;
		return result;
	}

	public int[] rotateLeft3(int[] nums) {
		List<Integer> numsL = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.rotate(numsL, -1);
		return numsL.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] reverse3(int[] nums) {
		List<Integer> numsL = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.reverse(numsL);
		return numsL.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] maxEnd3(int[] nums) {
		Arrays.fill(nums, (nums[0] >= nums[nums.length - 1]) ? nums[0] : nums[nums.length - 1]);
		return nums;
	}

	public int sum2(int[] nums) {
		if (Arrays.asList(nums).isEmpty())
			return 0;

		int result = 0;
		for (int i = 0; i < 2; i++)
			result += (i > nums.length - 1) ? 0 : nums[i];
		return result;
	}

	public int[] middleWay(int[] a, int[] b) {
		int[] r = { a[1], b[1] };
		return r;
	}

	public int[] makeEnds(int[] nums) {
		int[] r = { nums[0], nums[nums.length - 1] };
		return r;
	}

	public boolean has23(int[] nums) {
		return nums[0] == 2 || nums[0] == 3 || nums[nums.length - 1] == 2 || nums[nums.length - 1] == 3;
	}

	public boolean no23(int[] nums) {
		List<Integer> numsL = Arrays.stream(nums).boxed().collect(Collectors.toList());
		return !numsL.contains(2) && !numsL.contains(3);
	}

	public int[] makeLast(int[] nums) {
		int[] result = new int[nums.length * 2];
		result[result.length - 1] = nums[nums.length - 1];
		for (int el : result)
			el = 0;
		return result;
	}

	public boolean double23(int[] nums) {
		int twoCounter = 0;
		int threeCounter = 0;
		for (int el : nums) {
			if (el == 2)
				++twoCounter;
			if (el == 3)
				++threeCounter;
		}
		return twoCounter == 2 || threeCounter == 2;
	}

	public int[] fix23(int[] nums) {
		for (int i = 0; i <= nums.length - 1; i++) {
			if (nums[i] == 2 && i + 1 <= nums.length - 1 && nums[i + 1] == 3)
				nums[i + 1] = 0;
		}
		return nums;
	}

	public int start1(int[] a, int[] b) {
		int oneCount = 0;
		if (a.length >= 1 && a[0] == 1)
			oneCount++;
		if (b.length >= 1 && b[0] == 1)
			oneCount++;
		return oneCount;
	}

	public int[] biggerTwo(int[] a, int[] b) {
		return ((a[0] + a[a.length - 1]) >= (b[0] + b[b.length - 1])) ? a : b;
	}

	public int[] makeMiddle(int[] nums) {
		if (nums.length == 2)
			return nums;
		int[] result = { nums[nums.length / 2 - 1], nums[nums.length / 2] };
		return result;
	}

	public int[] plusTwo(int[] a, int[] b) {
		List<Integer> res = new ArrayList<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
		res.addAll(Arrays.stream(b).boxed().collect(Collectors.toList()));
		return res.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] swapEnds(int[] nums) {
		if (nums.length <= 1)
			return nums;
		int firstInt = nums[0];
		nums[0] = nums[nums.length - 1];
		nums[nums.length - 1] = firstInt;
		return nums;
	}

	public int[] midThree(int[] nums) {
		if (nums.length <= 3)
			return nums;
		List<Integer> res = new ArrayList<>();
		for (int i = nums.length / 2 - 1; i < (nums.length / 2 + 2); i++)
			res.add(nums[i]);
		return res.stream().mapToInt(Integer::intValue).toArray();
	}

	public int maxTriple(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		List<Integer> three = new ArrayList<>();
		three.add(nums[0]);
		three.add(nums[nums.length - 1]);
		three.add(nums[nums.length / 2]);
		Collections.sort(three, Collections.reverseOrder());
		return three.get(0);
	}
	public int[] frontPiece(int[] nums) {
		if(nums.length < 2) return nums;
		int[] res = { nums[0], nums[1] };
		return res;
	}
	public boolean unlucky1(int[] nums) {
		if(nums.length <= 1) return false;
		boolean result = false;
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i] == 1 && (i <= 1 || i >= nums.length - 2) && nums[i+1] == 3) {
				result = true;
				break;
			} 
		}
		return result;
	}
	public int[] make2(int[] a, int[] b) {
		List<Integer> holder = new ArrayList<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
		holder.addAll(Arrays.stream(b).boxed().collect(Collectors.toList()));
		int[] result = {holder.get(0), holder.get(1)};
		return result;
	}
	public int[] front11(int[] a, int[] b) {
		Queue<Integer> result = new LinkedList<>();
		if(a.length > 0 ) result.add(a[0]);
		if(b.length > 0 ) result.add(b[0]);
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	

	public static void main(String[] args) {
		ArrayOne ao = new ArrayOne();
		int[] t = { 8, 6, 7, 5, 3, 0, 9 };
		List<Integer> wrapper = Arrays.stream(ao.midThree(t)).boxed().collect(Collectors.toList());
		System.out.println(wrapper);
	}

}
