/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

import com.mycompany.bullscow.entity.Game;
import com.mycompany.bullscow.entity.Round;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Mohamed
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameDaoDBTest {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    RoundDaoDB roundDao;

    @Autowired
    GameDaoDB gameDao;

    public GameDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            int gameId = game.getGameId();
            final String DELETE_GAMEROUND= "DELETE FROM round "
                    + "WHERE gameId = ?";
            jdbc.update(DELETE_GAMEROUND, gameId);

            final String DELETE_GAME = "DELETE FROM game WHERE gameId = ?";
            jdbc.update(DELETE_GAME, gameId);

        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class GameDaoDB.
     */
    @Test
    public void testAddGame() {
        List<Round> round = new ArrayList();
        Game game = new Game("1234", false, round);
        game = gameDao.addGame(game);

        Game storedGame = gameDao.addGame(game);

        assertEquals(game, storedGame);

    }

    /**
     * Test of getGameById method, of class GameDaoDB.
     */
    @Test
    public void testGetGameById() {
        List<Round> round = new ArrayList();
        Game game = new Game("1234", false, round);
        game.setGameId(0);
        game = gameDao.addGame(game);

        Game storedGame = gameDao.getGameById(game.getGameId());

        assertEquals(game, storedGame);

    }

    /**
     * Test of getAllGames method, of class GameDaoDB.
     */
    @Test
    public void testGetAllGames() {
        List<Round> round = new ArrayList();
        Game game = new Game("1234", false, round);

        game.setGameId(0);
        game = gameDao.addGame(game);

        Game gameTwo = new Game("1234", false, round);
        gameTwo.setGameId(1);
        gameTwo = gameDao.addGame(game);

        List<Game> games = gameDao.getAllGames();

        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(gameTwo));

    }

    /**
     * Test of updateStatus method, of class GameDaoDB.
     */
    @Test
    public void testUpdateStatus() {
        List<Round> round = new ArrayList();
        Game game = new Game("1234", false, round);

        game.setGameId(0);
        game = gameDao.addGame(game);
       
        Game fromDao = gameDao.getGameById(game.getGameId());
        fromDao.setGameStatus(true);
        gameDao.updateStatus(fromDao);
        
        assertNotEquals(game, fromDao);
        
        assertEquals(fromDao.getGameStatus(), true);
    }

}
