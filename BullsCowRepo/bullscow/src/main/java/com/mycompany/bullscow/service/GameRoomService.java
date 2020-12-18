/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.service;

import com.mycompany.bullscow.entity.Game;
import com.mycompany.bullscow.entity.Round;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public interface GameRoomService {

    Game addGame(Game game);

    Game getGameById(int gameId);

    List<Game> getAllGames();

 

    List<Round> getRoundsById(int roundId);

    Round addRound(String userGuessKey, int gameId);

    Round getResults(String userGuessKey, int gameId);
}
