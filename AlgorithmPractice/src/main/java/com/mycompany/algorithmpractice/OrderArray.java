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
public class OrderArray {

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 1, 23, 12, 0, -5};
        System.out.println(Arrays.toString(sortArrayForward(nums)));
    }

    public static int[] sortArrayForward(int[] xNumberArray) {
        int[] greaterNumberChecker = new int[xNumberArray.length];
        int startingPoint = 0;
        for (int i = 0; i < xNumberArray.length-1; i++) {
            if (xNumberArray[i] < xNumberArray[i] && xNumberArray[i] < xNumberArray[i]) {
                greaterNumberChecker[startingPoint] = xNumberArray[i];
                startingPoint++;
            }
        }

        return greaterNumberChecker;
    }
}
