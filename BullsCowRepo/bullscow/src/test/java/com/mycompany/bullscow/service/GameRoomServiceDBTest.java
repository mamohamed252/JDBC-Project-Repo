/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.service;

import com.mycompany.bullscow.DAO.GameDao;
import com.mycompany.bullscow.DAO.RoundDao;
import com.mycompany.bullscow.entity.Game;
import com.mycompany.bullscow.entity.Round;
import java.time.LocalDateTime;
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
public class GameRoomServiceDBTest {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;

    @Autowired
    GameRoomServiceDB GameRoomService;

    public GameRoomServiceDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        final String DELETE_ROUND = "DELETE FROM round";
        jdbc.update(DELETE_ROUND);

        final String DELETE_GAME = "DELETE FROM game";
        jdbc.update(DELETE_GAME);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class GameRoomServiceDB.
     */
    @Test
    public void testAddGame() {
        Game firstGame = new Game();

        Game addGameTest = GameRoomService.addGame(firstGame);
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        firstGame.setGameId(newId);

        assertEquals(addGameTest.getCorrectAnswerKey(), "****");
        assertTrue(addGameTest.getGameStatus().equals(false));

        assertEquals(firstGame, addGameTest);

    }

    /**
     * Test of getGameById method, of class GameRoomServiceDB.
     */
    @Test
    public void testGetGameById() {
        Game firstGame = new Game();

        Game addGameTest = GameRoomService.addGame(firstGame);
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        firstGame.setGameId(newId);

        assertEquals(firstGame, addGameTest);
    }

    /**
     * Test of getAllGames method, of class GameRoomServiceDB.
     */
    @Test
    public void testGetAllGames() {
        Game firstGame = new Game();

        Game addGameTest = GameRoomService.addGame(firstGame);

        Game secondGame = new Game();

        Game addGameTestTwo = GameRoomService.addGame(secondGame);

        List<Game> games = GameRoomService.getAllGames();

        for (Game game : games) {
            assertEquals(game.getCorrectAnswerKey(), "****");
            assertTrue(game.getGameStatus().equals(false));
        }

        //assertEquals(game.)
    }
  
    /**
     * Test of getResults method, of class GameRoomServiceDB.
     */
    @Test
    public void testGetResults() {
        String userGuess = "1234";
        
        List<Round> rounds = new ArrayList();
        
        Game game = new Game("1234", false, rounds);
        
        Game firstGame = gameDao.addGame(game);
        int gameId = firstGame.getGameId();
        
       Round round = GameRoomService.getResults(userGuess, gameId);
       LocalDateTime time = LocalDateTime.now().withNano(0);
        
        assertEquals(round.getTime(), time);
        assertEquals(round.getGuessResultExact(), "e: 4");
        assertEquals(round.getGuessResultPartial(), "p: 0");
        assertEquals(round.getUserGuessKey(), userGuess);
    }

}
