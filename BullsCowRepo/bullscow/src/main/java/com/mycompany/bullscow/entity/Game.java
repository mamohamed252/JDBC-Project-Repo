/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.entity;

import java.util.List;

/**
 *
 * @author Mohamed
 */
public class Game {

    private int gameId;
    private int correctAnswerKey;
    private Boolean gameStatus;
    private Round round;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getCorrectAnswerKey() {
        return correctAnswerKey;
    }

    public void setCorrectAnswerKey(int correctAnswerKey) {
        this.correctAnswerKey = correctAnswerKey;
    }

    public Boolean getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }


}
