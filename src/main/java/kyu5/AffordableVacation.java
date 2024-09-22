package kyu5;

import java.util.Arrays;
import java.util.List;

// TODO optimize for Large random test 1

public class AffordableVacation {
	// https://www.codewars.com/kata/66871953e441f6da6e36a0cc/train/java

	public static String findMinCost(int money, int days, int[] cost) {

		List<Integer> costs = Arrays.stream(cost).boxed().toList();
		int moneyLeft = money;
		int minMoneySpent = findCheapestConsecutiveDays(days, costs);
		int maxDaysStayedAtAccommodation = 0;
		
		if(money >= minMoneySpent) {
			return String.format("money: %s", minMoneySpent);
		} else {
			for (int i = 0; i < days - 1 && moneyLeft >= 0; i++) {
				moneyLeft -= costs.get(i);
				maxDaysStayedAtAccommodation++;
			}
			return String.format("days: %s", maxDaysStayedAtAccommodation); 
		}
	}
	
	private static int findCheapestConsecutiveDays(int days, List<Integer> costs) {
		int cheapestConsecutiveDays = costs.stream().limit(days).reduce(0, (Integer::sum));
		int consecutiveDays = 0;
		
		if(costs.size() > days) {
			for (int i = 0; (i + days) <= costs.size(); i++) {
				consecutiveDays = costs.stream().skip(i).limit(days).reduce(0, Integer::sum);
				if (consecutiveDays < cheapestConsecutiveDays) {
					cheapestConsecutiveDays = consecutiveDays;
				} else {
					consecutiveDays = 0;
				}
				
			}
		}

		return cheapestConsecutiveDays;
	}

}