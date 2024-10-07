/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 09/23/2024
 * https://leetcode.com/problems/extra-characters-in-a-string/
 * Based on KnapSack Problem
 * @author parth
 */
public class ExtraCharactersinString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minExtraChar(String s, String[] dictionary) {
      int n = s.length();
        Set<String> wordSet = new HashSet<>();  // For O(1) lookups

        for(String word : dictionary){
            wordSet.add(word);
        }
        int[] dp = new int[n + 1];  // dp[i] will hold the minimum extra chars for s[0:i]

        // Initialize dp with maximum possible value
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;  // Base case: no string means 0 extra characters
        
        // DP iteration
        for (int i = 1; i <= n; i++) {
            // Check all possible substrings ending at i
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                
                if (wordSet.contains(substring)) {
                    // If substring is a valid word, no extra chars for this part
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    // If substring is not valid, treat it as extra characters
                    dp[i] = Math.min(dp[i], dp[j] + (i - j));
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];  // The answer will be the minimum extra chars for the entire string  
    }
    
    
    //Recursion with Memoization 
    public int minExtraCharMemo(String s, String[] dictionary){
         Set<String> wordSet = new HashSet<>();  // For O(1) lookups

        for(String word : dictionary){
            wordSet.add(word);
        }
        int [] dp = new int[s.length() + 1];
        Arrays.fill(dp,-1);
        return helper(0,s,wordSet,dp);
    }
    
    public int helper(int index, String s, Set<String> wordSet, int[] dp){
        if(index >= s.length()){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int result = 1 + helper(index+1,s,wordSet,dp);
        
        for(int j = index; j < s.length();j++){
            String current = s.substring(index, j + 1);
            
            if(wordSet.contains(current)){
                result = Math.min(result,helper(j+1,s,wordSet,dp));
            }
        }
        
        dp[index] = result;
        return result;
    }
}
