package kyu7;

public class SumOfASequence {
	// https://www.codewars.com/kata/586f6741c66d18c22800010a/train/java

	public static int sequenceSum(int start, int end, int step) {
		int sum = start;
		int currentStep = sum;
		if(start > end) {
			return 0;
		}
		
		while(currentStep + step <= end) {
			currentStep += step;
			sum += currentStep;
			if (currentStep + step == end) {
				sum += end;
				break;
			}
		}
		
		return sum;
	  }
}
