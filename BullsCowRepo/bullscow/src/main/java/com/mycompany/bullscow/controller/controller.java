/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.controller;

import com.mycompany.bullscow.DAO.GameDao;
import com.mycompany.bullscow.DAO.GameDaoDB;
import com.mycompany.bullscow.DAO.RoundDao;
import com.mycompany.bullscow.entity.Game;
import com.mycompany.bullscow.entity.Round;
import com.mycompany.bullscow.service.GameRoomServiceDB;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohamed
 */
@RestController
@RequestMapping("/Game")
public class controller {

    public GameRoomServiceDB service;

    @Autowired
    public controller(GameRoomServiceDB service) {
        this.service = service;
    }

    Game game = new Game();

    @PostMapping
    public Game addGame() {
        Game newGame = service.addGame(game);
        return newGame;
    }

    @PostMapping("/playRound")
    public Round addRound(String userGuessKey, int gameId) {
        Round newRound = service.addRound(userGuessKey, gameId);
        return newRound;
    }

    @GetMapping("/getGameById")
    public Game addGameById(int gameId) {
        Game getGameId = service.getGameById(gameId);
        return getGameId;
    }

    @GetMapping("/getAllGames")
    public List<Game> addAllGames() {
        List<Game> getAllGames = service.getAllGames();
        return getAllGames;
    }

}
