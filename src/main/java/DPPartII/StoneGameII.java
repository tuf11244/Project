/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 08/19/2024
 * https://leetcode.com/problems/stone-game-ii/
 * @author parth
 */
public class StoneGameII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // DP table where dp[i][m] represents the maximum number of stones Alice can get starting at index i with M = m.
        int[][] dp = new int[n + 1][n + 1];
        
        // Suffix sum array to quickly calculate the total number of stones from index i to the end.
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // Fill the dp table from bottom to top, considering all possible positions and M values.
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                for (int x = 1; x <= 2 * m && i + x <= n; x++) {
                    dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                }
            }
        }
        
        // The answer we want is the maximum number of stones Alice can get starting from index 0 with M = 1.
        return dp[0][1]; 
    }
}
