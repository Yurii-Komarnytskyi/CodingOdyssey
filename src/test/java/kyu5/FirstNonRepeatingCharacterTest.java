package kyu5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstNonRepeatingCharacterTest {
	@Test
	@DisplayName("Sample tests")
	void sampleTests() {
	      assertEquals("a", FirstNonRepeatingCharacter.firstNonRepeatingLetter("a"), "For input \"a\"");
	      assertEquals("t", FirstNonRepeatingCharacter.firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
	      assertEquals("t", FirstNonRepeatingCharacter.firstNonRepeatingLetter(">>treSS"), "For input \">>treSS\"");
	      assertEquals("-", FirstNonRepeatingCharacter.firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
	      assertEquals("", FirstNonRepeatingCharacter.firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
	    }

}
