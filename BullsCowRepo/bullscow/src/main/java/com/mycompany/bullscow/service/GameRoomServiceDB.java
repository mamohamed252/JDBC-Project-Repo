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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohamed
 */
@Service
public class GameRoomServiceDB implements GameRoomService {

    GameDao gameDao;
    RoundDao roundDao;

    public GameRoomServiceDB() {
    }

    @Autowired
    public GameRoomServiceDB(GameDao gameDao, RoundDao roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }

    @Override
    public Game addGame(Game game) {

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
        game.setGameStatus(false);
        gameDao.addGame(game);
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
    public Game updateStatus(Game game, Round round) {
        gameDao.updateStatus(game);
// if round is played update the status to true
       String exactNumber = round.getGuessResultExact().substring(3);
        if (Integer.parseInt(exactNumber) == 4) {
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
    public Round addRound(String userGuessKey, int gameId) {
        Round newRound = getResults(userGuessKey, gameId);
        Round addedRound = roundDao.addRound(newRound, gameId);
        
        return addedRound;
    }

    @Override
    public Round getResults(String userGuessKey, int gameId) {
        Game game = getGameById(gameId);
        

        String guessPart1 = game.getCorrectAnswerKey().substring(0, 1);
        String guessPart2 = game.getCorrectAnswerKey().substring(1, 2);
        String guessPart3 = game.getCorrectAnswerKey().substring(2, 3);
        String guessPart4 = game.getCorrectAnswerKey().substring(3, 4);
        
        String roundPart1 = userGuessKey.substring(0, 1);
        String roundPart2 = userGuessKey.substring(1, 2);
        String roundPart3 = userGuessKey.substring(2, 3);
        String roundPart4 = userGuessKey.substring(3, 4);

        String[] randomNumber = {guessPart1, guessPart2, guessPart3, guessPart4};
        String[] userPerdiction = {roundPart1, roundPart2, roundPart3, roundPart4};

        int exactCounter = 0;
        int partialCounter = 0;

        for (int i = 0; i < randomNumber.length; i++) {
            for (int j = i; j < userPerdiction.length; j++) {
                if (randomNumber[i].equals(userPerdiction[j]) && i == j) {
                    exactCounter++;

                } else if (randomNumber[i].equals(userPerdiction[j]) && i != j) {
                    partialCounter++;

                }
            }
        }
        Round round = new Round();
        round.setGuessResultExact("e: " + exactCounter++);
        round.setGuessResultPartial("p: " + partialCounter++);
        round.setUserGuessKey(userGuessKey);
        round.setTime(LocalDateTime.now());
        
        Game updatedStatus = updateStatus(game, round);
        gameDao.updateStatus(updatedStatus);
        return round;
    }
}
