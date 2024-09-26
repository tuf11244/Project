/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;
import java.util.*;
/**
 *Date: 08/27/2024
 *https://leetcode.com/problems/distinct-subsequences-ii/
 * @author parth
 */
public class CountofDistinctSubsequencesII {
     public static int MOD = 1000000007;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(distinctSubseqII("rabbb"));
    }
    public static int distinctSubseqII(String s) {
        int[] dp = new int[s.length() + 1];

        dp[0] = 1; // Empty subsequence i.e., when we don't include the character 
        HashMap<Character,Integer> hm = new HashMap<>();

        for (int i = 1; i < dp.length; i++) {
            dp[i] = (2 * dp[i-1]) % MOD;  // Double the previous count
            char ch = s.charAt(i-1);
            if (hm.containsKey(ch)) {  // Meaning the character was seen before
                int prevIndex = hm.get(ch);
                dp[i] = (dp[i] - dp[prevIndex - 1] + MOD) % MOD;  // Adjusting for duplicates and ensuring non-negative
            }
            hm.put(ch, i);
        }

        return (dp[s.length()] - 1 + MOD) % MOD;  // Subtracting 1 for the empty subsequence
    }
}
