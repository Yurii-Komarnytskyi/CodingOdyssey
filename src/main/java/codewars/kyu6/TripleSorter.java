package codewars.kyu6;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TripleSorter {
	// https://www.codewars.com/kata/5829c2c8ef8d4474300000fa/train/java
	
	static Comparator<Student> taleUniversityGreats = (a, b) -> {
		int gpaDescendingComparison = Integer.compare(b.getGpa(), a.getGpa());
		int ageAscendingComparison = Integer.compare(a.getAge(), b.getAge());
		int lastNameAscendingComparison = 0;
		
		if( gpaDescendingComparison != 0) {
			return gpaDescendingComparison;
		}
		try {
			char aLastNameFirstLetter = a.getFullName().split(" ")[1].charAt(0);
			char bLastNameFirstLetter = b.getFullName().split(" ")[1].charAt(0);
			lastNameAscendingComparison = Character.compare(aLastNameFirstLetter, bLastNameFirstLetter);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} 
		
		return (lastNameAscendingComparison != 0) ? lastNameAscendingComparison : ageAscendingComparison;
	};
	
    public static String sort(List<Student> students) {
    	return students.stream()
    		.sorted(taleUniversityGreats)
    		.map(Student::getFullName)
    		.collect(Collectors.joining(","));
    }
}

record Student(int getAge, int getGpa, String getFullName) {
}