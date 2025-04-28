package codingbat.string2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringTwo {

	public String doubleChar(String str) {
		StringBuilder result = new StringBuilder();
		for (String s : str.split(""))
			result.append(s + s);
		return result.toString();
	}

	public int countHi(String str) {
		int count = 0;
		int index = 0;
		while (str.indexOf("hi", index) != -1) {
			index += str.substring(index).indexOf("hi") + 1;
			count++;
		}
		return count;
	}

	public boolean catDog(String str) {
		int cat = 0;
		int dog = 0;
		int index = 0;
		while (str.indexOf("cat", index) != -1) {
			index += str.substring(index).indexOf("cat") + 1;
			cat++;
		}
		index = 0;
		while (str.indexOf("dog", index) != -1) {
			index += str.substring(index).indexOf("dog") + 1;
			dog++;
		}

		return (cat == dog) ? true : false;
	}

	public int countCode(String str) {
		int count = 0;
		for (int i = 0; i != -1;) {
			if (str.length() - 1 >= str.indexOf("co", i) + 3 && str.indexOf("co", i) != -1
					&& str.charAt(str.indexOf("co", i) + 3) == 'e') {
				count++;
			}
			i = (str.indexOf("co", i) != -1) ? str.indexOf("co", i) + 2 : -1;
		}
		return count;
	}

	public boolean endOther(String a, String b) {
		String[] strArr = { a, b };
		Arrays.sort(strArr, Comparator.comparingInt(String::length));
		return (strArr[1].toLowerCase().endsWith(strArr[0].toLowerCase()));
	}

	public boolean xyzThere(String str) {
		boolean result = false;
		final String XYZ = "xyz";
		for (int i = 0; i != -1;) {
			if ((str.indexOf(XYZ, i) - 1 >= 0 && str.charAt(str.indexOf(XYZ, i) - 1) != '.') || str.startsWith(XYZ))
				result = true;
			i = (str.indexOf(XYZ, i) != -1) ? str.indexOf(XYZ, i + 1) : -1;
		}
		return result;
	}

	public boolean bobThere(String str) {
		boolean result = false;
		final String theB = "b";
		for (int i = 0; i != -1;) {
			if (i + 2 <= str.length() - 1 && str.charAt(i + 2) == 'b') {
				result = true;
				break;
			}
			i = (str.indexOf(theB, i) != -1) ? str.indexOf(theB, i + 1) : -1;
		}
		return result;
	}

	public boolean xyBalance(String str) {
		int yIndex = str.lastIndexOf("y");
		int xIndex = str.lastIndexOf("x");
		return (yIndex > xIndex || (yIndex == -1 && xIndex == -1)) ? true : false;
	}

	public String mixString(String a, String b) {
		StringBuilder reslt = new StringBuilder();
		String[] lesserAtZeroBiggerAtOne = { a, b };
		Arrays.sort(lesserAtZeroBiggerAtOne, Comparator.comparingInt(String::length));
		for (int i = 0; i < lesserAtZeroBiggerAtOne[0].length(); i++) {
			reslt.append(Character.valueOf(a.charAt(i)).toString() + Character.valueOf(b.charAt(i)).toString());
		}
		return (lesserAtZeroBiggerAtOne[0].length() == lesserAtZeroBiggerAtOne[1].length()) ? reslt.toString()
				: reslt.append(lesserAtZeroBiggerAtOne[1].substring(lesserAtZeroBiggerAtOne[0].length())).toString();
	}

	public String repeatEnd(String str, int n) {
		int count = n;
		StringBuilder result = new StringBuilder();
		while (count > 0) {
			result.append(str.substring(str.length() - n));
			count--;
		}
		return result.toString();
	}

	public String repeatFront(String str, int n) {
		StringBuilder result = new StringBuilder();
		while (n >= 1) {
			result.append(str.substring(0, n));
			n--;
		}
		return result.toString();
	}

	public String repeatSeparator(String word, String sep, int count) {
		if (count == 0)
			return "";
		StringBuilder result = new StringBuilder(word);
		while (count > 1) {
			result.append(sep + word);
			count--;
		}
		return result.toString();
	}

	public boolean prefixAgain(String str, int n) {
		return (str.substring(n).contains(str.substring(0, n))) ? true : false;
	}

	public boolean xyzMiddle(String str) {
		final String XYZ = "xyz";
		if (!str.contains(XYZ))
			return false;
		int outOfBoundWorkAroundIndex = (str.indexOf(XYZ, str.length() / 2 - 2) == -1) ? 0
				: str.indexOf(XYZ, str.length() / 2 - 2);
		int aSide = str.substring(0, str.indexOf(XYZ, outOfBoundWorkAroundIndex)).length();
		int bSide = str.substring(str.indexOf(XYZ, outOfBoundWorkAroundIndex)).length() - XYZ.length();
		return (Math.abs(aSide - bSide) <= 1);
	}

	public String getSandwich(String str) {
		final String BREAD = "bread";
		if (str.indexOf(BREAD) == str.lastIndexOf(BREAD))
			return "";
		return str.substring(str.indexOf(BREAD) + BREAD.length(), str.lastIndexOf(BREAD));
	}

	public boolean sameStarChar(String str) {
		boolean result = true;
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*' && (str.charAt(i - 1) != str.charAt(i + 1))) {
				result = false;
				break;
			}
		}
		return result;
	}

	public String oneTwo(String str) {
		StringBuilder result = new StringBuilder();
		int endIndex = str.length() - str.length() % 3;
		for (int i = 0; i < endIndex; i += 3) {
			result.append(str.substring(i + 1, i + 3) + str.charAt(i));
		}
		return result.toString();
	}

	public String zipZap(String str) {
		if (str.length() <= 2)
			return str;
		StringBuilder result = new StringBuilder(str);
		for (int i = 0; i < str.length() - 2; i++) {
			if (result.charAt(i) == 'z' && result.charAt(i + 2) == 'p')
				result.deleteCharAt(i + 1);
		}
		return result.toString();
	}

	public String plusOut(String str, String word) {
		if (!str.contains(word))
			return str;
		Set<Integer> wordIndices = new LinkedHashSet<>();
		StringBuilder result = new StringBuilder();
		for (int o = 0; o <= str.length() - 1; o++)
			result.append('+');
		int i = 0;
		while (str.indexOf(word, i) != -1) {
			wordIndices.add(str.indexOf(word, i));
			i++;
		}
		for (int ind : wordIndices) {
			result.replace(ind, ind + word.length(), word);
		}
		return result.toString();
	}

	public String starOut(String str) { // NIGHTMARE
		if (!str.contains("*"))
			return str;
		StringBuilder strFiltered = new StringBuilder(str);
		int count = 0;
		while (strFiltered.indexOf("**", count) != -1) {
			int foundStarsInd = strFiltered.indexOf("**", count);
			strFiltered.replace(foundStarsInd, foundStarsInd + 2, "*");
			count++;
		}
		count = 0;
		while (strFiltered.indexOf("*", count) != -1) {
			int startDelete = (strFiltered.indexOf("*", count) == 0) ? 0 : strFiltered.indexOf("*", count) - 1;
			int endDelete = (strFiltered.indexOf("*", count) > 0
					&& strFiltered.indexOf("*", count) <= strFiltered.length()) ? strFiltered.indexOf("*", count) + 2
							: 2;
			strFiltered.delete(startDelete, endDelete);
			count++;
		}
		return strFiltered.toString();
	}

	public String wordEnds(String str, String word) {
		if (!str.contains(word))
			return "";
		StringBuilder result = new StringBuilder();
		int count = 0;
		int currentWordIndex;
		while (str.indexOf(word, count) != -1) {
			currentWordIndex = str.indexOf(word, count);
			if (currentWordIndex != 0)
				result.append(str.charAt(currentWordIndex - 1));
			if ((currentWordIndex + word.length() - 1) != str.length() - 1)
				result.append(str.charAt(currentWordIndex + word.length()));
			count = currentWordIndex + 1;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		StringTwo st = new StringTwo();
		System.out.println(st.wordEnds("abc1xyz1i1j", "1"));
	}

}
