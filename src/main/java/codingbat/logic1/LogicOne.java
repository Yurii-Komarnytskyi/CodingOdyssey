package codingbat.logic1;

import java.util.*;
import java.util.function.*;

public class LogicOne {

	public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
		if (isAsleep)
			return false;
		return (isMorning && isMom || !isMorning) ? true : false;
	}

	public int teenSum(int a, int b) {
		return (a >= 13 && a <= 19 || b >= 13 && b <= 19) ? 19 : a + b;
	}

	public boolean cigarParty(int cigars, boolean isWeekend) {
		if (isWeekend && cigars >= 40)
			return true;
		return (!(cigars >= 40 && cigars <= 60)) ? false : true;
	}

	public int dateFashion(int you, int date) {
		return (you <= 2 || date <= 2) ? 0 : (you >= 8 || date >= 8) ? 2 : 1;
	}

	public boolean squirrelPlay(int temp, boolean isSummer) {
		int upperLimit = (isSummer) ? 100 : 90;
		return temp >= 60 && temp <= upperLimit;
	}

	public int caughtSpeeding(int speed, boolean isBirthday) {
		int extraSpeed = isBirthday ? 5 : 0;
		return (speed > 81 + extraSpeed) ? 2 : (speed <= 60 + extraSpeed) ? 0 : 1;

	}

	public int sortaSum(int a, int b) {
		return (a + b >= 10 && a + b <= 19) ? 20 : a + b;
	}

	public String alarmClock(int day, boolean vacation) {
		if (day > 0 && day < 6)
			return (vacation) ? "10:00" : "7:00";
		return (vacation) ? "off" : "10:00";
	}

	public boolean love6(int a, int b) {
		return (a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6) ? true : false;
	}

	public boolean in1To10(int n, boolean outsideMode) {
		if (outsideMode)
			return (n <= 1 || n >= 10) ? true : false;
		return (n >= 1 && n <= 10) ? true : false;
	}

	public boolean specialEleven(int n) {
		return n % 11 == 0 || n % 11 == 1;
	}

	public boolean more20(int n) {
		return n % 20 <= 2 && n % 20 != 0;
	}

	public boolean old35(int n) {
		return (n % 3 == 0) != (n % 5 == 0);
	}

	public boolean less20(int n) {
		return n % 20 == 18 || n % 20 == 19;
	}

	public boolean nearTen(int num) {
		int a = num % 10;
		return 8 <= a || 2 >= a;
	}

	public int teaParty(int tea, int candy) {
		boolean isLame = tea < 5 || candy < 5;
		boolean isOk = tea >= 5 && candy >= 5;
		boolean isCool = tea >= (candy * 2) || candy >= (tea * 2);
		if (isLame)
			return 0;
		if (isCool)
			return 2;
		if (isOk)
			return 1;
		return -1;
	}

	public String fizzString(String str) {
		boolean startsWithF = str.startsWith("f");
		boolean endsWithD = str.endsWith("bч");
		if (startsWithF && endsWithD) {
			return "FizzBuzz";
		}
		if (startsWithF || endsWithD) {
			return (startsWithF) ? "Fizz" : "Buzz";
		}
		return str;
	}

	public String fizzString2(int n) {
		boolean isDivisibleByThree = n % 3 == 0;
		boolean isDivisibleByFive = n % 5 == 0;
		if (isDivisibleByThree && isDivisibleByFive) {
			return "FizzBuzz!";
		} else if (isDivisibleByThree) {
			return "Fizz!";
		} else if (isDivisibleByFive) {
			return "Buzz!";
		}
		return String.valueOf(n) + "!";
	}

	public boolean twoAsOne(int a, int b, int c) {
		int[] argsSorted = { a, b, c };
		Arrays.sort(argsSorted);
		return Math.abs(argsSorted[0]) + Math.abs(argsSorted[1]) == argsSorted[2];
	}

	public boolean inOrder(int a, int b, int c, boolean bOk) {
		if (bOk) {
			return c > b;
		}
		return b > a && c > b;
	}

	public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
		BiPredicate<Integer, Integer> checkForIncreasingOrEqual = (prevNum, nextNum) -> {
			return (equalOk) ? prevNum <= nextNum : prevNum < nextNum;
		};
		boolean isInOrderEqual = true;
		int[] argsArray = { a, b, c };
		for (int i = 0; i < argsArray.length - 1; i++) {
			isInOrderEqual = checkForIncreasingOrEqual.test(argsArray[i], argsArray[i + 1]);
			if (!isInOrderEqual)
				break;
		}
		return isInOrderEqual;
	}

	public boolean lastDigit(int a, int b, int c) {
		return a % 10 == b % 10 || b % 10 == c % 10 || a % 10 == c % 10;
	}

	public boolean lessBy10(int a, int b, int c) {
		int[] argsArray = { a, b, c };
		Arrays.sort(argsArray);
		return argsArray[argsArray.length - 1] - argsArray[0] >= 10;
	}

	public int withoutDoubles(int die1, int die2, boolean noDoubles) {
		if (noDoubles && die1 == die2) {
			return (die1 == 6) ? 1 + die2 : die1 + 1 + die2;
		}
		return die1 + die2;
	}

	public int maxMod5(int a, int b) {
		if (a == b)
			return 0;
		int[] argsArray = { a, b };
		Arrays.sort(argsArray);
		return (argsArray[0] % 5 == argsArray[1] % 5) ? argsArray[0] : argsArray[1];
	}

	public int redTicket(int a, int b, int c) {
		Map<Integer, Boolean> ticketCodes = new HashMap<>();
		ticketCodes.put(10, (a == 2 && b == 2 && c == 2));
		ticketCodes.put(5, (a == b && b == c && a != 2));
		ticketCodes.put(1, (b != a && c != a));
		for (Map.Entry<Integer, Boolean> entry : ticketCodes.entrySet()) {
			if (entry.getValue())
				return entry.getKey();
		}
		return 0;
	}

	public int greenTicket(int a, int b, int c) {
		if (a == b && b == c && c == a) {
			return 20;
		}
		return ((a == b) || (b == c) || (a == c)) ? 10 : 0;
	}

	public int blueTicket(int a, int b, int c) {
		int abPair = a + b;
		int bcPair = c + b;
		int acPair = a + c;

		if (abPair == 10 || bcPair == 10 || acPair == 10) {
			return 10;
		} else if (abPair - bcPair >= 10 || abPair - acPair >= 10) {
			return 5;
		}
		return 0;
	}

	public boolean shareDigit(int a, int b) {
		String aToStr = String.valueOf(a);
		String bToStr = String.valueOf(b);
		for (String s : aToStr.split("")) {
			if (bToStr.contains(s)) {
				return true;
			}
		}
		return false;
	}

	public int sumLimit(int a, int b) {
		int aLength = (String.valueOf(a)).length();
		int a_and_b_SumLength = (String.valueOf(a + b)).length();
		return (aLength == a_and_b_SumLength) ? a + b : a;
	}

	public static void main(String[] args) {
		LogicOne lo = new LogicOne();
		System.out.println(lo.sumLimit(10, 90));

	}

}