/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;
import java.util.*;
/**
 *Date: 12/29/2024
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 * @author parth
 */
public class NumberofWaystoFormaTargetStringGivenaDictionary {

    /**
     * @param args the command line arguments
     */
     public int MOD = 1_000_000_007;
     public int[][] dp;
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
     /**
     * Computes the number of ways to form the target string using given words.
     * @param words Array of words used as columns for forming the target.
     * @param target The target string to form.
     * @return Number of ways to form the target string modulo MOD.
     */
    public int numWays(String[] words, String target) {
        int m = words[0].length(); // All words are of the same length (number of columns).
        int n = target.length();  // Length of the target string.

        long[][] freq = new long[26][m]; // Frequency of each character in each column.

        // Precompute the frequency of characters in each column.
        for (String word : words) {
            for (int col = 0; col < word.length(); col++) {
                freq[word.charAt(col) - 'a'][col]++; // Increment frequency for character at column `col`.
            }
        }

        dp = new int[n][m]; // Initialize the DP table: n rows (target), m columns (columns of words).
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill the DP table with -1 to denote uncomputed states.
        }

        // Solve the problem starting from target index 0 and column index 0.
        return solve(0, 0, freq, target, m);
    }

    /**
     * Recursive helper function to compute the number of ways to form the target using DP.
     * @param i Current index of the target string being considered.
     * @param j Current column of words being processed.
     * @param freq Precomputed frequency table of characters in each column.
     * @param target The target string to form.
     * @param m Number of columns in the `words` matrix.
     * @return Number of ways to form the remaining target from current state modulo MOD.
     */
    public int solve(int i, int j, long[][] freq, String target, int m) {
        // Base case: If we've formed the entire target string.
        if (i == target.length()) {
            return 1; // Successfully formed the target, count this as one way.
        }

        // Base case: If we've exhausted all columns.
        if (j == m) {
            return 0; // Can't form the target as we've run out of columns.
        }

        // Return the result if it's already computed.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Case 1: Skip the current column and move to the next column.
        int notTaken = solve(i, j + 1, freq, target, m) % MOD;

        // Case 2: Use characters from the current column if they match the target.
        int taken = 0;
        if (freq[target.charAt(i) - 'a'][j] > 0) { // Check if the character exists in this column.
            taken = (int) ((freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, target, m)) % MOD);
        }

        // Store the result for this state in the DP table and return it.
        dp[i][j] = (taken + notTaken) % MOD;
        return dp[i][j];
    }
}
