/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 05/19/2025
 * https://leetcode.com/problems/painting-a-grid-with-three-different-colors/
 * @author parth
 */
public class PaintingaGridWith3DifferentColors {
    
    public static void main(String[] args) {
        
    }
    // LeetCode 1931 – Painting a Grid With Three Different Colors
// -----------------------------------------------------------
// Goal: Count the number of ways to paint an m × n grid with colors
//       R, G, B such that:
//         • vertically-adjacent cells in the same column differ
//         • horizontally-adjacent cells in the same row differ
//       Return the count modulo 1 000 000 007.
//
// Approach used in this code
// --------------------------
// 1. Pre-generate every column configuration that is *vertically* valid.
//    Each configuration is stored as a string of length m (top→bottom).
// 2. Use DFS + memoization (dp) to place columns left-to-right,
//    ensuring any two neighboring columns are *horizontally* compatible
//    (no row shares the same color).
// 3. Sum the ways that begin with every possible first column.


    List<String> columnStates;          // all vertically-valid column strings
    public int mod = (int)1e9 + 7;      // required modulus
    int[][] dp;                         // dp[idx][rem] → ways given prev column idx and rem columns left

    public int colorTheGrid(int m, int n) {

        // ---------- Step 1: generate all valid column states ----------
        columnStates = new ArrayList<>();
        generateStates(/*state=*/"", /*remainingSpots=*/m, /*prevColor=*/'#'); // '#' sentinel = “no previous color”

        // ---------- Step 2: set up memo table ----------
        dp = new int[columnStates.size()][1001];      // n ≤ 1000 in constraints
        for (int[] arr : dp) Arrays.fill(arr, -1);

        // ---------- Step 3: start DFS from every possible first column ----------
        long result = 0;                              // use long to avoid overflow before applying mod
        for (int i = 0; i < columnStates.size(); i++) {
            result = (result + solve(i, n - 1, m)) % mod; // we already fixed column 0, so n-1 columns remain
        }
        return (int) result;
    }

    /**
     * Recursively counts ways when
     *   prevIndex        = index of the column placed immediately to the left
     *   remainingColumns = how many more columns (to the right) we still need to paint
     *   m                = grid height (passed to avoid capturing outer variable)
     */
    public int solve(int prevIndex, int remainingColumns, int m) {
        if (remainingColumns == 0) {
            return 1;                       // placed all columns → found one full grid coloring
        }

        if (dp[prevIndex][remainingColumns] != -1) {
            return dp[prevIndex][remainingColumns];   // memo hit
        }

        String prevState = columnStates.get(prevIndex);
        long totalWays = 0;

        // Try every candidate as the *current* column
        for (int i = 0; i < columnStates.size(); i++) {

            String currentState = columnStates.get(i);
            boolean isValid = true;

            // Check horizontal compatibility row-by-row
            for (int j = 0; j < m; j++) {
                if (prevState.charAt(j) == currentState.charAt(j)) {
                    isValid = false;        // same color in this row → invalid pairing
                    break;
                }
            }

            if (isValid) {
                // Compatible → recurse on the remaining columns
                totalWays = (totalWays + solve(i, remainingColumns - 1, m)) % mod;
            }
        }

        dp[prevIndex][remainingColumns] = (int) totalWays; // memoize
        return (int) totalWays;
    }

    /**
     * DFS helper that constructs all strings of length m where no two
     * consecutive characters are identical (vertical constraint).
     *
     * @param state           prefix built so far
     * @param remainingSpots  how many rows still to fill
     * @param prevColor       last color placed (to check vertical constraint)
     */
    public void generateStates(String state, int remainingSpots, char prevColor) {
        if (remainingSpots == 0) {
            columnStates.add(state);        // finished one full column → store it
            return;
        }

        for (char color : new char[]{'R', 'G', 'B'}) {
            if (color != prevColor) {       // ensure current cell differs from previous row
                generateStates(state + color, remainingSpots - 1, color);
            }
        }
    }

}
