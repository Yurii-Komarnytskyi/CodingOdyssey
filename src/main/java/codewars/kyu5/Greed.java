package codewars.kyu5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Greed is a dice game played with five six-sided dice. Your mission is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
//Three 1's => 1000 points
//Three 6's =>  600 points
//Three 5's =>  500 points
//Three 4's =>  400 points
//Three 3's =>  300 points
//Three 2's =>  200 points
//One   1   =>  100 points
//One   5   =>   50 point
//A single dice can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
//Example scoring
//Throw       Score
//---------   ------------------
//5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
//1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
//2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
//In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.

public class Greed {
	// https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java

	private final static Map<Integer, Integer> TRIPLETS = Map.of(1, 1000, 6, 600, 5, 500, 4, 400, 3, 300, 2, 200);
	private final static Map<Integer, Integer> SINGLE_DICE_VALUES = Map.of(1, 100, 5, 50);

	public static int greedy(int[] diceArray) {
		List<Integer> diceArrayCopy = Arrays.stream(diceArray).boxed().collect(Collectors.toList());
		Map<Integer, Long> diceOccuranceStats = diceArrayCopy.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return (int) diceOccuranceStats.entrySet().stream()
				.filter(entry -> entry.getValue() >= 3 || entry.getKey() == 1 || entry.getKey() == 5)
				.mapToInt(entry -> {
					long numberOfOccurances = entry.getValue();
					Integer diceNumber = entry.getKey();
					boolean isDiceEither5Or1 = diceNumber == 1 || diceNumber == 5; 
					if (numberOfOccurances >= 3) {
						return (int) (TRIPLETS.get(diceNumber)
								+ ((isDiceEither5Or1)
										? SINGLE_DICE_VALUES.get(diceNumber) * (numberOfOccurances - 3)
										: 0));
					} else {
						return (int) ((isDiceEither5Or1)? numberOfOccurances * SINGLE_DICE_VALUES.get(diceNumber) : 0);
					}
				}).sum();
	}
}
