/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 10/17/2024
 *https://leetcode.com/problems/champagne-tower/
 * @author parth
 */
public class ChampagneTower {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        // dp[i][j] means how much champagne is in glass (i, j)
        double[][] dp = new double[query_row + 2][query_row + 2]; 
        dp[0][0] = poured;  // Initially, pour all champagne into the top glass

        // Iterate over each row until we reach query_row
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1.0) {  // Only spill champagne if more than 1 glass worth
                    double spillOver = (dp[i][j] - 1.0) / 2.0;  // The amount to spill over
                    dp[i][j] = 1.0;  // Cap the current glass to 1
                    dp[i + 1][j] += spillOver;  // Spill to the left child
                    dp[i + 1][j + 1] += spillOver;  // Spill to the right child
                }
            }
        }

        // Return the amount in the target glass, capped at 1.0 since that's the max it can hold
        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
