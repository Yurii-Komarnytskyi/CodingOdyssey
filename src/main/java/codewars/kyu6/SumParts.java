package codewars.kyu6;

public class SumParts {
	// https://www.codewars.com/kata/5ce399e0047a45001c853c2b/train/java

	public static int[] sumParts(int[] arr) {
		int[] result = new int[arr.length + 1];
		int posytion = arr.length - 1;
		int sum = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = sum;
			if (posytion >= 0) {
				sum = sum + arr[posytion];
				posytion--;
			}
		}
		return result;
	}
}