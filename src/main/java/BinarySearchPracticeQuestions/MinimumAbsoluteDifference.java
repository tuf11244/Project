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
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int)1e9 + 7;
        int n = nums1.length;
        
        // Calculate the initial absolute sum difference
        int[] result1 = new int[n];
        int result1Sum = 0;
        for (int i = 0; i < n; i++) {
            result1[i] = Math.abs(nums1[i] - nums2[i]);
            result1Sum = (result1Sum + result1[i]) % mod;
        }

        // Sort nums1 to perform binary search
        int[] sortedNums1 = nums1.clone();
        Arrays.sort(sortedNums1);

        // Find the element in nums1 that, when replaced, gives the maximum reduction
        int maxReduction = 0;
        for (int i = 0; i < n; i++) {
            int originalDiff = result1[i];
            
            // Use binary search to find the closest element in sortedNums1 to nums2[i]
            int closestElement = findClosestElement(sortedNums1, nums2[i]);

            // Calculate the absolute sum difference after replacing nums1[i] with the closest element
            int newDiff = Math.abs(closestElement - nums2[i]);
            maxReduction = Math.max(maxReduction, originalDiff - newDiff);
        }

        // Update the overall minimum absolute sum difference
        int result = (result1Sum - maxReduction + mod) % mod;
        return result;
    }

    private static int findClosestElement(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // At this point, left and right point to the closest element
        if (left > 0 && Math.abs(nums[left - 1] - target) < Math.abs(nums[left] - target)) {
            left--;
        }

        return nums[left];
        }
    
        
}
