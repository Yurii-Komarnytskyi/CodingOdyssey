package kyu5;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import codewars.kyu5.Brainfuck;

class BrainfuckTest {
	
	@Test
    void testEchoUntilByte255Encountered() {
        assertThat(new Brainfuck(",+[-.,+]").process("Codewars" + ((char) 255)), is("Codewars"));
    }

    @Test
    void testEchoUntilByte0Encountered() {
        assertThat(new Brainfuck(",[.[-],]").process("Codewars" + ((char) 0)), is("Codewars"));
    }

    @Test
    void testTwoNumbersMultiplier() {
        final char[] input = {8, 9};
        assertThat(new Brainfuck(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.").process(String.valueOf(input[0]) + String.valueOf(input[1])), is(String.valueOf((char) (input[0] * input[1]))));
    }
}
