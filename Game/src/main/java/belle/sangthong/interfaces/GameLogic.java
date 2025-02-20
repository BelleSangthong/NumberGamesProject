package belle.sangthong.interfaces;

public interface GameLogic {
    String makeGoal();
    String generateFeedback(String goal, String guess);

    boolean isWinningFeedback(String feedback);
}
