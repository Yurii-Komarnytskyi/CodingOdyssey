package kyu6;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FindTheUnique {
//	https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java
	public static double findUniq(double arr[]) {
		Map<Double, Integer> occuranceCount = new HashMap<>();
		DoubleStream.of(arr).forEach(e -> {
			occuranceCount.computeIfPresent(e, (k, v) -> occuranceCount.get(e) + 1);
			occuranceCount.computeIfAbsent(e, (v) -> 1);
		});
		return DoubleStream.of(arr).filter(d -> {
			return occuranceCount.get(d) == 1;
		}).findFirst().orElse(-1);
	}

//	https://www.codewars.com/kata/585d8c8a28bc7403ea0000c3/train/javascript
//	thre's no Java language option, but I did it anyways
	static String findUniq(String[] arr) {
		Map<String, String> sortedStingsMapping = new HashMap<>();
		String[] arrSorted = Stream.of(arr).map(s -> {
			String t = Stream.of(s.trim().toLowerCase().split("")).sorted().collect(Collectors.joining());
			sortedStingsMapping.put(t, s);
			return t;
		}).sorted().toArray(s -> new String[s]);
		return sortedStingsMapping.get(arrSorted[arrSorted.length - 1]);
	}
}