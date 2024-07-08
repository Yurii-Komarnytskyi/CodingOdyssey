package kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TheSupermarketQueue {
	// https://www.codewars.com/kata/57b06f90e298a7b53d000a86/train/java
	
	public static int solveSuperMarketQueue(int[] customers, int n) {
		if (n == 1 || customers.length == 0) {
			return Arrays.stream(customers).sum();
		}
		List<Integer> registers = Arrays.stream(new int[n]).mapToObj(Integer::valueOf).collect(Collectors.toList());
		for (int nextCustomer : customers) {
			int availableRegister = registers.indexOf(registers.stream().mapToInt(Integer::intValue).min().getAsInt());
			registers.set(availableRegister, registers.get(availableRegister) + nextCustomer);
		}
		System.out.println(registers);
		return registers.stream().mapToInt(Integer::intValue).max().getAsInt();
	}
}
