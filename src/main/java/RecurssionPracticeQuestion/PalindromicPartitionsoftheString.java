/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;

/**
 *https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
 * Date: 11/29/2023
 * @author parth
 */
public class PalindromicPartitionsoftheString {

    public static void main(String args[]) {
       String unprocessed = "nitin";
       palindromicPartitions("",unprocessed);
    }
    
    public static void palindromicPartitions(String processed,String unprocessed){
        if(unprocessed.length() == 0){
            System.out.println(processed);
            return;
        }
        for(int i = 0; i < unprocessed.length();i++){
            String prefix = unprocessed.substring(0,i+1);
            String remaining = unprocessed.substring(i+1);
            if(isPalindrome(prefix)){
                palindromicPartitions(processed +"(" + prefix + ")",remaining );
            }
        }
    }
    
    public static String reverse(String input){
        String reverse = "";
        for(int i = input.length()-1; i >= 0; i--){
            reverse = reverse + input.charAt(i);
        }
        return reverse;
    }
    public static boolean isPalindrome(String prefix){
        return prefix.equals(reverse(prefix));
    }
    
}
