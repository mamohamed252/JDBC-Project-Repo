/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class Round {

    private int roundId;
    private LocalDateTime time;
    private String guessResultExact;
    private String guessResultPartial;
    private String userGuessKey;
    private List<Round> rounds;

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getGuessResultExact() {
        return guessResultExact;
    }

    public void setGuessResultExact(String guessResultExact) {
        this.guessResultExact = guessResultExact;
    }

    public String getGuessResultPartial() {
        return guessResultPartial;
    }

    public void setGuessResultPartial(String guessResultPartial) {
        this.guessResultPartial = guessResultPartial;
    }

    public String getUserGuessKey() {
        return userGuessKey;
    }

    public void setUserGuessKey(String userGuessKey) {
        this.userGuessKey = userGuessKey;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

}
