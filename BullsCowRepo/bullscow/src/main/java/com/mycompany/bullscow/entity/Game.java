/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mohamed
 */
public class Game {

    private int gameId;
    private String correctAnswerKey;
    private Boolean gameStatus;
    private List<Round> round;

    public Game (){
        
    }
    
     public Game (String correctAnswerKey, Boolean gameStatus, List<Round> round){
         this.correctAnswerKey = correctAnswerKey;
         this.gameStatus = gameStatus;
         this.round = round;
    }
     
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getCorrectAnswerKey() {
        return correctAnswerKey;
    }

    public void setCorrectAnswerKey(String correctAnswerKey) {
        this.correctAnswerKey = correctAnswerKey;
    }

    public Boolean getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Round> getRound() {
        return round;
    }

    public void setRound(List<Round> round) {
        this.round = round;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.gameId;
        hash = 83 * hash + Objects.hashCode(this.correctAnswerKey);
        hash = 83 * hash + Objects.hashCode(this.gameStatus);
        hash = 83 * hash + Objects.hashCode(this.round);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.correctAnswerKey, other.correctAnswerKey)) {
            return false;
        }
        if (!Objects.equals(this.gameStatus, other.gameStatus)) {
            return false;
        }
        if (!Objects.equals(this.round, other.round)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", correctAnswerKey=" + correctAnswerKey + ", gameStatus=" + gameStatus + ", round=" + round + '}';
    }

  

  

}
