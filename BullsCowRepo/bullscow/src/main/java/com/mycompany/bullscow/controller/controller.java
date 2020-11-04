/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.controller;

import com.mycompany.bullscow.DAO.GameDao;
import com.mycompany.bullscow.DAO.GameDaoDB;
import com.mycompany.bullscow.entity.Game;
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
    
    private final GameDao dao;

    public controller(GameDao dao) {
        this.dao = dao;
    }

    Game game = new Game();

    @PostMapping
    public Game all() {
        game.setCorrectAnswerKey("0123");
        game.setGameStatus(false);
        System.out.println(dao.addGame(game));
        return game;
    }

    @GetMapping
    public String hi() {
        return "hi";
    }
}
