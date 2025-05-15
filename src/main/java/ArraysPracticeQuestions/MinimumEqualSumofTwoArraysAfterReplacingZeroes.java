/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 05/10/2025
 * https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
 * @author parth
 */
public class MinimumEqualSumofTwoArraysAfterReplacingZeroes {
    
    public static void main(String[] args) {
        
    }
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeroCount1 = 0, zeroCount2 = 0;

        for (int num : nums1) {
            if (num == 0) zeroCount1++;
            sum1 += num;
        }

        for (int num : nums2) {
            if (num == 0) zeroCount2++;
            sum2 += num;
        }

        // Minimum additional sum we can add: count of zeroes (by adding all 1s)
        long minPossible1 = sum1 + zeroCount1 * 1L;
        long minPossible2 = sum2 + zeroCount2 * 1L;

        // Maximum possible sum for each array (assuming replacing 0s to match other array's sum)
        long target = Math.max(minPossible1, minPossible2);

        // Now try to replace 0s to reach `target` if possible
        if ((zeroCount1 == 0 && sum1 < target) || (zeroCount2 == 0 && sum2 < target)) {
            return -1;
        }

        return target;
    }
    
}
