package codingbat.string3;

public class StringThree {

	public int countYZ(String str) {
		int yzCount = 0;
		if (str.isEmpty()) {
			return yzCount;
		}
		String strLettersOnly = str.replaceAll("[^a-zA-Z0]", " ");
		for (String s : strLettersOnly.split(" ")) {
			boolean endsWithEither_Y_or_Z = s.toLowerCase().endsWith("y") || s.toLowerCase().endsWith("z");
			if (endsWithEither_Y_or_Z) {
				yzCount++;
			}
		}
		return yzCount;
	}

	public String withoutString(String base, String remove) {
		final String BASE_LOVER_CASE = base.toLowerCase();
		final String REMOVE_LOVER_CASE = remove.toLowerCase();
		StringBuilder result = new StringBuilder(base);
		boolean isRemovalPartAbsent = !BASE_LOVER_CASE.contains(REMOVE_LOVER_CASE);

		if (isRemovalPartAbsent) {
			return base;
		} else {
			int removeIndex = BASE_LOVER_CASE.indexOf(REMOVE_LOVER_CASE);
			while (removeIndex != -1) {
				result.delete(removeIndex, removeIndex + remove.length());
				result.insert(removeIndex, remove);
				removeIndex = BASE_LOVER_CASE.indexOf(REMOVE_LOVER_CASE, removeIndex + 1);
			}
			return result.toString().replaceAll(remove, "");
		}
	}

	public boolean equalIsNot(String str) {
		int isCount = 0;
		int notCount = 0;
		int isIndex = str.indexOf("is");
		int notIndex = str.indexOf("not");
		if (isIndex == -1 && notIndex == -1) {
			return true;
		}
		while (isIndex != -1) {
			isCount++;
			isIndex = str.indexOf("is", isIndex + 1);
		}
		while (notIndex != -1) {
			notCount++;
			notIndex = str.indexOf("not", notIndex + 1);
		}
		return isCount == notCount;
	}

	public boolean gHappy(String str) {
		int gIndex = str.indexOf("g");
		int lastGIndex = str.lastIndexOf("g");
		final int STR_LEN_MINUS_1 = str.length() - 1;
		boolean is_g_atTheBeginnigOrInTheEndUnhappy = (gIndex != -1 || lastGIndex != -1) && (gIndex == lastGIndex
				|| (gIndex == 0 && gIndex + 1 <= STR_LEN_MINUS_1 && str.charAt(gIndex + 1) != 'g')
				|| (lastGIndex == STR_LEN_MINUS_1 && str.charAt(lastGIndex - 1) != 'g'));
		boolean result = !is_g_atTheBeginnigOrInTheEndUnhappy;
		if (gIndex == -1 || is_g_atTheBeginnigOrInTheEndUnhappy) {
			return result;
		}
		while (gIndex != -1) {
			if (!(str.charAt(gIndex + 1) == 'g' || str.charAt(gIndex - 1) == 'g')) {
				result = false;
				break;
			}
			gIndex = str.indexOf("g", gIndex + 2);
		}
		return result;
	}

	public int countTriple(String str) {
		if (str.length() < 3) {
			return 0;
		}
		int tripleCount = 0;
		final String PADDING_SIGN = "<>";
		String[] lettersWithPadding = str.trim().concat(PADDING_SIGN).split("");
		StringBuilder currentTriple = new StringBuilder();
		for (int i = 0; i <= str.length(); i++) {
			String currentLetter = lettersWithPadding[i];
			if (currentLetter.equals(lettersWithPadding[i + 1]) || currentTriple.indexOf(currentLetter) != -1) {
				currentTriple.append(currentLetter);
			} else {
				if (currentTriple.length() >= 3) {
					tripleCount += (currentTriple.length() == 3) ? 1 : currentTriple.length() - 2;
				}
				currentTriple = new StringBuilder();
			}

		}
		return tripleCount;
	}

	public int sumDigits(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char currentCharacter = str.charAt(i);
			if (Character.isDigit(currentCharacter)) {
				sum += Integer.parseInt(String.valueOf(currentCharacter));
			}
		}
		return sum;
	}

	public String sameEnds(String string) {
		if (string.length() < 2) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		int stringLengthDividedByTwo = string.length() / 2;
		String leftSideSubstring = string.substring(0, stringLengthDividedByTwo);
		String rightSideSubstring = (string.length() % 2 == 0) ? string.substring(stringLengthDividedByTwo)
				: string.substring(stringLengthDividedByTwo + 1);
		for (int i = 0; i <= leftSideSubstring.length() - 1; i++) {
			result.append(leftSideSubstring.charAt(i));
			boolean hasReachedRightSubstringEnd = rightSideSubstring.endsWith(result.toString()) && result.length() > 1;
			if (hasReachedRightSubstringEnd) {
				break;
			}
			if (rightSideSubstring.indexOf(result.toString()) == -1) {
				result.delete(0, result.length());
				break;
			}
		}
		return result.toString();
	}

	public String mirrorEnds(String string) {
		if (string.length() <= 1) {
			return string;
		} else if (string.charAt(0) != string.charAt(string.length() - 1)) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		int stringMiddle = (string.length() % 2 == 0) ? string.length() / 2 : (string.length() / 2) + 1;
		for (int i = 0; i <= stringMiddle; i++) {
			builder.append(string.charAt(i));
			boolean gotMirroringEnd = string.endsWith(builder.reverse().toString());
			boolean gotOverlap = (i == stringMiddle) && gotMirroringEnd;
			builder.reverse();
			if (gotOverlap) {
				return string;
			} else if (gotMirroringEnd) {
				result.append(string.charAt(i));
			}
		}
		return result.toString();
	}

	public int maxBlock(String str) {
		int currentBlock = 1;
		int largestBlock = 1;
		if (str.length() == 0) {
			return 0;
		}
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				currentBlock++;
				largestBlock = (currentBlock > largestBlock) ? currentBlock : largestBlock;
			} else {
				currentBlock = 1;
			}
		}
		return largestBlock;
	}

	public int sumNumbers(String str) {
		int sum = 0;
		final String ZERO = "0";
		StringBuilder digitStreak = new StringBuilder(ZERO);
		for (int i = 0; i <= str.length() - 1; i++) {
			if (Character.isDigit(str.charAt(i))) {
				digitStreak.append(str.charAt(i));
			} else {
				sum += Integer.valueOf(digitStreak.toString());
				digitStreak = new StringBuilder(ZERO);
			}
		}
		sum += Integer.valueOf(digitStreak.toString());
		return sum;
	}

	public String notReplace(String str) {
		StringBuilder result = new StringBuilder(str);
		final String CLEAN_IS = " is ";
		final String NOT = " not";
		int indexOf_IS = result.indexOf(CLEAN_IS, 0);
		while (indexOf_IS != -1) {
			result.insert((indexOf_IS + 3), NOT);
			indexOf_IS = result.indexOf(CLEAN_IS, (++indexOf_IS));
		}
		if (str.equals(CLEAN_IS.trim())
				|| (str.startsWith(CLEAN_IS.trim()) && !(Character.isLetter(result.toString().charAt(2))))) {
			result.insert(2, NOT);
		}
		if (str.endsWith(CLEAN_IS.trim()) && str.length() >= 3
				&& !(Character.isLetter(str.toString().charAt(str.length() - 3)))) {
			result.insert(result.length(), NOT);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		StringThree st = new StringThree();
		System.out.println(st.notReplace("is"));
	}

}
