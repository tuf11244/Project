/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 10/28/2024
 * https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 * @author parth
 */
public class MaximumAlternatingSubsequenceSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Based on state
    public static long maxAlternatingSum(int[] nums) {
      long evenSum = 0; // Maximum sum ending with a "buy"
        long oddSum = 0;  // Maximum sum ending with a "sell"

        for (int num : nums) {
            evenSum = Math.max(evenSum, oddSum + num); // Adding to "buy"
            oddSum = Math.max(oddSum, evenSum - num);   // Subtracting to "sell"
        }

        return evenSum;  
        
    }
    
    
    //Recursion + Memoization
    public long maxAlternatingSumRecursion(int[] nums) {
        Long[][] memo = new Long[nums.length][2]; // 2 states: 0 for "even" state, 1 for "odd" state
        return helper(nums, 0, 0, memo); // start from index 0 with "even" state
    }

    private long helper(int[] nums, int index, int state, Long[][] memo) {
        if (index >= nums.length) {
            return 0;
        }
        
        if (memo[index][state] != null) {
            return memo[index][state];
        }
        
        long pick, skip;
        
        if (state == 0) { // "even" state (add the current element)
            pick = nums[index] + helper(nums, index + 1, 1, memo);
        } else { // "odd" state (subtract the current element)
            pick = -nums[index] + helper(nums, index + 1, 0, memo);
        }
        
        // Skip the current element
        skip = helper(nums, index + 1, state, memo);
        
        // Maximize the result by either picking or skipping
        memo[index][state] = Math.max(pick, skip);
        return memo[index][state];
    }
}
