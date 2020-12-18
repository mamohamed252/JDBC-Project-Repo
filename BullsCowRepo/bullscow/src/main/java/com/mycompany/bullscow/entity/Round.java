/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public Round() {

    }
    public Round(LocalDateTime time, String guessResultExact, String guessResultPartial, String userGuessKey) {
        this.time = time;
        this.guessResultExact = guessResultExact;
        this.guessResultPartial = guessResultPartial;
        this.userGuessKey = userGuessKey;
    }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.roundId;
        hash = 31 * hash + Objects.hashCode(this.time);
        hash = 31 * hash + Objects.hashCode(this.guessResultExact);
        hash = 31 * hash + Objects.hashCode(this.guessResultPartial);
        hash = 31 * hash + Objects.hashCode(this.userGuessKey);
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
        final Round other = (Round) obj;
        if (this.roundId != other.roundId) {
            return false;
        }
        if (!Objects.equals(this.guessResultExact, other.guessResultExact)) {
            return false;
        }
        if (!Objects.equals(this.guessResultPartial, other.guessResultPartial)) {
            return false;
        }
        if (!Objects.equals(this.userGuessKey, other.userGuessKey)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Round{" + "roundId=" + roundId + ", time=" + time + ", guessResultExact=" + guessResultExact + ", guessResultPartial=" + guessResultPartial + ", userGuessKey=" + userGuessKey + '}';
    }
    

}
