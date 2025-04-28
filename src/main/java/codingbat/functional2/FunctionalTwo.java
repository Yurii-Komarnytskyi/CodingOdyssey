package codingbat.functional2;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;


public class FunctionalTwo {

    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream().filter(n -> n >= 0).collect(Collectors.toList());
    }

    public List<Integer> no9(List<Integer> nums) {
        return nums.stream().filter(n -> n % 10 != 9).collect(Collectors.toList());
    }

    public List<Integer> noTeen(List<Integer> nums) {
        return nums.stream().filter(n -> n < 13 || n > 19).collect(Collectors.toList());
    }

    public List<String> noZ(List<String> strings) {
        return strings.stream().filter(str -> !str.contains("z")).collect(Collectors.toList());
    }


    public List<String> noLong(List<String> strings) {
        return strings.stream().filter(str -> str.length() < 4).collect(Collectors.toList());
    }

    public List<String> no34(List<String> strings) {
        return strings.stream().filter(str -> str.length() != 3 && str.length() != 4).collect(Collectors.toList());
    }

    public List<String> noYY(List<String> strings) {
        return strings.stream().map(str -> (str + "y")).filter(str -> !str.contains("yy")).collect(Collectors.toList());
    }
    
    public List<Integer> two2(List<Integer> nums) {
        return nums.stream().map(n -> n *= 2).filter(n -> n % 10 != 2).collect(Collectors.toList());
    }

    public List<Integer> square56(List<Integer> nums) {
        return nums.stream().map(n -> n * n + 10).filter(n -> n % 10 != 5 && n % 10 != 6).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int[] dummyArray = {6, 8, 6, 8, -1};
		List<Integer> copyOfdummyArray = Arrays.stream(dummyArray).boxed().collect(Collectors.toList());
		FunctionalTwo ft = new FunctionalTwo();
		System.out.println(ft.noNeg(copyOfdummyArray));
    }
}