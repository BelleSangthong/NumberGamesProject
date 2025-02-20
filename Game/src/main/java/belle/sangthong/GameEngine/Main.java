package belle.sangthong.GameEngine;

import belle.sangthong.GameEngine.GuessNumber.GuessNumber;

public class Main {
    public static void main(String[] args) {
//        GameController game = new GameController(new SimpleWindow("Moo"),new GameLogic(), new DatabaseImpl());
//        game.run();

        GameController gameG = new GameController(new SimpleWindow("Guess the number"),new GuessNumber(), new DatabaseImpl());
        gameG.run();
    }
}