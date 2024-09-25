package kyu5;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PeteBaker {
	// https://www.codewars.com/kata/525c65e51bf619685c000059/train/java

	public static int cakes(Map<String, Integer> recipe, Map<String, Integer> ingredients) {
		Map<String, Integer> subtractedIngredients = new HashMap<>(ingredients);
		boolean noMissingIngredients = true;
		int cakesBaked = 0;
		
		for(String key : recipe.keySet()) {
			if(!ingredients.containsKey(key)) {
				noMissingIngredients = false;
			}
		}

		while(true && noMissingIngredients) {
			subtractedIngredients = subtractedIngredients.entrySet()
				.stream()
				.filter((entry) -> recipe.containsKey(entry.getKey()))
				.map((entry) -> {
					entry.setValue(entry.getValue() - recipe.get(entry.getKey()));
					return entry; })
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			if(subtractedIngredients.entrySet().stream().noneMatch((entry) -> entry.getValue() < 0)){
				cakesBaked++;
			} else {
				break;
			}
		}
		
		return cakesBaked;
	  }
	
}
