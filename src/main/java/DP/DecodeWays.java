/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 07/02/2024
 * https://leetcode.com/problems/decode-ways/
 * @author parth
 */
public class DecodeWays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(numDecodings("123"));
    }
    
    public static int numDecodings(String s){
         if(s.charAt(0)== '0'){
            return 0;
         }
         int[] dp = new int[s.length()];
        
        dp[0] = 1;
        
        for(int i = 1; i < s.length();i++){
            
            //Case 1 : When both the characters are zeros 
            if(s.charAt(i-1) == '0' && s.charAt(i) == '0'){
                dp[i] = 0;
            }
            //Case 2 : When i-1th character is zero and ith character is not zero
            else if(s.charAt(i-1) == '0' && s.charAt(i) != '0'){
                dp[i] = dp[i-1];
            }
            //Case 3 : When i-1th character is not zero and ith character is zero
            else if(s.charAt(i-1) != '0' && s.charAt(i) == '0'){
                //i.e. the number is less than equal to 26
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                  dp[i] = i >= 2 ? dp[i-2] : 1;  
                }else{
                    //i.e. the number is greater than 26
                    dp[i] = 0;
                }
            }
            //Case 4 : When the both the characters are not zeros
            else{
                if(Integer.valueOf(s.substring(i-1,i+1)) <= 26){
                    dp[i] = dp[i-1] + (i >= 2 ? dp[i-2] : 1);
                }else{
                    dp[i] = dp[i-1];
                }
                
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()-1];
    }
    
    
    public static int numDecodingsOptimized(String s) {
         if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: an empty string has one way to decode

        // Initialization for the first character
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    }
