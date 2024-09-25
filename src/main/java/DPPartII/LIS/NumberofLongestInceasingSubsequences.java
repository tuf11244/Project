/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;

/**
 *Date: 09/25/2024
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * @author parth
 */
public class NumberofLongestInceasingSubsequences {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];  // stores the length of LIS ending at each index
        int[] count = new int[n];  // stores the number of ways to achieve that length
        int maxLength = 0;
        
        // Initialize the dp and count arrays
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // minimum LIS length is 1 (the number itself)
            count[i] = 1;  // there's at least one way to form a subsequence of length 1
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];  // reset count to the count at j
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];  // add the number of ways from j
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);  // track the max length of LIS
        }
        
        // Now, sum up all the counts for indices where dp[i] == maxLength
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                result += count[i];
            }
        }
        
        return result;
    }
}
