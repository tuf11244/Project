/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPPartII.Kadane;

/**
 *Date: 02/25/2025
 * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 * @author parth
 */
public class MaximumAbsoluteSumofAnySubArray {
    
    public static void main(String[] args){
        
    }
    public int maxAbsoluteSum(int[] nums) {

        

        // Initialize variables for tracking maximum subarray sum using Kadane’s Algorithm
        int currentMax = nums[0]; // Tracks the max sum ending at the current index
        int globalMax = nums[0];  // Stores the maximum sum encountered so far

        // Initialize variables for tracking minimum subarray sum
        int currentMin = nums[0]; // Tracks the min sum ending at the current index
        int globalMin = nums[0];  // Stores the minimum sum encountered so far

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentMax: either extend the existing subarray or start a new one
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            // Update globalMax if we found a new max subarray sum
            globalMax = Math.max(globalMax, currentMax);

            // Update currentMin: either extend the existing subarray or start a new one
            currentMin = Math.min(currentMin + nums[i], nums[i]);
            // Update globalMin if we found a new min subarray sum
            globalMin = Math.min(currentMin, globalMin);
        }

        // The result is the maximum absolute value of either the max sum or min sum
        return Math.max(globalMax, Math.abs(globalMin));
    }
}
