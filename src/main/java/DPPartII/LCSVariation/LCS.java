/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;
import java.util.*;
/**
 *Date: 08/20/2024
 *https://leetcode.com/problems/longest-common-subsequence/
 * @author parth
 */
public class LCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(longestCommonSubsequence("abcd","abcd"));
    }
    
    public static int longestCommonSubsequence(String text1, String text2) {
        //the length is text1.length() + 1 because of the dash
        //dash represents the state when the character doesn;t want to come in the subsequence 
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[i].length - 2; j >= 0;j--){
                char ch1= text1.charAt(i);
                char ch2 = text2.charAt(j);

                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][0];
    }
}
