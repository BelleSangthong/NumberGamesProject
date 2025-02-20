package belle.sangthong.GameEngine.GuessNumber;

import belle.sangthong.interfaces.GameLogic;

public class GuessNumber implements GameLogic {

    public String makeGoal(){
        int goal = (int) (Math.random() * 100) + 1;
        return Integer.toString(goal);
    }

    public String generateFeedback(String goal, String guess) {
        int goalInt = Integer.parseInt(goal);
        int guessInt = Integer.parseInt(guess);
        if (goalInt == guessInt) {
            return "Correct!";
        } else if (goalInt < guessInt) {
            return "Too high!";
        } else {
            return "Too low!";
        }
    }

    @Override
    public boolean isWinningFeedback(String feedback) {
        return "Correct!".equals(feedback);
    }
}
