package codingbat.warmup2;

import java.util.HashMap;

public class WarmUpTwo {

	public String stringTimes(String str, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++)
			result.append(str);
		return result.toString();
	}

	public String frontTimes(String str, int n) {
		String first = (str.length() - 1 > 2) ? str.substring(0, 3) : str;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++)
			result.append(first);
		return result.toString();
	}

	public int countXX(String str) {
		String xStr = "x";
		if (!str.contains(xStr))
			return 0;
		int totalX = 0;
		int subCountX = 0;
		String[] words = str.split(" ");
		for (String w : words) {
			for (String s : w.split(""))
				if (s.equalsIgnoreCase(xStr))
					subCountX++;
			totalX += (subCountX > 1) ? subCountX - 1 : 0;
			subCountX = 0;
		}
		return totalX;
	}

	public boolean doubleX(String str) {
		int indFollowsX = str.indexOf('x') + 1;
		return (indFollowsX <= str.length() - 1 && str.charAt(indFollowsX) == 'x') ? true : false;
	}

	public String stringBits(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <= str.length() - 1;) {
			result.append(str.charAt(i));
			i += 2;
		}
		return result.toString();
	}

	public String stringSplosion(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			builder.insert(builder.length(), str.substring(0, i + 1));
		}
		return builder.append(str).toString();
	}

	public int last2(String str) {
		String lastTwo = (str.length() - 1 >= 1) ? str.substring(str.length() - 2, str.length()) : null;
		if (lastTwo == null)
			return 0;
		int count = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 2).equals(lastTwo))
				count++;
		}
		return count;
	}

	public int arrayCount9(int[] nums) {
		int count = 0;
		for (int num : nums)
			if (num == 9)
				count++;
		return count;
	}

	public boolean arrayFront9(int[] nums) {
		int theEnd = (nums.length - 1 < 3) ? nums.length - 1 : 3;
		for (int i = 0; i <= theEnd; i++) {
			if (nums[i] == 9)
				return true;
		}
		return false;
	}

	public boolean array123(int[] nums) {
		HashMap<Integer, Integer> unique = new HashMap<>();
		for (int i = 0; i <= nums.length - 1; i++)
			unique.put(nums[i], nums[i]);
		return (unique.get(1) == null || unique.get(2) == null || unique.get(3) == null) ? false : true;
	}

	public int stringMatch(String a, String b) {
		int shortStrLen = (a.length() - 1 <= b.length() - 1) ? a.length() - 2 : b.length() - 2;
		int count = 0;
		for (int i = 0; i <= shortStrLen; i++) {
			if (a.substring(i, i + 2).equals(b.substring(i, i + 2)))
				count++;
		}
		return count;
	}

	public String stringX(String str) {
		if (str.length() - 1 <= 1)
			return str;
		StringBuilder result = new StringBuilder(String.valueOf(str.charAt(0)));
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'x')
				continue;
			result.append(str.charAt(i));
		}
		return result.append(str.charAt(str.length() - 1)).toString();
	}

	public String altPairs(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <= str.length() - 1; i += 4) {
			int end = i + 2;
			if (end > str.length())
				end = str.length();
			result.append(str.substring(i, end));
		}
		return result.toString();
	}

	public String stringYak(String str) {
		StringBuilder result = new StringBuilder(str);
		while (result.indexOf("yak") != -1) {
			result.delete(result.indexOf("yak"), result.indexOf("yak") + 3);
		}
		return result.toString();
	}

	public int array667(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			count += (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) ? 1 : 0;
		}
		return count;
	}

	public boolean noTriples(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
				return false;
		}
		return true;
	}

	public boolean has271(int[] nums) {
		for (int i = 0; i + 2 < nums.length; i++) {
			boolean isNextGreaterByFive = nums[i] + 5 == nums[i + 1];
			boolean doesLastNotDifferMoreThanTwoFromStart = (Math.abs(nums[i + 2] - (nums[i] - 1)) <= 2);
			if (isNextGreaterByFive && doesLastNotDifferMoreThanTwoFromStart) {
				return true;
			}
		}

		return false;
	}

}
