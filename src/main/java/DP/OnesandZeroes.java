/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

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
    public int findMaxForm(String[] strs, int m, int n) {
        
    // DP table to store the maximum number of strings we can pick
        // dp[i][j] represents the maximum number of strings we can pick with i zeroes and j ones
        int[][] dp = new int[m + 1][n + 1];
        
        // Iterate through each string in the input array
        for (String s : strs) {
            // Count the number of 0's and 1's in the current string
            int zeroes = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeroes++;
                else ones++;
            }
            
            // Update the dp array from bottom right to top left
            // (because we don't want to overwrite the dp values while updating)
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }
        
        // The result will be the maximum number of strings that can be formed with m zeroes and n ones
        return dp[m][n];
    }
}
