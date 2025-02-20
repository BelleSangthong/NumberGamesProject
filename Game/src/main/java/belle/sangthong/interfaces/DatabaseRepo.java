package belle.sangthong.interfaces;

import belle.sangthong.GameEngine.PlayerAverage;

import java.util.ArrayList;

public interface DatabaseRepo {

    int getIdByName(String name);
    void insertResult(int nGuess, int id);
    ArrayList<PlayerAverage> getTopTen();       //??

}
