package kyu5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codewars.kyu5.WeightSort;

class WeightSortTest {
	@Test
	void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
		assertEquals("100 180 90 56 65 74 68 86 99", WeightSort.orderWeight("56 65 74 100 99 68 86 180 90"));
		assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}
}
