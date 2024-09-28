/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;
import java.util.*;
/**
 *Date: 08/27/2024
 * https://leetcode.com/problems/distinct-subsequences/
 * @author parth
 */
public class CountofDistinctSubsequencesI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(numDistinct("raabbit","rabbit"));
    }
    public static int numDistinct(String s, String t) {
     int[][] dp = new int[t.length() +1][s.length() +1];
     
     for(int i = dp.length - 1; i >= 0; i--){
         for(int j = dp[0].length - 1; j >= 0;j--){
             if(i == dp.length - 1 && j == dp[0].length - 1){
                 dp[i][j] = 1;
             }else if(i == dp.length - 1){
                 dp[i][j] = 1;
             }else if(j == dp[0].length - 1){
                 dp[i][j] = 0;
             }else {
                 char c1 = t.charAt(i);
                 char c2 = s.charAt(j);
                 
                 if(c1 == c2){
                     dp[i][j] = dp[i][j+1] + dp[i+1][j+1];
                 }else{
                     dp[i][j] = dp[i][j+1];
                 }
             }
         }
     } 
     
         for(int[] arr : dp){
             System.out.println(Arrays.toString(arr));
         }
        return dp[0][0];
     
    }
    
    
    public static int numDistinctMemo(String s, String t){
       int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        // Initialize dp with -1 (for memoization)
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        return helper(s, t, 0, 0, dp);
    }
    
    public static int helper(String s, String t, int i, int j,int[][] dp){
        // Base cases:
        if(j == t.length()) {  // If target is fully matched
            return 1;
        }
        if(i == s.length()) {  // If source is exhausted and target is not
            return 0;
        }
        
        // Check memoized result
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int result = 0;
        
        // When characters match, we have two choices: include or skip
        if(s.charAt(i) == t.charAt(j)) {
            result += helper(s, t, i + 1, j + 1, dp);  // Include the character
        }
        
        // Always skip the character in source `s` and move forward
        result += helper(s, t, i + 1, j, dp);
        
        // Memoize the result
        dp[i][j] = result;
        
        return result;
    }
}
