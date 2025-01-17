/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 12/20/2023
 *https://leetcode.com/problems/number-of-substrings-with-only-1s/
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * @author parth
 */
public class NumberofSubstringswithonly1s {
     public static long MOD = 1000_000_007;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(numSub("1110111111"));
    }
    public static int numSub(String s){
       int result = 0; int count = 0;
       int index = 0;
       while(index < s.length()){
           if(s.charAt(index) == '1'){
               count++;
           }else{
               //Result the count variable to 0;
              count = 0;
           }
           index++;
           result = (int) ((result + count)% MOD);

       }
         return result;
        
    }
   
}
