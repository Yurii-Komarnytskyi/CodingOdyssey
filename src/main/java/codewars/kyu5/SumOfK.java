package codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class SumOfK { // NEEDS SOME POLISH

	// https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa/train/java

	private static List<int[]> allPossibleTownsCombinations = new ArrayList<>();

	public static Integer chooseBestSum(int maxDistanceCovered, int townsToVisit, List<Integer> distancesBetweenTowns) {
		if (distancesBetweenTowns.size() < townsToVisit) {
			return null;
		}
		combinations(distancesBetweenTowns, townsToVisit, 0, new int[townsToVisit]);
		OptionalInt result = allPossibleTownsCombinations.stream()
				.mapToInt(townCombinations -> Arrays.stream(townCombinations).sum())
				.filter(distanceToCover -> distanceToCover <= maxDistanceCovered).max();
		return (result.isPresent()) ? result.getAsInt() : null;
	}

	static void combinations(List<Integer> distancesBetweenTowns, int townsToVisit, int startPosition, int[] result) {
		if (townsToVisit == 0) {
			String resultToString = Arrays.toString(result);
			allPossibleTownsCombinations
					.add(Arrays.stream(resultToString.substring(1, resultToString.length() - 1).split(", "))
							.mapToInt(Integer::valueOf).toArray());
			return;
		}
		for (int i = startPosition; i <= distancesBetweenTowns.size() - townsToVisit; i++) {
			result[result.length - townsToVisit] = distancesBetweenTowns.get(i);
			combinations(distancesBetweenTowns, townsToVisit - 1, i + 1, result);
		}
	}
}