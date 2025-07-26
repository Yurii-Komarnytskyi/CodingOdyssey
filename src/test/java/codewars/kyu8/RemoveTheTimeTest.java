package codewars.kyu8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveTheTimeTest {

	@Test
    void sampleTests() {
       assertEquals("Friday May 2",RemoveTheTime.shortenToDate("Friday May 2, 9am"),"Failed for input: \"Friday May 2, 9am\"");
       assertEquals("Tuesday January 29",RemoveTheTime.shortenToDate("Tuesday January 29, 10pm"),"Failed for input: \"Tuesday January 29, 10pm\"");
       assertEquals("Monday December 25",RemoveTheTime.shortenToDate("Monday December 25, 10pm"),"Failed for input: \"Monday December 25, 10pm\"");
    }

}
