/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 10/15/2024
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * Same question can be asked as Minimum deletion steps to make a string palindrome
 * @author parth
 */
public class MinimumInsertionStepstoMakeStringPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minInsertions(String s) {
        
        
        
        //Find the longest Palindromic subsequece
          int[][] dp = new int[s.length()][s.length()];
          int i;
          int j;
          for(int g = 0; g < s.length();g++){
            for(i = 0,j = g; j < s.length();i++,j++){

                if(g == 0){
                    dp[i][j] = 1;

                }else if(g == 1){
                    //2 characters 
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2;
                    }else{
                        dp[i][j] = 1;
                    }

                }else{
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);

                    if(ch1 == ch2){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }

                }
            }
          }
            
          //The minimum insertions would be total length - longest Palindromic Subsequence
          return s.length() -  dp[0][s.length() -1];

    }
}
