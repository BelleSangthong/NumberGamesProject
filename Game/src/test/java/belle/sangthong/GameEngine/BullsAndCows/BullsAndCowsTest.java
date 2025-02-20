package belle.sangthong.GameEngine.BullsAndCows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {

    BullsAndCows game;

    @BeforeEach
    void setUp() {
        game = new BullsAndCows();
    }

    @Test
    void testGenerateFeedback() {
        game.generateFeedback("6981", "1234");
        assertEquals(",C", game.generateFeedback("6981", "1234"));
        assertEquals(",CCC", game.generateFeedback("6981", "1069"));
        assertEquals("BBB,", game.generateFeedback("6981", "6985"));
        assertEquals("BBBB,", game.generateFeedback("6981", "6981"));
    }

    @Test
    void testGenerateFourDigitNumber() {
        assertEquals(4, game.makeGoal().length());
    }

    @Test
    void testNumberIsUnique() {
        String goal = game.makeGoal();
        for (int i = 0; i < goal.length(); i++) {
            for (int j = i + 1; j < goal.length(); j++) {
                assertNotEquals(goal.charAt(i), goal.charAt(j));
            }
        }

        System.out.println("Goal: " + goal);
    }
}