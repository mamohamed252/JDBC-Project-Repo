/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

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
public class RoundDaoDBTest {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    RoundDaoDB roundDao;

    @Autowired
    GameDaoDB gameDao;

    public RoundDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Round> round = new ArrayList();
        Game game = new Game("1234", false, round);
        final String INSERT_GAME = "INSERT INTO game(CorrectAnswerKey, GameStatus) VALUES(?, ?)";
        jdbc.update(INSERT_GAME,
                game.getCorrectAnswerKey(),
                game.getGameStatus());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(newId);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRoundsById method, of class RoundDaoDB.
     */
    /**
     * Test of addRound method, of class RoundDaoDB.
     */
    @Test
    public void testAddRound() {
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        Game game = gameDao.getGameById(newId);
        Round round = new Round(LocalDateTime.now().withNano(0), "e: 1", "e: 0", "1234");
        Round firstRound = roundDao.addRound(round, game.getGameId());

        assertEquals(round, firstRound);

    }

    @Test
    public void testGetRoundsById() {
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        Game game = gameDao.getGameById(newId);

        Round round = new Round(LocalDateTime.now().withNano(0), "e: 1", "e: 0", "1234");
        Round firstRound = roundDao.addRound(round, game.getGameId());

        List<Round> getFirstRound = roundDao.getRoundsById(game.getGameId());

        assertEquals(getFirstRound.get(0), firstRound);
    }
}
