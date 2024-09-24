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
}
