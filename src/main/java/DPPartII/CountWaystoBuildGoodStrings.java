/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 12/31/2024
 * https://leetcode.com/problems/count-ways-to-build-good-strings/
 * @author parth
 */
public class CountWaystoBuildGoodStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int MOD = (int) (1e9+ 7);
    public int[]dp;
    
    //Recursion + Memoization
    public int countGoodStrings(int low, int high, int zero, int one) {
        // Initialize the memoization array with -1 (indicating uncomputed states)
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        
        // Start recursion from length 0
        return solve(0, low, high, zero, one) % MOD;
        
    }
    
    // Recursive function to calculate the number of good strings of valid lengths
    public int solve(int currentLength, int l, int h, int zero, int one) {
        // Base case: if the current length exceeds the maximum length, return 0
        if (currentLength > h) {
            return 0;
        }

        // Check if the current length is within the valid range [low, high]
        boolean addOne = false;
        if (currentLength >= l && currentLength <= h) {
            addOne = true;
        }

        // If the value for this length is already computed, return it
        if (dp[currentLength] != -1) {
            return dp[currentLength];
        }

        // Recursively calculate the count if we append "one" (increase length by `one`)
        int appendOne = solve(currentLength + one, l, h, zero, one) % MOD;

        // Recursively calculate the count if we append "zero" (increase length by `zero`)
        int appendZero = solve(currentLength + zero, l, h, zero, one) % MOD;

        // Calculate the total good strings:
        // - Add 1 if the current length is within the range [low, high]
        // - Add results from appending "one" and "zero"
        dp[currentLength] = ((addOne ? 1 : 0) + appendOne + appendZero) % MOD;

        // Return the computed value for the current length
        return dp[currentLength];
    }
    
    
    //Buttom-up Approach
     public int countGoodStringsBottomUp(int low, int high, int zero, int one) {
      
         int mod = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;  // Base case: one way to form an empty string.
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % mod;
        }
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % mod;
        }
        return result;
        
    }
}
