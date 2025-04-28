package codingbat.map2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.IntStream.*;


public class MapTwo {
	public Map<String, Integer> word0(String[] strings) {
		Map<String, Integer> result = new HashMap<>();
		for (String s : strings)
			result.put(s, 0);
		return result;
	}

	public Map<String, Integer> wordLen(String[] strings) {
		Map<String, Integer> result = new HashMap<>();
		for (String s : strings)
			result.put(s, s.length());
		return result;
	}

	public Map<String, String> pairs(String[] strings) {
		Map<String, String> result = new HashMap<>();
		for (String s : strings)
			result.put(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(s.length() - 1)));
		return result;
	}

	public Map<String, Integer> wordCount(String[] strings) {
		Map<String, Integer> result = new HashMap<>();
		for (String s : strings) {
			result.computeIfPresent(s, (k, v) -> v = v + 1);
			result.computeIfAbsent(s, (k) -> 1);
		}
		return result;
	}

	public Map<String, String> firstChar(String[] strings) {
		Map<String, String> result = new HashMap<>();
		if (strings.length == 0)
			return result;
		Set<String> setOfKeys = new LinkedHashSet<>(Arrays.asList(strings));
		setOfKeys = setOfKeys.stream().map((v) -> v = String.valueOf(v.charAt(0))).collect(Collectors.toSet());
		for (String s : strings) {
			result.computeIfPresent(String.valueOf(s.charAt(0)), (k, v) -> v.concat(s));
			result.computeIfAbsent(String.valueOf(s.charAt(0)), (k) -> s);
		}
		return result;
	}

	public String wordAppend(String[] strings) {
		Map<String, Integer> theMap = new LinkedHashMap<>();
		StringBuilder result = new StringBuilder();
		for (String s : strings) {
			theMap.computeIfPresent(s, (k, v) -> v + 1);
			theMap.computeIfAbsent(s, (k) -> 1);
			if (theMap.get(s) % 2 == 0)
				result.append(s);
		}
		return result.toString();
	}

	public Map<String, Boolean> wordMultiple(String[] strings) {
		Map<String, Boolean> result = new HashMap<>();
		if (strings.length == 0)
			return result;
		Map<String, Integer> counterMap = new HashMap<>();
		for (String s : strings) {
			counterMap.computeIfPresent(s, (k, v) -> v = v + 1);
			counterMap.computeIfAbsent(s, (k) -> 1);
		}
		for (String s : counterMap.keySet())
			result.put(s, (counterMap.get(s) >= 2) ? true : false);
		return result;
	}

	public String[] allSwap(String[] strings) {
		String[] result = new String[strings.length];
		Map<String, Integer> daMap = new HashMap<>();
		range(0, strings.length).forEach(n -> {
			String key = String.valueOf(strings[n].charAt(0));
			if (daMap.containsKey(key)) {
				result[daMap.get(key)] = strings[n];
				result[n] = strings[daMap.get(key)];
				daMap.remove(key);
			} else {
				result[n] = strings[n];
				daMap.computeIfAbsent(key, (v) -> n);
			}
		});
		return result;
	}
	public String[] firstSwap(String[] strings) {
		String[] result = new String[strings.length];
		Map<String, Integer> daMap = new HashMap<>();
		range(0, strings.length).forEach(n -> {
			String key = String.valueOf(strings[n].charAt(0));
			daMap.computeIfAbsent(key, (v) -> n);
			if(daMap.get(key) != -1 && daMap.get(key) != n) {
				result[n] = strings[daMap.get(key)];
				result[daMap.get(key)] = strings[n];
				daMap.put(key, -1);
			} else result[n] = strings[n];			
		});
		return result;
	}


	public static void main(String[] args) {
		String[] t = { "list", "of", "words", "swims", "over", "lily", "water", "wait" };
		MapTwo mt = new MapTwo();
		System.out.println(Arrays.asList(mt.firstSwap(t)));
	}

}
