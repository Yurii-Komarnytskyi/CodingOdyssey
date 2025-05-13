package neetcode.blind75;

public class ValidPalindrome {
	// https://neetcode.io/problems/is-palindrome
	
	private static final String REGEX_ROMOVE_NON_LETTERS = "[^a-zA-Z0-9]";
	public boolean isPalindrome(String s) {
		if(s.length() == 1) {
			return true;
		}
		String filteredS = s.replaceAll(REGEX_ROMOVE_NON_LETTERS, "");
		String reversedAndFilteredS = new StringBuilder(filteredS)
				.reverse()
				.toString();
		return reversedAndFilteredS.equalsIgnoreCase(filteredS);
    }
}
