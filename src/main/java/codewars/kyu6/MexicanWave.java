package codewars.kyu6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MexicanWave {
	// https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/java
	
	public static String[] wave(String str) {
		List<String> waves = new ArrayList<>();
		IntStream.rangeClosed(0, str.length() - 1).forEach(wave -> {
			if (str.charAt(wave) != ' ') {
				StringBuilder currentWave = new StringBuilder(str);
				currentWave.setCharAt(wave, Character.toUpperCase(str.charAt(wave)));
				waves.add(currentWave.toString());
			}
		});
		return waves.toArray(new String[0]);
	}

}