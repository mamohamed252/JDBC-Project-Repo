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
import com.mycompany.bullscow.service.GameRoomServiceDB;
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
@RequestMapping("/api/todo")
public class controller {
//comment
   //comment2

    public GameRoomServiceDB service;
    
@Autowired
    public controller(GameRoomServiceDB service) {
        this.service = service;
    }

    Game game = new Game();

    @PostMapping
    public Game all() {
        game.setCorrectAnswerKey("0123");
        game.setGameStatus(false);
        System.out.println(service.addGame(game));
        return game;
    }

    @GetMapping
    public String hi() {
        return "hi";
    }
}
