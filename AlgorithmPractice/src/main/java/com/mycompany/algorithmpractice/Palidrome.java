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
public class Palidrome {

    public static void main(String[] args) {
        String magicWord = "racecar";

        System.out.println(check(magicWord));
    }

    public static boolean check(String xWord) {
        boolean check;
        String reversedWord = "";
        for (int i = xWord.length() - 1; i >= 0; i--) {
            reversedWord += xWord.charAt(i);
        }
        if (xWord.equals(reversedWord)) {
            check = true;
        } else {
            check = false;
      
        }
        return check;
    } 
}
