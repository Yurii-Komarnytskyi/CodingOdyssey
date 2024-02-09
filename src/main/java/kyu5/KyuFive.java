package kyu5;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

class SimpleEncryptionQwerty {
	// https://www.codewars.com/SimpleEncryptionQwerty/57f14afa5f2f226d7d0000f4/train/java

	private static Map<Integer, String> qwertyRows = Stream
			.of(new AbstractMap.SimpleEntry<>(0, "qwertyuiop"), new AbstractMap.SimpleEntry<>(1, "asdfghjkl"),
					new AbstractMap.SimpleEntry<>(2, "zxcvbnm,."))
			.collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

	private static Map<Integer, String> qwertyRowsShiftOn = Stream
			.of(new AbstractMap.SimpleEntry<>(0, "QWERTYUIOP"), new AbstractMap.SimpleEntry<>(1, "ASDFGHJKL"),
					new AbstractMap.SimpleEntry<>(2, "ZXCVBNM<>"))
			.collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

	public static String encrypt(String text, int key) {
		if (key == 0) {
			return text;
		}

		StringBuilder result = new StringBuilder();
		List<Integer> encryptionKeys = decryptRowKeys(key);
		IntStream.rangeClosed(0, text.length() - 1).forEach(i -> {
			String currentLetter = String.valueOf(text.charAt(i));
			if (currentLetter.isBlank()) {
				result.append(currentLetter);
			} else {
				Entry<Integer, String> rowEntry = findApropriateEntry(currentLetter);
				String row = rowEntry.getValue();
				char encryptedLetter = row.charAt(pickNextEncryptedIndex(row.indexOf(currentLetter),encryptionKeys.get(rowEntry.getKey()), row.length() - 1));
				result.append(encryptedLetter);
			}
		});
		return result.toString();
	}

	private static int pickNextEncryptedIndex(int qwertyIndex, int shiftToRight, int rowLength) {
		boolean overlap = (qwertyIndex + shiftToRight) > rowLength;
		if (overlap) {
			return ((qwertyIndex + shiftToRight) - rowLength) - 1;
		}
		return qwertyIndex + shiftToRight;
	}

	private static Entry<Integer, String> findApropriateEntry(String letter) {
		if (qwertyRows.values().stream().anyMatch(values -> values.contains(letter))) {
			return qwertyRows.entrySet().stream().filter(entry -> entry.getValue().contains(letter)).findFirst().get();
		} else {
			return qwertyRowsShiftOn.entrySet().stream().filter(entry -> entry.getValue().contains(letter)).findFirst()
					.get();
		}
	}

	public static String decrypt(String encryptedText, int key) {
		StringBuilder result = new StringBuilder();
		return result.toString();
	}

	private static List<Integer> decryptRowKeys(int key) {
		return Arrays.stream(String.valueOf(key).split("")).mapToInt(Integer::valueOf).boxed()
				.collect(Collectors.toList());
	}

}

public class KyuFive {
	@Test
    public void encryptExampleTests() {
        assertEquals("S", SimpleEncryptionQwerty.encrypt("A", 111));
        assertEquals("Smb", SimpleEncryptionQwerty.encrypt("Abc", 212));
        assertEquals("Wave", SimpleEncryptionQwerty.encrypt("Wave", 0)); // -> 000
        assertEquals("Tg.y", SimpleEncryptionQwerty.encrypt("Wave", 345));
        assertEquals(">fdd", SimpleEncryptionQwerty.encrypt("Ball", 134));
        assertEquals(">gff", SimpleEncryptionQwerty.encrypt("Ball", 444));
    
        assertEquals("Iaqh qh g iyhi,", SimpleEncryptionQwerty.encrypt("This is a test.", 348));
        assertEquals("Sr pgi jlpl Jr,lqlage Zlow Piapc I.skiaa dw. l.s ibnepizi.p ugi. de.se.f l arkwper.c", SimpleEncryptionQwerty.encrypt("Do the kata Kobayashi Maru Test. Endless fun and excitement when finding a solution.", 583));          
    }

	public static void main(String[] args) {
		System.out.println("Dick");
	}

}
