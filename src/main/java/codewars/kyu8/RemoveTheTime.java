package codewars.kyu8;

public class RemoveTheTime {
	// https://www.codewars.com/kata/56b0ff16d4aa33e5bb00008e/train/java
	
	private static final String COMMA = ",";
	
	public static String shortenToDate(String longDate) {
	    return longDate.substring(0, longDate.indexOf(COMMA));
	  }

}
