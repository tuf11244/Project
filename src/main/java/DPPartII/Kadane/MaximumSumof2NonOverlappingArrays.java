/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;

/**
 *Date: 09/19/2024
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * @author parth
 */
public class MaximumSumof2NonOverlappingArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // Compute max sum for two possible arrangements
        int option1 = helper(nums, firstLen, secondLen);
        int option2 = helper(nums, secondLen, firstLen);

        return Math.max(option1, option2); 
    }

    // Helper function to compute max sum of two non-overlapping subarrays
    public int helper(int[] nums, int x, int y) {
        int[] dp1 = new int[nums.length]; // From left to right
        int[] dp2 = new int[nums.length]; // From right to left

        int sum = 0;

        // Calculate dp1 (maximum sum of subarray of length x from left to right)
        for (int i = 0; i < nums.length; i++) {
            if (i < x) {
                sum += nums[i];
                dp1[i] = sum;
            } else {
                sum += nums[i] - nums[i - x];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }

        sum = 0;

        // Calculate dp2 (maximum sum of subarray of length y from right to left)
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + y >= nums.length) {
                sum += nums[i];
                dp2[i] = sum;
            } else {
                sum += nums[i] - nums[i + y];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }

        int answer = 0;

        // Find the maximum combined sum of non-overlapping subarrays
        for (int i = x - 1; i < nums.length - y; i++) {
            answer = Math.max(answer, dp1[i] + dp2[i + 1]);
        }

        return answer;
    }
}
