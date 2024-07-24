/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/23/2024
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @author parth
 */
public class BestTimetoBuyandSellStockatMostKTransactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Brute Force = 0(n^3)
    public static int maxProfit(int k, int[] prices){
       // Create a 2D array dp where dp[t][d] will store the maximum profit
    // achievable with at most t transactions up to day d.
    int[][] dp = new int[k + 1][prices.length];
    
    // Iterate over the number of transactions from 1 to k.
    for (int t = 1; t <= k; t++) {
        // Iterate over each day from 1 to the last day.
        for (int d = 1; d < dp[0].length; d++) {
            // Initialize max to the maximum profit without completing any transactions on day d.
            int max = dp[t][d - 1];
            
            // Iterate over all previous days to find the best day to buy before day d.
            for (int pd = 0; pd < d; pd++) {
                // Calculate the profit if we buy on day pd and sell on day d.
                int prevValue = dp[t - 1][pd];
                int profit = prices[d] - prices[pd];
                // Update max with the maximum profit found so far.
                max = Math.max(profit + prevValue, max);
            }
            
            // Store the maximum profit for t transactions up to day d.
            dp[t][d] = max;
        }
    }
    // Return the maximum profit achievable with k transactions up to the last day.
        return dp[k][prices.length - 1];
    }
    
    //Optimized Approach O(N^2)
     public static int maxProfitOptimized(int k, int[] prices){
       // Create a 2D array dp where dp[t][d] will store the maximum profit
    // achievable with at most t transactions up to day d.
    int[][] dp = new int[k + 1][prices.length];
    
    // Iterate over the number of transactions from 1 to k.
    for (int t = 1; t <= k; t++) {
        int max = Integer.MIN_VALUE;
        // Iterate over each day from 1 to the last day.
        for (int d = 1; d < dp[0].length; d++) {
            // Initialize max to the maximum profit without completing any transactions on day d.
            max = Math.max(max,dp[t-1][d-1] - prices[d-1]);
            
            dp[t][d] = Math.max(dp[t][d-1],max + prices[d]);
            
        }
    }
    // Return the maximum profit achievable with k transactions up to the last day.
        return dp[k][prices.length - 1];
    }
}
