package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NewCashierDoesNotKnowAboutSpaceOrShift {
	// https://www.codewars.com/kata/5d23d89906f92a00267bb83d/train/java

	private static List<String> menu = List.of("Burger", "Fries", "Chicken", "Pizza", "Sandwich", "Onionrings",
			"Milkshake", "Coke");

	public static String getOrder(String order) {
		List<String> orderItemsPresentInMenu = new ArrayList<>(
				menu.stream().filter(menuItem -> order.contains(menuItem.toLowerCase())).toList());
		return orderItemsPresentInMenu.stream().map(item -> {
			int qtyOfItemInTheOrder = (order.length()
					- Arrays.stream(order.split(item.toLowerCase())).collect(Collectors.joining()).length())
					/ item.length();
			return (qtyOfItemInTheOrder == 1) ? item
					: Collections.nCopies(qtyOfItemInTheOrder, item).stream().collect(Collectors.joining(" ")).trim();
		}).collect(Collectors.joining(" "));
	}
}