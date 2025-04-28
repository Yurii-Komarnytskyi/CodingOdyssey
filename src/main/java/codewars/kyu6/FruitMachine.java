package codewars.kyu6;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitMachine {
	// https://www.codewars.com/kata/590adadea658017d90000039/train/java
	
	private static final List<ReelItem> reels = List.of(new ReelItem("Wild", 100, 10, 0), new ReelItem("Star", 90, 9, 18),
			new ReelItem("Bell", 80, 8, 16), new ReelItem("Shell", 70, 7, 14), new ReelItem("Seven", 60, 6, 12),
			new ReelItem("Cherry", 50, 5, 10), new ReelItem("Bar", 40, 4, 8), new ReelItem("King", 30, 3, 6),
			new ReelItem("Queen", 20, 2, 4), new ReelItem("Jack", 10, 1, 2));
	private static final int NO_MATCHING_ITEMS = 0;
	private static final String WILD = "Wild";
	
	private static class ReelItem {
		
		private final String item;
		private final int threeOfTheSame;
		private final int twoOfTheSame;
		private final int twoOfTheSamePlusWild;
		
		public ReelItem(String sign, int threeOfTheSame, int twoOfTheSame, int twoOfTheSamePlusWild) {
			this.item = sign;
			this.threeOfTheSame = threeOfTheSame;
			this.twoOfTheSame = twoOfTheSame;
			this.twoOfTheSamePlusWild = twoOfTheSamePlusWild;
		}
		
		int getImageValue(int itemCount, boolean gotWildItem) {
			if(itemCount == 3) {
				return threeOfTheSame;
			} else if (itemCount == 2) {
				if(gotWildItem) {
					return twoOfTheSamePlusWild;
				}
				return twoOfTheSame;
			} else {
				return NO_MATCHING_ITEMS;
			}
		}
		
	}
	
    public static int fruit(final String[][] reelsArray, final int[] spins) {
		Map<String, Long> itemsStats = List
				.of(reelsArray[0][spins[0]], reelsArray[1][spins[1]], reelsArray[2][spins[2]]).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Optional<Entry<String, Long>> topItem = itemsStats.entrySet().stream().filter(entry -> entry.getValue() >= 2)
				.findAny();
		boolean gotWildItem = itemsStats.containsKey(WILD) && itemsStats.get(WILD) == 1 && itemsStats.containsValue(2L);
		if (topItem.isEmpty()) {
			return NO_MATCHING_ITEMS;
		}
		ReelItem reelItem = reels.stream()
				.filter(item -> item.item.equals(topItem.get().getKey()))
				.findFirst().get();
		return reelItem.getImageValue(topItem.get().getValue().intValue(), gotWildItem);
        
    }

}