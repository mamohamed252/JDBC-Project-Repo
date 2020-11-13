/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algorithmpractice;

/**
 *
 * @author Mohamed
 */
public class ReversedWord {

    public static void main(String[] args) {
        String word = "Jose";
        System.out.println(reversedWord(word));
    }

    public static String reversedWord(String xWord) {

        char[] getWord = xWord.toCharArray();
        String reversedWord = "";
        for (int i = getWord.length - 1; i >= 0; i--) {
            reversedWord += getWord[i];
        }
        return reversedWord;
    }
}
