/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;

/**
 *Date: 11/15/2024
 * https://leetcode.com/problems/shortest-common-supersequence/
 * @author parth
 */
public class ShortestCommonSuperSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Build the DP table (LCS length)
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // Traverse and construct the SCS
        StringBuilder scs = new StringBuilder();
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                // Match: Add character to SCS
                scs.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) {
                // Take character from s1
                scs.append(s1.charAt(i));
                i++;
            } else {
                // Take character from s2
                scs.append(s2.charAt(j));
                j++;
            }
        }

        // Append remaining characters from s1 or s2
        while (i < s1.length()) {
            scs.append(s1.charAt(i));
            i++;
        }
        while (j < s2.length()) {
            scs.append(s2.charAt(j));
            j++;
        }

        return scs.toString();
    }
}
