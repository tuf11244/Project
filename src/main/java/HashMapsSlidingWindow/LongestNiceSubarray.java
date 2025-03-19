/*
 * This program finds the longest "nice" subarray from an integer array.
 * A subarray is called "nice" if the bitwise AND of any two numbers in it is zero.
 * The approach uses a sliding window and bitwise operations to efficiently determine the longest nice subarray.
 */

package HashMapsSlidingWindow;

/**
 * Date: 03/17/2025
 * Problem Link: https://leetcode.com/problems/longest-nice-subarray/
 * Author: Parth
 */

public class LongestNiceSubarray {

    public static void main(String[] args) {
        // Test cases can be added here to check the function
    }

    /**
     * Finds the length of the longest "nice" subarray.
     * 
     * @param nums an array of integers
     * @return the maximum length of a nice subarray
     */
    public static int longestNiceSubArray(int[] nums) {
        int left = 0; // Left pointer of the sliding window
        int result = 1; // Stores the maximum length of a nice subarray found so far
        int mask = 0; // Bitwise OR of the numbers in the current window

        // Iterate over each element in the array using the right pointer
        for (int right = 0; right < nums.length; right++) {
            
            // If adding nums[right] causes a conflict (bitwise AND is non-zero),
            // we need to shrink the window from the left
            while ((mask & nums[right]) != 0) {
                mask ^= nums[left]; // Remove nums[left] from the bitmask using XOR
                left++; // Move the left pointer to shrink the window
            }

            // Update the result with the maximum window size found so far
            result = Math.max(result, right - left + 1);

            // Include nums[right] in the mask using bitwise OR
            mask |= nums[right];
        }

        // Return the maximum length of a nice subarray found
        return result;
    }
}
