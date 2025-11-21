package codewars.kyu4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static java.util.stream.Collectors.joining;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SnailTest {

	@Test
	void SnailTest1() {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] r = { 1, 2, 3, 6, 9, 8, 7, 4, 5 };
		test(array, r);
	}
	
	@Test
	void SnailTest4X4Array() {
		int[][] given = {
				{1, 2, 3, 9},
				{4, 5, 6, 4},
				{7, 8, 9, 1},
				{1, 2, 3, 4}
		};
		int[] expected = {1, 2, 3, 9, 4, 1, 4, 3, 2, 1, 7, 4, 5, 6, 9, 8};
		test(given, expected);
	}

	public String int2dToString(int[][] a) {
		return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
	}

	public void test(int[][] array, int[] result) {
		String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
		System.out.println(text);
		assertArrayEquals(result, Snail.snail(array));
	}
	
	

}
