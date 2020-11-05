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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohamed
 */
@Repository
public class GameRoomServiceDB implements GameRoomService {

    GameDao gameDao;
    RoundDao roundDao;

    public GameRoomServiceDB() {
    }

    public GameRoomServiceDB(GameDao gameDao, RoundDao roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }

    @Override
    public Game addGame(Game game) {
        gameDao.addGame(game);
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        String result = "";
        for (int i = 0; i < 4; i++) {
            result += numbers.get(i).toString();
        }
        game.setCorrectAnswerKey(result);
        updateStatus(game);
        return game;
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = gameDao.getGameById(gameId);
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAllGames();
        return games;
    }

    @Override
    public Game updateStatus(Game game) {
        gameDao.updateStatus(game);
        
        if(game.getCorrectAnswerKey().equals(game.getRound().getUserGuessKey())){
            game.setGameStatus(true);
        }
        return game;
    }

    @Override
    public List<Round> getRoundsById(int roundId) {
        List<Round> rounds = roundDao.getRoundsById(roundId);
        return rounds;
    }

    @Override
    public Round addRound(Round round) {
        round = roundDao.addRound(round);
        return round;
     }
}
