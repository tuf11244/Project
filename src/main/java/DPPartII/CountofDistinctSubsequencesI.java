/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 08/27/2024
 * https://leetcode.com/problems/distinct-subsequences/
 * @author parth
 */
public class CountofDistinctSubsequencesI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] will be storing the count of subsequences of s[0..i-1] that equals t[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Initializing the dp array
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // empty string t is a subsequence of any prefix of s
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, we can consider two options:
                // 1. Exclude current character of s
                // 2. Include current character of s
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, we can only exclude current character of s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
