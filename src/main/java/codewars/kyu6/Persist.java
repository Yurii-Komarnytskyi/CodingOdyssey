package codewars.kyu6;

public class Persist {
	// https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/java

	public static int persistence(long n) {
		int multiplicativePersistence = 0;
		long nCopy = n;
		while (nCopy > 9) {
			multiplicativePersistence++;
			nCopy = String.valueOf(nCopy).chars().map(Character::getNumericValue).reduce(1, (a, b) -> a * b);
		}
		return multiplicativePersistence;
	}
}