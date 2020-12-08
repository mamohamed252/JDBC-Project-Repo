/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

import com.mycompany.bullscow.entity.Game;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public interface GameDao {
    Game addGame(Game game);
    Game getGameById(int gameId);
    List<Game> getAllGames();
    void updateStatus(Game game);
    
}
