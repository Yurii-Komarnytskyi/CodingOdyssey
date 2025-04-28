package neetcode.blind75;

public class BinarySearch {
	// https://neetcode.io/problems/binary-search

	public int search(int[] nums, int target) {
		int result = -1;
		for(int i = 0; i <= nums.length-1; i++) {
			if (nums[i] == target) {
				result = i;
				break;
			}
		}
		return result;
	}
}
