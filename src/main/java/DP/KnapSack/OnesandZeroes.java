/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;

/**
 *Date: 09/17/2024
 * Based on KnapSack Problem
 * https://leetcode.com/problems/ones-and-zeroes/
 * @author parth
 */
public class OnesandZeroes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
//    public int findMaxForm(String[] strs, int m, int n) {
//        
//    // DP table to store the maximum number of strings we can pick
//        // dp[i][j] represents the maximum number of strings we can pick with i zeroes and j ones
//        int[][] dp = new int[m + 1][n + 1];
//        
//        // Iterate through each string in the input array
//        for (String s : strs) {
//            // Count the number of 0's and 1's in the current string
//            int zeroes = 0, ones = 0;
//            for (char c : s.toCharArray()) {
//                if (c == '0') zeroes++;
//                else ones++;
//            }
//            
//            // Update the dp array from bottom right to top left
//            // (because we don't want to overwrite the dp values while updating)
//            for (int i = m; i >= zeroes; i--) {
//                for (int j = n; j >= ones; j--) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
//                }
//            }
//        }
//        
//        // The result will be the maximum number of strings that can be formed with m zeroes and n ones
//        return dp[m][n];
//    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        // Initialize DP array with -1 for memoization
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(strs, 0, m, n, dp);
    }

    private int helper(String[] strs, int index, int m, int n, int[][][] dp) {
        // Base case: if we've considered all strings
        if (index == strs.length) {
            return 0;
        }
        
        // Check memoized result
        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        // Count the number of 1's and 0's in the current string
        int count1 = getCount(strs[index], '1');
        int count0 = strs[index].length() - count1;

        // Option 1: Skip this string
        int skip = helper(strs, index + 1, m, n, dp);

        // Option 2: Pick this string (only if enough 0's and 1's are available)
        int pick = 0;
        if (count0 <= m && count1 <= n) {
            pick = 1 + helper(strs, index + 1, m - count0, n - count1, dp);
        }

        // Store the result in DP array
        dp[index][m][n] = Math.max(pick, skip);
        return dp[index][m][n];
    }

    private int getCount(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
