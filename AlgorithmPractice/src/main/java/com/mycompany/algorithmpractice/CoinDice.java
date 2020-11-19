/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algorithmpractice;

import java.util.Random;

/**
 *
 * @author Mohamed
 */
public class CoinDice {

    public static void main(String[] args) {
        Random r = new Random();

        System.out.println(CoinFlipMath(r));

    }

    public static int CoinFlipMath(Random r) {
        // single flip
        int coinFlip;
        int diceRoll = 0;
        int[] coinFlips = new int[3];
        for (int i = 0; i < coinFlips.length; i++) {
            coinFlip = r.nextInt(2);
            coinFlips[i] = coinFlip;
        }
        if (coinFlips[0] == 0 && coinFlips[1] == 0 && coinFlips[2] == 0) {
            diceRoll = 1;
        } else if (coinFlips[0] == 0 && coinFlips[1] == 0 && coinFlips[2] == 1 || coinFlips[0] == 0 && coinFlips[1] == 1 && coinFlips[2] == 0) {
            diceRoll = 2;

        } else if (coinFlips[0] == 0 && coinFlips[1] == 1 && coinFlips[2] == 1) {
            diceRoll = 3;
        } else if (coinFlips[0] == 1 && coinFlips[1] == 1 && coinFlips[2] == 1) {
            diceRoll = 4;
        } else if (coinFlips[0] == 1 && coinFlips[1] == 1 && coinFlips[2] == 0 || coinFlips[0] == 1 && coinFlips[1] == 0 && coinFlips[2] == 1) {
            diceRoll = 5;
        } else if (coinFlips[0] == 1 && coinFlips[1] == 0 && coinFlips[2] == 0) {
            diceRoll = 6;
        }
        return diceRoll;
    }

}
