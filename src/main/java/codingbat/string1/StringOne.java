package codingbat.string1;

public class StringOne {
	public String helloName(String name) {
		return "Hello ".concat(name).concat("!");
	}

	public String makeAbba(String a, String b) {
		return a + b + b + a;
	}

	public String makeTags(String tag, String word) {
		return String.format("<%s>%s</%s>", tag, word, tag);
	}

	public String makeOutWord(String out, String word) {
		return new StringBuilder(out).insert(2, word).toString();
	}

	public String extraEnd(String str) {
		String lastTwo = str.substring(str.length() - 2);
		return lastTwo.concat(lastTwo).concat(lastTwo);
	}

	public String firstTwo(String str) {
		return (str.length() - 1 > 1) ? str.substring(0, 2) : str.substring(0);
	}

	public String firstHalf(String str) {
		return str.substring(0, str.length() / 2);
	}

	public String withoutEnd(String str) {
		return str.substring(1, str.length() - 1);
	}

	public String comboString(String a, String b) {
		return (a.length() - 1 < b.length() - 1) ? a.concat(b).concat(a) : b.concat(a).concat(b);
	}

	public String nonStart(String a, String b) {
		return a.substring(1).concat(b.substring(1));
	}

	public String left2(String str) {
		return new StringBuilder(str.substring(2)).append(str.substring(0, 2)).toString();
	}

	public String right2(String str) {
		return new StringBuilder(str.substring(str.length() - 2)).append(str.substring(0, str.length() - 2)).toString();
	}

	public String theEnd(String str, boolean front) {
		return (front) ? str.substring(0, 1) : str.substring(str.length() - 1);
	}

	public String withouEnd2(String str) {
		if (str.length() - 1 <= 1)
			return "";
		return str.substring(1, str.length() - 1);
	}

	public String middleTwo(String str) {
		return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
	}

	public boolean endsLy(String str) {
		return str.endsWith("ly");
	}

	public String nTwice(String str, int n) {
		return str.substring(0, n).concat(str.substring(str.length() - n));
	}

	public String twoChar(String str, int index) {
		return (index < 0 || index > str.length() - 2) ? str.substring(0, 2) : str.substring(index, index + 2);
	}

	public String middleThree(String str) {
		return str.substring((str.length() / 2) - 1, (str.length() / 2) + 2);
	}

	public boolean hasBad(String str) {
		return (str.length() - 1 >= 1 && (str.startsWith("bad") || str.substring(1).startsWith("bad"))) ? true : false;
	}

	public String atFirst(String str) {
		int lenNeeded = 1;
		StringBuilder result = new StringBuilder(str);
		for (int i = 0; i <= lenNeeded; i++)
			if (str.length() - 1 < i)
				result.append("@");
		return result.substring(0, lenNeeded + 1).toString();
	}

	public String lastChars(String a, String b) {
		String first = (a.length() == 0) ? "@" : String.valueOf(a.charAt(0));
		String last = (b.length() == 0) ? "@" : String.valueOf(b.charAt(b.length() - 1));
		return first.concat(last);
	}

	public String conCat(String a, String b) {
		return ((a.length() > 0 && b.length() > 0) && a.endsWith(String.valueOf(b.charAt(0)))) ? a + b.substring(1)
				: a + b;
	}

	public String lastTwo(String str) {
		return (str.length() - 1 >= 1) ? str.substring(0, str.length() - 2)
				+ String.valueOf(str.charAt(str.length() - 1)) + String.valueOf(str.charAt(str.length() - 2)) : str;
	}

	public String seeColor(String str) {
		String[] neededColors = { "red", "blue" };
		for (String s : neededColors)
			if (str.startsWith(s))
				return s;
		return "";
	}

	public boolean frontAgain(String str) {
		return (str.length() - 1 >= 1 && str.startsWith(str.substring(str.length() - 2))) ? true : false;
	}

	public String minCat(String a, String b) {
		return (a.length() >= b.length()) ? a.substring(a.length() - b.length()).concat(b)
				: a.concat(b.substring(b.length() - a.length()));
	}

	public String extraFront(String str) {
		return (str.length() > 2) ? str.substring(0, 2) + str.substring(0, 2) + str.substring(0, 2) : str + str + str;
	}

	public String without2(String str) {
		if (str.length() == 2 && str.startsWith(str))
			return "";
		return (str.length() > 2 && str.startsWith(str.substring(str.length() - 2))) ? str.substring(2) : str;
	}

	public String deFront(String str) {
		return ((str.charAt(0) == 'a') ? "a" : "").concat((str.charAt(1) == 'b') ? "b" : "") + str.substring(2);
	}

	public String startWord(String str, String word) {
		return ((str.length() >= word.length())
				&& (str.startsWith(word) || str.substring(1).startsWith(word.substring(1))))
						? str.substring(0, word.length())
						: "";
	}

	public String withoutX(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i <= str.length() - 1; i++) {
			if ((i == 0 || i == str.length() - 1) && str.charAt(i) == 'x')
				continue;
			res.append(str.charAt(i));
		}
		return res.toString();
	}

	public String withoutX2(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i <= str.length() - 1; i++) {
			if ((i == 0 || i == 1) && str.charAt(i) == 'x')
				continue;
			res.append(str.charAt(i));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		StringOne so = new StringOne();
		System.out.println(so.withoutX("xxHi"));
	}
}
