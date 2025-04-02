package kyu5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Brainfuck {
	// https://www.codewars.com/kata/526156943dfe7ce06200063e/train/java

	private static final short MAX_VAL_IN_MEMORY_TAPE = 255;
	private static final short MIN_VAL_IN_MEMORY_TAPE = 0;
	private static final char INCREMENT_DATA_POINTER = '>';
	private static final char DECREMENT_DATA_POINTER = '<';
	private static final char INCREMENT_VAL_AT_DATA_POINTER = '+';
	private static final char DECREMENT_VAL_AT_DATA_POINTER = '-';
	private static final char OUTPUT_VAL_AT_DATA_POINTER = '.';
	private static final char ACCEPT_VAL_AT_DATA_POINTER = ',';
	private static final char ZERO_JUMP_FORWARD_TO_NEXT_CLOSING_BRACE = '[';
	private static final char NON_ZERO_JUMP_BACKWARD_TO_PREVIOUS_OPENING_BRACE = ']';

	private String commands;
	private StringBuilder output = new StringBuilder();
	private short[] memoryTape = new short[4000];
	private char[] inputAsCharArray;
	private int[] openCloseBracketMatches;
	private int dataPointer = 0;
	private int inputIndex = 0;
	private Integer instructionIndex = 0;

	public Brainfuck(String code) {
		commands = code;
	}

	public String process(String input) {
		try {
			if (Objects.nonNull(input)) {
				inputAsCharArray = input.toCharArray();
				initializeBracketMatches(commands);
				runInstructionsLoop();
				return output.toString();
			} else {
				return input;
			}

		} finally {
			output = new StringBuilder();
			commands = null;
			inputAsCharArray = null;
			dataPointer = 0;
			inputIndex = 0;
			instructionIndex = 0;
		}
	}

	private void runInstructionsLoop() {
		for (; instructionIndex < commands.length(); instructionIndex++) {
			executeInstruction(commands.charAt(instructionIndex));
		}
	}

	private void executeInstruction(char instruction) {
		switch (instruction) {
		case INCREMENT_DATA_POINTER -> {
			dataPointer++;
		}
		case DECREMENT_DATA_POINTER -> {
			dataPointer--;
		}
		case INCREMENT_VAL_AT_DATA_POINTER -> {
			memoryTape[dataPointer] = (memoryTape[dataPointer] == MAX_VAL_IN_MEMORY_TAPE) ? MIN_VAL_IN_MEMORY_TAPE
					: ++memoryTape[dataPointer];
		}
		case DECREMENT_VAL_AT_DATA_POINTER -> {
			memoryTape[dataPointer] = (memoryTape[dataPointer] == MIN_VAL_IN_MEMORY_TAPE) ? MAX_VAL_IN_MEMORY_TAPE
					: --memoryTape[dataPointer];
		}
		case OUTPUT_VAL_AT_DATA_POINTER -> {
			output.append((char) memoryTape[dataPointer]);
		}
		case ACCEPT_VAL_AT_DATA_POINTER -> {
			memoryTape[dataPointer] = (short) inputAsCharArray[inputIndex];
			inputIndex++;
		}
		case ZERO_JUMP_FORWARD_TO_NEXT_CLOSING_BRACE, NON_ZERO_JUMP_BACKWARD_TO_PREVIOUS_OPENING_BRACE -> {
			instructionIndex = openCloseBracketMatches[instructionIndex];
		}
		}

	}

	private void initializeBracketMatches(String input) {
		openCloseBracketMatches = new int[input.length()];
		Deque<Integer> deck = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '[') {
				deck.push(i);
			} else if (c == ']' && !deck.isEmpty()) {
				int openIndex = deck.pop();
				openCloseBracketMatches[openIndex] = i;
				openCloseBracketMatches[i] = openIndex;
			}
		}
	}
}
