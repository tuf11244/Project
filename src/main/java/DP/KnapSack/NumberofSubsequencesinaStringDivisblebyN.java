/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;
import java.util.*;
/**
 *Date: 01/18/2025
 * https://www.geeksforgeeks.org/number-subsequences-string-divisible-n/
 * https://www.geeksforgeeks.org/problems/number-of-subsequences-in-a-string-divisible-by-n5947/
 * @author parth
 */
  
public class NumberofSubsequencesinaStringDivisblebyN {
    public static  final int MOD = 1000000007;
   private int[][] memo;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public  int count(String s, int n){
         int len = s.length();
        // Initialize memoization table
        memo = new int[len][n];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        // Call the recursive helper function starting from index 0 and remainder 0
        return (helper(s, n, 0, 0) - 1 + MOD) % MOD; // Subtract 1 to exclude the empty subsequence
        
    }
    
    private int helper(String s, int n, int idx, int remainder) {
        // Base case: if we've processed all characters
        if (idx == s.length()) {
            return remainder == 0 ? 1 : 0;
        }

        // Check if already computed
        if (memo[idx][remainder] != -1) {
            return memo[idx][remainder];
        }

        // Recursive cases
        int digit = s.charAt(idx) - '0';
        // Case 1: Exclude current character
        int exclude = helper(s, n, idx + 1, remainder);
        // Case 2: Include current character
        int newRemainder = (remainder * 10 + digit) % n;
        int include = helper(s, n, idx + 1, newRemainder);

        // Combine results and take modulo
        int result = (exclude + include) % MOD;
        memo[idx][remainder] = result;

        return result;
    }
}
