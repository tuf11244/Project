/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/perfect-squares/
 * Date: 11/22/2023
 * @author parth
 */
public class PerfectSquares {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(20));
    }
    public static int numSquares(int n) {
        // Create an array to store results for subproblems
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return helper(n, memo);
    }

    private static int helper(int n, int[] memo) {
        // Base case: if n is 0, then 0 perfect squares are needed
        if (n == 0) {
            return 0;
        }

        // Check if the result is already memoized
        if (memo[n] != -1) {
            return memo[n];
        }

        int minSquares = Integer.MAX_VALUE;

        // Try all perfect squares less than or equal to n
        for (int i = 1; i * i <= n; i++) {
            int squaresNeeded = 1 + helper(n - i * i, memo);
            minSquares = Math.min(minSquares, squaresNeeded);
        }

        // Memoize the result and return
        memo[n] = minSquares;
        return minSquares;
    }
}
