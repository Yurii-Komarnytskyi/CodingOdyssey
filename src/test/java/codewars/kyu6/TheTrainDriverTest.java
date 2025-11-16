package codewars.kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TheTrainDriverTest {

	@Test
	void testSingleDestination() {
		String[] route = { "Crystalium" };
		String departureTime = "10:00";
		String expected = "12:15";
		String result = TheTrainDriver.arrivalTime(route, departureTime);
		String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
		assertEquals(expected, result, msg);
	}
 
	@Test
	void testMultipleDestinations() {
		String[] route = { "Crystalium", "Skyport", "Oasis" };
		String departureTime = "10:00";
		String expected = "17:45";
		String result = TheTrainDriver.arrivalTime(route, departureTime);
		String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
		assertEquals(expected, result, msg);
	}
 
	@Test
	void testDepartingFromMidnight() {
		String[] route = { "Nexus", "Skyport", "Oasis" };
		String departureTime = "21:30";
		String expected = "09:15";
		String result = TheTrainDriver.arrivalTime(route, departureTime);
		String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
		assertEquals(expected, result, msg);
	}
 
	@Test
	void testNoDestinations() {
		String[] route = {};
		String departureTime = "12:00";
		String expected = "The Train Driver has the day off";
		String result = TheTrainDriver.arrivalTime(route, departureTime);
		String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
		assertEquals(expected, result, msg);
	}

	
	@Test
	void testNoCrystal() {
		String[] route = {"Crystalium"};
		String departureTime = "10:00";
		String expected = "12:15";
		String result = TheTrainDriver.arrivalTime(route, departureTime);
		String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
		assertEquals(expected, result, msg);
	}
	
	@Test
	void testDuplicateCities() {
		String[] routes = new String[] {"Crystalium", "Crystalium", "Oasis", "Oasis"};
		String departure = "00:30";
		String expected = "06:25";
		String actual = TheTrainDriver.arrivalTime(routes, departure);
		assertEquals(expected, actual, "Input: " + Arrays.toString(routes) + ", " + departure);
		
	}
}
