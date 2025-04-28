package codingbat.map1;

import java.util.HashMap;
import java.util.Map;

public class MapOne {
	public Map<String, String> mapBully(Map<String, String> map) {
		if(map.containsKey("a")) {
			map.put("b", map.get("a"));
			map.put("a", "");
		}
		return map;
	}
	public Map<String, String> mapShare(Map<String, String> map) {
		if(map.containsKey("c")) map.remove("c", map.get("c"));
		if(map.containsKey("a")) map.put("b", map.get("a"));
		return map;
	}
	public Map<String, String> mapAB(Map<String, String> map) {
		if(map.containsKey("a") && map.containsKey("b")) map.put("ab", map.get("a") + map.get("b"));
		return map;
	}
	public Map<String, String> topping1(Map<String, String> map) {
		if(map.containsKey("ice cream")) map.put("ice cream",  "cherry");
		map.put("bread",  "butter");
		return map;
	}
	public Map<String, String> topping2(Map<String, String> map) {
		if(map.containsKey("ice cream")) map.put("yogurt", map.get("ice cream"));
		if(map.containsKey("spinach")) map.put("spinach",  "nuts");
		return map;
	}
	public Map<String, String> topping3(Map<String, String> map) {
		if(map.get("potato") != null) map.put("fries", map.get("potato"));
		if(map.get("salad") != null) map.put("spinach", map.get("salad"));
		
		return map;
	}
	public Map<String, String> mapAB2(Map<String, String> map) {
		String[] forbidden = {"a", "b"};
		if(map.containsKey(forbidden[0]) && map.containsKey(forbidden[1]) && map.get(forbidden[0]).equals(map.get(forbidden[1]))) {
			for(String s : forbidden) map.remove(s);
		}
		return map;
	}
	public Map<String, String> mapAB3(Map<String, String> map) {
		if(!map.containsKey("a") && map.containsKey("b")) map.put("a", map.get("b")); 
		if(!map.containsKey("b") && map.containsKey("a")) map.put("b", map.get("a")); 
		return map;  
	}
	public Map<String, String> mapAB4(Map<String, String> map) {
		if(!map.containsKey("a") || !map.containsKey("b")) return map;
		if(map.get("a").length() == map.get("b").length()) {
			map.put("a", "");
			map.put("b", "");
			return map;
		}
		map.put("c", (map.get("a").length() > map.get("b").length())? map.get("a") : map.get("b"));
		return map;
	}




	public static void main(String[] args) {

	}

}
