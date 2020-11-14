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
public class getFib {

    public static void main(String[] args) {
        int lengthOfPointer = 2;
        System.out.println(fibMath(lengthOfPointer));
    }

    public static int fibMath(int userInput) {

        int startingPoint = 0;
        int nextPosition = 1;
        int sumOfSN = startingPoint + nextPosition;

        if (userInput == 0) {
            return 0;
        } else if (userInput == 1) {
            return 1;
        }

//        while (userInput > 1) {
//            sumOfSN = startingPoint + nextPosition;
//            counter = sumOfSN;
//            userInput;
//        }
        for (int i = 0; i < userInput-2; i++) {
            if (userInput > 1) {
                sumOfSN = startingPoint + nextPosition;
                startingPoint = nextPosition;
                nextPosition = sumOfSN;
            }

        }
        return sumOfSN;
    }
}
