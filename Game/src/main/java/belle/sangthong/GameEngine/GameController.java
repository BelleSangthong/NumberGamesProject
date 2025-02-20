package belle.sangthong.GameEngine;

import belle.sangthong.GameEngine.BullsAndCows.BullsAndCows;
import belle.sangthong.interfaces.DatabaseRepo;
import belle.sangthong.interfaces.GameLogic;
import belle.sangthong.interfaces.TextIO;

import java.util.ArrayList;

public class GameController implements belle.sangthong.interfaces.GameController {
    private TextIO gw;
    private DatabaseRepo db;
    private GameLogic game;

    public GameController(TextIO gw, GameLogic game, DatabaseRepo db) {
        this.gw = gw;
        this.game = game;
        this.db = db;
    }

    public void run() {
        boolean answer = true;

        gw.addString("Enter your user name:\n");
        String name = gw.getString();
        int id = 0;

        if (db.getIdByName(name) != -1) {
            id = db.getIdByName(name);
        } else {
            gw.addString("User not in database, please register with admin");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gw.exit();
        }

        while (answer) {
            String goal = game.makeGoal();
            gw.clear();
            gw.addString("New game:\n");
            //comment out or remove next line to play real games!
            gw.addString("For practice, number is: " + goal + "\n");
            String guess = gw.getString();
            gw.addString(guess +"\n");
            int nGuess = 1;
            String feedback = game.generateFeedback(goal, guess);
            gw.addString(feedback + "\n");
            while (! game.isWinningFeedback(feedback)) {
                nGuess++;
                guess = gw.getString();
                gw.addString(guess +":\n");
                feedback = game.generateFeedback(goal, guess);
                gw.addString(feedback + "\n");
            }
            db.insertResult(nGuess, id);
            showTopTen();
            answer = gw.yesNo("Correct, it took " + nGuess
                    + " guesses\nContinue?");

        }
        gw.exit();
    }

    public void showTopTen() {
        ArrayList<PlayerAverage> topList = db.getTopTen();
        gw.addString("Top Ten List\n    Player     Average\n");
        int pos = 1;
        topList.sort((p1,p2)->(Double.compare(p1.average, p2.average)));
        for (PlayerAverage p : topList) {
            gw.addString(String.format("%3d %-10s%5.2f%n", pos, p.name, p.average));
            if (pos++ == 10) break;
        }
    }

}
