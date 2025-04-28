package codingbat.logic2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;

class LogicTwo {

	public boolean makeBricks(int small, int big, int goal) {
		final int BIG_BRICKS_LENGTH = big * 5;
		if(BIG_BRICKS_LENGTH > goal && goal % 5 != 0) {
			int amountBigBricksFittingGoal = ( goal % 5) + (big * 5) % goal;	
			return amountBigBricksFittingGoal + small >= goal;
		}
		return (small + big * 5) >= goal;
	}

	public int loneSum(int a, int b, int c) {
		int[] argsArray = {a, b, c};
		Set<Integer> uniqueArgs = new HashSet<>();
		Set<Integer> beenDuplicatedAtLeastOnce = new HashSet<>();
		for(int num : argsArray) {
			if(!uniqueArgs.add(num)) {
				beenDuplicatedAtLeastOnce.add(num);
			}
		}
		uniqueArgs.removeAll(beenDuplicatedAtLeastOnce);
		return uniqueArgs.stream().mapToInt(Integer::intValue).sum(); 
	}
	public int luckySum(int a, int b, int c) {
		final int UNLUCKY_NUMBER = 13;
		int sumOfLuckyArgs = 0;
		int[] argsArray = {a, b, c};
		for(int num : argsArray){
			if(num == UNLUCKY_NUMBER){
				break;
			}
			sumOfLuckyArgs += num;
		}
		return sumOfLuckyArgs;
	}
	public int noTeenSum(int a, int b, int c) {
		IntPredicate isATeen = (num) ->  num >= 13 && num <= 19;
		IntPredicate isNot_15_or_16_yearsOld = (num) -> num != 15 && num != 16;
		int sumWithoutTeen = 0;
		int[] argsArray = {a, b, c};
		for(int num : argsArray){
			if( isATeen.test(num) && isNot_15_or_16_yearsOld.test(num)){
				continue;			
			}
			sumWithoutTeen += num;

		}
		return sumWithoutTeen;
	}

	public int roundSum(int a, int b, int c) {
		int sumOfArgsRounded = 0;
		int[] argsArray = {a, b, c};
		UnaryOperator<Integer> roundToNextMultOfTen = (num)-> num + (10 - num % 10);
		UnaryOperator<Integer> roundToPreviousMultOfTen = (num)-> num - (num % 10);
		for(int num : argsArray){
			if(num % 10 >= 5) {
				sumOfArgsRounded += roundToNextMultOfTen.apply(num);
			} else {
				sumOfArgsRounded += roundToPreviousMultOfTen.apply(num);
			}
		}
		return sumOfArgsRounded;
	}

	public boolean closeFar(int a, int b, int c) {
		if( (Math.abs(a - b) <= 1 && Math.abs(c - b) >= 2 &&  Math.abs(c - a) >= 2) || 
				(Math.abs(a - c) <= 1 && Math.abs(b - c) >= 2 &&  Math.abs(b - a) >= 2)) {
			return true;
		}
		return false;
	}
	public int blackjack(int a, int b) {
		final int DECK_SIZE = 21;
		boolean areBothArgsOverDeckSize = a > DECK_SIZE && b > DECK_SIZE;
		boolean isAnyArgOverDeckSize = a > DECK_SIZE || b > DECK_SIZE;
		if(isAnyArgOverDeckSize) {
			return (areBothArgsOverDeckSize)? 0 : Math.min(a, b);
		}
		return (Math.abs(Math.min(DECK_SIZE - a, DECK_SIZE - b)) == Math.abs(DECK_SIZE - a))? a : b;
	}
	public boolean evenlySpaced(int a, int b, int c) {
		int[] argsArray = {a, b, c};
		Arrays.sort(argsArray);
		int smallAndMediumSpace  = Math.abs(argsArray[0] - argsArray[1]);
		int mediumAndLargeSpace = Math.abs(argsArray[1] - argsArray[2]);
		return smallAndMediumSpace == mediumAndLargeSpace;
	}
	public int makeChocolate(int small, int big, int goal) {
		final int BIG_BARS_TOTAL_WEIGHT = big * 5; // single big bar weighs 5 kg.
		int smallBarsToUse = -1;
		UnaryOperator<Integer> roundToPreviousMultOfFive = (num)-> (num % 5 == 0)? 
				(num - 1) - ((num - 1) % 5) : num - (num % 5);
		int amountBigBarsKilosFittingGoal = BIG_BARS_TOTAL_WEIGHT;
		while(amountBigBarsKilosFittingGoal > goal) {
			amountBigBarsKilosFittingGoal = roundToPreviousMultOfFive.apply(amountBigBarsKilosFittingGoal);
		}
		if(amountBigBarsKilosFittingGoal == goal) {
			return 0;
		} else if(amountBigBarsKilosFittingGoal + small >= goal ) {
			return smallBarsToUse = (goal - amountBigBarsKilosFittingGoal);
		}
		return smallBarsToUse;
	}	

	public static void main(String[] args) {
		LogicTwo lt = new LogicTwo();
		System.out.println(lt.makeChocolate(5, 4, 9));
	}
}
