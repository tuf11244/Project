/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/minimum-absolute-sum-difference/
 * @author parth
 */
public class MinimumAbsoluteDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};
             
    }
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;

        // Calculate initial sumDiff
        int sumDiff = 0;
        int maxImprovement = 0;
        int[] sortedNums1 = nums1.clone();
        Arrays.sort(sortedNums1);

        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(nums1[i] - nums2[i]);
            sumDiff = (sumDiff + originalDiff) % MOD;

            // Find the best replacement for nums1[i] to minimize difference
            int target = nums2[i];
            int ciel = cieling(sortedNums1, target);
            int fl = floor(sortedNums1, target);

            // Calculate potential new difference
            int newDiff = Integer.MAX_VALUE;
            if (ciel < n) newDiff = Math.min(newDiff, Math.abs(sortedNums1[ciel] - target));
            if (fl >= 0) newDiff = Math.min(newDiff, Math.abs(sortedNums1[fl] - target));

            // Calculate improvement
            maxImprovement = Math.max(maxImprovement, originalDiff - newDiff);
        }

        // Calculate final result
        return (sumDiff - maxImprovement + MOD) % MOD;
    }

    private int cieling(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int floor(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
        
}
