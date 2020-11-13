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
public class MatchingArrays {

    public static void main(String[] args) {
        String[] nums = {"5", "1", "7", "3"};
        String[] nums2 = {"5", "3", "7", "1"};
       
            System.out.print(compareArray(nums, nums2) + " These strings are exact match");
       
    }

    public static int compareArray(String[] xNumberArray, String[] yNumberArray2) {

        //!= not equal to
        int exact = 0;
        for (int i = 0; i < xNumberArray.length; i++) {
            for (int j = i; j < xNumberArray.length; j++) {
                if (xNumberArray[i] == yNumberArray2[i]) {
                    exact++;
                    break;
                }
            }

        }
        return exact;
    }
}
