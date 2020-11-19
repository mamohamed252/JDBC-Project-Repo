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
        addRound(game.getRound());
        updateStatus(game);
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
    public Game updateStatus(Game game) {
        gameDao.updateStatus(game);

        if (game.getCorrectAnswerKey().equals(game.getRound().getUserGuessKey())) {
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
        //round = ;
        round = roundDao.addRound(round);
        return round;
    }

    @Override
    public Round getResults(Game game) {

        Round round = game.getRound();

        String guessPart1 = game.getCorrectAnswerKey().substring(0, 1);
        String guessPart2 = game.getCorrectAnswerKey().substring(1, 2);
        String guessPart3 = game.getCorrectAnswerKey().substring(2, 3);
        String guessPart4 = game.getCorrectAnswerKey().substring(3, 4);

        String roundPart1 = round.getUserGuessKey().substring(0, 1);
        String roundPart2 = round.getUserGuessKey().substring(1, 2);
        String roundPart3 = round.getUserGuessKey().substring(2, 3);
        String roundPart4 = round.getUserGuessKey().substring(3, 4);

        String[] randomNumber = {guessPart1, guessPart2, guessPart3, guessPart4};
        String[] userPerdiction = {roundPart1, roundPart2, roundPart3, roundPart4};

        int exactCounter = 0;
        int partialCounter = 0;

        for (int i = 0; i < randomNumber.length; i++) {
            for (int j = 0; j < userPerdiction.length; j++) {
                if (randomNumber[i].equals(userPerdiction[i])) {
                    exactCounter++;

                } else if (randomNumber[i].equals(userPerdiction[j])) {
                    partialCounter++;

                }
            }
        }
        round.setGuessResultExact("e: " + exactCounter++);
        round.setGuessResultPartial("p: " + partialCounter++);

        return game.getRound();
    }
}
