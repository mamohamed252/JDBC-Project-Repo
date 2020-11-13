/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algorithmpractice;

import java.util.Arrays;

/**
 *
 * @author Mohamed
 */
public class Reversed {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3, 8, 7};
        System.out.println(Arrays.toString(reversedNum(nums)));
       
    }
// intake array
// print out array in reserved order

    public static int[] reversedNum(int[] xNumberArray) {
        int[] reversedArray = new int[xNumberArray.length];
        int startingPoint = 0;
        for (int i = xNumberArray.length-1; i >= 0; i--) {
            reversedArray[startingPoint] = xNumberArray[i];
            startingPoint++;
            // find the size of indexes
            // print the last index and continue to print last index - 1
           
        }
        return reversedArray;
    }
//    public static int[] reverse(int[] numArray) {
//        int[] reversedArray = new int[numArray.length];
//        int counter = numArray.length - 1;
//        for (int number : numArray) {
//            reversedArray[counter] = number;
//            counter--;
//        }
//        return reversedArray;
//    }
}
