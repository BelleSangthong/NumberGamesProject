package belle.sangthong.GameEngine;

import belle.sangthong.interfaces.DatabaseRepo;

import java.sql.*;
import java.util.ArrayList;


public class DatabaseImpl implements DatabaseRepo {
    static Connection connection;
    static Statement stmt;
    static ResultSet rs;

    public DatabaseImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Moo","root","losenord");
            stmt = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIdByName(String name) {
        try {
            rs = stmt.executeQuery("select id,name from players where name = '" + name + "'");
            if (rs.next()) {
                int id = rs.getInt("id");
                return id;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertResult(int nGuess, int id) {
        try {
            stmt.executeUpdate("INSERT INTO results " +
                    "(result, playerid) VALUES (" + nGuess + ", " +	id + ")" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<PlayerAverage> getTopTen() {
        try {
            ArrayList<PlayerAverage> topList = new ArrayList<>();
            Statement stmt2 = connection.createStatement();
            ResultSet rs2;
            rs = stmt.executeQuery("select * from players");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                rs2 = stmt2.executeQuery("select * from results where playerid = "+ id );
                int nGames = 0;
                int totalGuesses = 0;
                while (rs2.next()) {
                    nGames++;
                    totalGuesses += rs2.getInt("result");
                }
                if (nGames > 0) {
                    topList.add(new PlayerAverage(name, (double)totalGuesses/nGames));
                }
            }
            return topList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




