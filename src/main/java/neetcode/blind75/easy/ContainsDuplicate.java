package neetcode.blind75.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	// https://neetcode.io/problems/duplicate-integer
	public boolean hasDuplicate(int[] nums) {
		Set<Integer> uniqueNums = new HashSet<>();
		for(int i : nums) {
			if(!uniqueNums.add(i)) {
				return true;
			}
		}
		return false;
    }
}
