package kyu6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SimpleEncryption1 {
	// https://www.codewars.com/kata/57814d79a56c88e3e0000786/train/java

		public static String encrypt(final String text, final int n) {
			if (!validateEncryptOrDecryptVal(text, n)) {
				return text;
			}
			StringBuilder result = new StringBuilder(text);
			for (int i = 0; i < n; i++) {
				result = oddIndexedFirstThenEqualIndexed(result);
			}
			return result.toString();
		}

		public static String decrypt(final String encryptedText, final int n) {
			if (!validateEncryptOrDecryptVal(encryptedText, n)) {
				return encryptedText;
			}
			StringBuilder result = new StringBuilder(encryptedText);
			for (int i = 0; i < n; i++) {
				result = decryptIndexes(result);
			}

			return result.toString();
		}

		private static boolean validateEncryptOrDecryptVal(String text, int n) {
			return (text != null && !text.isEmpty() && n > 0);
		}

		private static StringBuilder oddIndexedFirstThenEqualIndexed(StringBuilder text) {
			StringBuilder oddIndexed = new StringBuilder();
			StringBuilder evenIndexed = new StringBuilder();
			for (int i = 0; i < text.length(); i++) {
				if (i % 2 == 0) {
					evenIndexed.append(text.charAt(i));
				} else {
					oddIndexed.append(text.charAt(i));
				}
			}
			return oddIndexed.append(evenIndexed);
		}

		private static StringBuilder decryptIndexes(StringBuilder encryptedText) {
			int evenIndexedStartAt = encryptedText.length() / 2;
			StringBuilder result = new StringBuilder();
			Queue<String> wereOddIndexed = new LinkedList<>(
					Arrays.stream(encryptedText.subSequence(0, evenIndexedStartAt).toString().split(""))
							.collect(Collectors.toList()));
			Queue<String> wereEvenIndexed = new LinkedList<>(Arrays
					.stream(encryptedText.subSequence(evenIndexedStartAt, encryptedText.length()).toString().split(""))
					.collect(Collectors.toList()));
			for (int i = 0; i < encryptedText.length(); i++) {
				if (i % 2 == 0) {
					result.append(wereEvenIndexed.poll());
				} else {
					result.append(wereOddIndexed.poll());
				}
			}
			return result;
		}
	}