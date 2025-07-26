package codewars.kyu6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WhatCenturyIsItTest {

	 @Test
	    void testSomething() {
	      assertEquals("20th", WhatCenturyIsIt.whatCentury(1999));
	      assertEquals("21st", WhatCenturyIsIt.whatCentury(2011));
	      assertEquals("22nd", WhatCenturyIsIt.whatCentury(2154));
	      assertEquals("23rd", WhatCenturyIsIt.whatCentury(2259));
	    }
}
