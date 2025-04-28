package codingbat.functional1;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class FunctionalOne {
	
	public List<Integer> doubling(List<Integer> nums) {
		return nums.stream().map(n -> n *= 2).collect(Collectors.toList());
	}

	public List<Integer> square(List<Integer> nums) {
		return nums.stream().map(n -> n*= n).collect(Collectors.toList());
	}
	
	public List<String> addStar(List<String> strings) {
		return strings.stream().map(s -> s + "*").collect(Collectors.toList());
	}

	public List<String> copies3(List<String> strings) {
		UnaryOperator<String> trippleString = (str) -> {
			StringBuilder result = new StringBuilder();
			for(int i = 1; i <= 3; i++){
				result.append(str);
			}
			return result.toString();
		};
		return strings.stream().map(trippleString).collect(Collectors.toList());
	}

	public List<String> moreY(List<String> strings) {
		UnaryOperator<String> surroundWith_Y = (str) -> ("y" + str + "y");
		return strings.stream().map(surroundWith_Y).collect(Collectors.toList());
	}

	public List<Integer> math1(List<Integer> nums) {
		return nums.stream().map(n -> n = (n + 1) * 10).collect(Collectors.toList());
	}

	public List<Integer> rightDigit(List<Integer> nums) {
		return nums.stream().map(n -> n = n % 10).collect(Collectors.toList());
	}

	public List<String> lower(List<String> strings) {
		return strings.stream().map(String::toLowerCase).collect(Collectors.toList());
	}

	public List<String> noX(List<String> strings) {
		UnaryOperator<String> removeAll_X_letters = (str) -> {
			return str.replaceAll("x", "");
		};
		return strings.stream().map(removeAll_X_letters).collect(Collectors.toList());
	}



	public static void main(String[] args) {
		int[] dummyArray = {6, 8, 6, 8, -1};
		List<Integer> copyOfdummyArray = Arrays.stream(dummyArray).boxed().collect(Collectors.toList());
		FunctionalOne fo = new FunctionalOne();
		System.out.println(fo.doubling(copyOfdummyArray));
	}

}
