package kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StockList {
	// https://www.codewars.com/kata/54dc6class%20StockList%20%7B%20//%201st%20parameter%20is%20the%20stocklist%20(L%20in%20example),%20//%202nd%20parameter%20is%20list%20of%20categories%20(M%20in%20example)%20public%20static%20String%20stockSummary(String[]%20lstOfArt,%20String[]%20lstOf1stLetter)%20%7B%20//%20your%20code%20here%20return%20...%20%7D%20%7D

	public static String stockSummary(String[] stocklist, String[] categories) {
		if (stocklist.length == 0 || categories.length == 0) {
			return "";
		}
		return Arrays.stream(categories).map(cathegory -> {
			long booksCount = Arrays.stream(stocklist).filter(code -> code.charAt(0) == cathegory.charAt(0))
					.mapToLong(StockList::getCountOfBooksFromCode).sum();
			return prettifyStrIntPair(cathegory, booksCount);
		}).collect(Collectors.joining(" - "));
	}

	private static String prettifyStrIntPair(String s, long i) {
		return String.format("(%s : %d)", s, i);
	}

	private static long getCountOfBooksFromCode(String code) {
		return Arrays.stream(code.split(" ")).filter(s -> (int) s.charAt(0) >= 48 && (int) s.charAt(0) <= 57)
				.mapToInt(Integer::valueOf).sum();
	}
}