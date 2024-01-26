/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.com/problems/maximum-subarray/
 * Kadane's Algorithm
 * @author parth
 */
public class MaximumSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,4,-1,7,8};
        
    }
    public static int maximumSubArray(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    
}
