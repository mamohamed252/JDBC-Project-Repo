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
public class ReverseSentence {
    public static void main(String[] args) {
        String sentence = "Hello world! My name is Jose";
        System.out.println(reversedMethod(sentence));
    }
    
    public static String reversedMethod (String xSent){
      String[] split = xSent.split(" ");
      String completeSentece = "";
      
      for (int i = split.length -1 ; i >= 0; i--){
        completeSentece += split[i] + " ";
    }
      return completeSentece;
    }
 
}
