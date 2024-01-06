/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.com/problems/print-words-vertically/
 * Date: 12/19/2023
 * @author parth
 */
public class PrintWordsVertically {

  
    public static void main(String args[]) {
       String s = "CONTEST IS COMING";
       printVertically(s);
       
      
    }
    public static void printVertically(String s) {
        List<String> answer = new ArrayList<>();
        String[] words = s.split(" ");
        int max = 0;

        for (String word : words) {
            max = Math.max(max, word.length());
        }

        int pointer = 0;

        while (pointer < max) {
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                if (pointer < word.length()) {
                    result.append(word.charAt(pointer));
                } else {
                    result.append(' ');
                }
            }
            //The replaceAll("\\s+$", "") is used to remove trailing spaces from each result line
           answer.add(result.toString().replaceAll("\\s+$", ""));
           //answer.add(result.toString());
            pointer++;
        }
        

        System.out.println(answer);
    }
}
