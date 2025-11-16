package codewars.kyu6;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class TheTrainDriver {
	// https://www.codewars.com/kata/66461f89e569d45b0f07116d/train/java

	private static final String DAY_OFF = "The Train Driver has the day off";
	private static final String SKYPORT = "Skyport";
	
	private static Map<String, Duration> availableRoutes = Map.of(
			"Skyport-Crystalium", Duration.ofHours(2).plusMinutes(15),
			"Crystalium-Skyport", Duration.ofHours(2).plusMinutes(10), 
			"Skyport-Oasis", Duration.ofHours(3).plusMinutes(20), 
			"Oasis-Skyport", Duration.ofHours(3).plusMinutes(15),
			"Oasis-Crystalium", Duration.ofHours(1).plusMinutes(45), 
			"Crystalium-Oasis", Duration.ofHours(1).plusMinutes(40), 
			"Skyport-Nexus", Duration.ofHours(4).plusMinutes(15), 
			"Nexus-Skyport", Duration.ofHours(4).plusMinutes(10)
	);
	
	private static String constructRoute(String origin, String destination) {
		return "%s-%s".formatted(origin, destination);
	}

	public static String arrivalTime(final String[] routes, final String departureTime) {
		if (routes.length == 0) {
			return DAY_OFF; 
		}
		LocalTime arrivedAt = LocalTime.parse(departureTime);
		String lastKnownLocation = SKYPORT; 

		for (String route : routes) {
			String key = constructRoute(lastKnownLocation, route);
			if (route.equals(lastKnownLocation)) { 
				arrivedAt = arrivedAt.plusHours(1);
				continue;
			} else if (availableRoutes.containsKey(key)) {
				arrivedAt = arrivedAt.plus(availableRoutes.get(key));
			} else {
				arrivedAt = arrivedAt.plus(availableRoutes.get(constructRoute(lastKnownLocation, SKYPORT)));
				arrivedAt = arrivedAt.plus(availableRoutes.get(constructRoute(SKYPORT, route)));
			}
			lastKnownLocation = route;
		}

		return DateTimeFormatter.ofPattern("HH:mm").format(arrivedAt);
	}
}