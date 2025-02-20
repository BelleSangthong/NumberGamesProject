package belle.sangthong.GameEngine.GuessNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsGTest {

    GuessNumber gameG;

    @BeforeEach
    void setUp() {
        gameG = new GuessNumber();
    }

    @Test
    void testGenerateFeedback() {
        gameG.generateFeedback("50", "25");
        assertEquals("Too low!", gameG.generateFeedback("50", "25"));
        assertEquals("Too high!", gameG.generateFeedback("50", "75"));
        assertEquals("Correct!", gameG.generateFeedback("50", "50"));
    }

}