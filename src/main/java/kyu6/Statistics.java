package kyu6;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Statistics {
	// https://www.codewars.com/kata/55b3425df71c1201a800009c/train/java

	public static String stat(String str) {
		if (str.isEmpty()) {
			return str;
		}
		List<Integer> raceResultsInSeconds = Arrays.stream(str.split(","))
				.mapToInt(Statistics::convertStringIntoSeconds).boxed().toList();

		String avarage = convertSecondsIntoResult(
				(int) raceResultsInSeconds.stream().mapToInt(Integer::intValue).average().getAsDouble());
		String range = convertSecondsIntoResult(
				raceResultsInSeconds.stream().mapToInt(Integer::intValue).max().getAsInt()
						- raceResultsInSeconds.stream().mapToInt(Integer::intValue).min().getAsInt());
		return String.format("Range: %s Average: %s Median: %s", range, avarage, getMedian(raceResultsInSeconds));
	}

	private static String getMedian(List<Integer> raceResults) {
		List<Integer> sorted = raceResults.stream().sorted().toList();
		if (raceResults.size() % 2 != 0) {
			return convertSecondsIntoResult(sorted.get((int) Math.ceil((double) (sorted.size() - 1) / 2)));
		}
		Integer median = (sorted.get((sorted.size() / 2) - 1) + sorted.get(sorted.size() / 2)) / 2;
		return convertSecondsIntoResult(median);
	}

	private static int convertStringIntoSeconds(String str) {
		List<String> strSeparated = Arrays.stream(str.split("\\|")).map(s -> s.trim()).toList();
		return (Integer.parseInt(strSeparated.get(0)) * 3600) + (Integer.parseInt(strSeparated.get(1)) * 60)
				+ Integer.parseInt(strSeparated.get(2));
	}

	private static String convertSecondsIntoResult(int seconds) {
		Duration duration = Duration.ofSeconds(seconds);
		Long hours = duration.toHours();
		Long minutes = duration.minusHours(duration.toHours()).toMinutes();
		Long secondsLeft = duration.minusMinutes(duration.toMinutes()).toSeconds();
		return String.format("%s|%s|%s", ((hours <= 9) ? "0" + hours : hours),
				((minutes <= 9) ? "0" + minutes : minutes), ((secondsLeft <= 9) ? "0" + secondsLeft : secondsLeft));
	}
}