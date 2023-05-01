import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class GameHelperTest {
	private static GameHelper testHelper = new GameHelper();
	@Test
	void checkLength() {
		assertTrue(testHelper.validateUserInput("a2"));
	}
	
	@Test
	void checkTooLong() {
		assertFalse(testHelper.validateUserInput("a12"));
	}
	
	@Test
	void checkTooShort() {
		assertFalse(testHelper.validateUserInput("a"));
	}
	
	@Test
	void checkWrongOrder() {
		assertFalse(testHelper.validateUserInput("2a"));
	}

}
