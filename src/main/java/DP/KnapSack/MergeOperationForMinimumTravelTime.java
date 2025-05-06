/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DP.KnapSack;
import java.util.*;
/**
 *Date:05/05/2025
 * 
 * @author parth
 */
public class MergeOperationForMinimumTravelTime {
    public static void main(String[] args) {
        
    }
    int[][][] dp;

    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        // Step 1: Calculate the cumulative maximum time needed to initialize the DP array properly
        int cumulativeTime = 0;
        for (int t : time) {
            cumulativeTime = cumulativeTime + t;
        }

        // Step 2: Initialize the 3D DP array
        // dp[i][k][currentRate] represents the minimum travel time starting from index i,
        // with k merges remaining, and current rate as currentRate
        dp = new int[n][k + 1][cumulativeTime];

        // Step 3: Fill the DP array with -1 (indicating uncomputed states)
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        // Step 4: Start the recursive solving process from index 0 with time[0] as the current rate
        return solve(n, k, position, time, 0, time[0]);
    }

    /**
     * Recursive function to compute the minimum travel time
     * @param n           total number of points
     * @param k           number of allowed merges
     * @param position    positions of the points
     * @param time        time rate at each point
     * @param index       current index being considered
     * @param currentRate the rate (sum of times merged so far)
     */
    public int solve(int n, int k, int[] position, int[] time, int index, int currentRate) {
        
        // Base case: if we've reached the last position
        if (index == n - 1) {
            // If there are still merges left, it's invalid (incomplete journey)
            if (k > 0) {
                return Integer.MAX_VALUE;
            }
            return 0; // We're at the last point, no more travel needed
        }

        // If already computed for this state, return memoized result
        if (dp[index][k][currentRate] != -1) {
            return dp[index][k][currentRate];
        }

        int result = Integer.MAX_VALUE;

        // ===== OPTION 1: SKIP MERGING =====
        // Travel directly to the next index using current rate
        int skip = solve(n, k, position, time, index + 1, time[index + 1]);
        int distance = position[index + 1] - position[index];

        // Only compute if the skip path is valid
        if (skip != Integer.MAX_VALUE) {
            result = Math.min(result, skip + (distance * currentRate));
        }

        // ===== OPTION 2: MERGE NEXT K SEGMENTS =====
        if (k > 0) {
            int mergeRate = time[index + 1];  // Initial rate for merge
            int mergeCount = 0;               // How many segments we're merging

            // Try merging segments from index+1 to j
            for (int j = index + 2; j < n && mergeCount < k; j++) {
                mergeCount++;                     // One more merge
                mergeRate += time[j];             // Add rate of j-th segment to merge rate
             // i ---- i+1 ------ i+2 ------- i+3 .....
            // If we merge i+1 and i+2
            // i ---------- i+2 -------- i+3 , then you see (i+1) disappeared and 1 merge required

            // What if we want i -------- i+3 ???
            // We will need 2 merges i.e. merge i+1 to i+2 and i+2 to i+3, meaning we need two merges
            // i ------ i+3 .......

            // This for loop does that. It first tries to connect i to i+2, then i+3 and so on and
            // keeps checking how many merges required and also keep calculating the time required to find minimum
                // Recursive call: jump directly to j, with mergeCount merges used and new rate
                int pick = solve(n, k - mergeCount, position, time, j, mergeRate);

                if (pick != Integer.MAX_VALUE) {
                    int d = position[j] - position[index];
                    result = Math.min(result, pick + (d * currentRate));  // Pay cost with current rate
                }
            }

            // Memoize result only after merge block
            dp[index][k][currentRate] = result;
        }

        return result;
    }
}
