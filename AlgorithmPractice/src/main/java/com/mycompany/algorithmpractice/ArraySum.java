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
public class ArraySum {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 12, 2, -1};
        System.out.println(sumArray(nums));

    }
    //method that takes in array of int
    // returns sum of ints

    public static int sumArray(int[] xNum) {
        int add = 0;
        for (int i = 0; i < xNum.length; i++) {
            add += xNum[i];

        }
        return add;
    }

}
