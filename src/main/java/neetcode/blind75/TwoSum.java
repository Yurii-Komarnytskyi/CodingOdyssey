package neetcode.blind75;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] indicesOfTwoSum = new int[2];
		for(int i = 0; i <= nums.length-1; i++) {
			for(int j = i + 1; j <= nums.length-1; j++) {
				if(nums[i] + nums[j] == target) {
					indicesOfTwoSum[0] = Math.min(i, j);
					indicesOfTwoSum[1] = Math.max(i, j);
					return indicesOfTwoSum;
				}
			}
		}
		return indicesOfTwoSum;
	}
}
