/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 08/22/2024
 *https://leetcode.com/problems/longest-palindromic-subsequence/
 * Method 2 : you can reverse the given string and find the LCS between the string and reverse string 
 * that would also give you longest Palindromic Subsequence (Per Aditya Verma);
 * @author parth
 */
public class LongestPalindromicSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp[0].length;i++,j++){
                if(g == 0){
                    dp[i][j] = 1; //1 character is always palindrome
                }else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){ //both the characters are same
                        dp[i][j] = 2;
                    }else{
                        dp[i][j] = 1; //both the characters are different
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][dp.length-1];
    }
}
