/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: 01/17/2025
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * @author parth
 */
public class NumberofSubsequencesthatSatisfyaGivenSumCondition {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    // Define a constant for the modulus value to prevent integer overflow
    public static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        // Sort the array to simplify the process of finding valid subsequences
        Arrays.sort(nums); 
        int n = nums.length; // Get the length of the array
        int left = 0, right = n - 1; // Two-pointer approach: left at the beginning, right at the end
        int result = 0; // Variable to store the final count of valid subsequences

        // Precompute powers of 2 modulo MOD to be used later
        int[] powerOfTwo = new int[n];
        powerOfTwo[0] = 1; // 2^0 = 1
        for (int i = 1; i < n; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD; // Compute 2^i % MOD
        }

        // Use the two-pointer approach to find valid subsequences
        while (left <= right) {
            // Check if the smallest and largest elements between the pointers satisfy the condition
            if (nums[left] + nums[right] <= target) {
                // If valid, all subsequences including `nums[left]` and any subset of elements 
                // from `left` to `right` are valid. The total number of such subsequences is 
                // 2^(right - left). Add this count to the result.
                result = (result + powerOfTwo[right - left]) % MOD;
                left++; // Move the left pointer to the right to include the next element
            } else {
                // If the pair is invalid, move the right pointer left to reduce the sum
                right--;
            }
        }

        // Return the total count of valid subsequences modulo MOD
        return result;
    }
}
