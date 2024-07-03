/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/02/2024
 * https://leetcode.com/problems/decode-ways/
 * @author parth
 */
public class DecodeWays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int numDecodings(String s){
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: an empty string has one way to decode
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // First character check

        for (int i = 1; i < n; i++) {
            // Case 1: When both characters are zeros
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                dp[i + 1] = 0;
            }
            // Case 2: When the previous character is zero and the current character is not zero
            else if (s.charAt(i - 1) == '0' && s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
            }
            // Case 3: When the previous character is not zero and the current character is zero
            else if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i + 1] = i >= 2 ? dp[i - 1] : 1;
                } else {
                    dp[i + 1] = 0;
                }
            }
            // Case 4: When both characters are not zeros
            else {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }

        return dp[n];
    }
}
