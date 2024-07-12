/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/11/2024
 *https://leetcode.com/problems/domino-and-tromino-tiling/
 * @author parth
 */
public class DominoandTrominoTiling {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int numTilings(int n) {
    if (n == 1 || n == 2) {
            return n;
        }
        
        int M = 1000000007;
        int[] dp = new int[n + 1];
        
        // Initialize base cases
        dp[0] = 1;  // Base case for completeness
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % M + dp[i - 3] % M) % M;
        }
        
        return dp[n];
    }
}
