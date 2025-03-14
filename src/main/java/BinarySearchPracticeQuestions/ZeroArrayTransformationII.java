/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 03/13/2025
 * https://leetcode.com/problems/zero-array-transformation-ii/
 * @author parth
 */
public class ZeroArrayTransformationII {
    
    public static void main(String[] args) {
        
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        if (isAlreadyZero(nums)) {
            return 0; // No queries needed if nums is already all zeros
        }

        int n = nums.length;
        int[] originalNums = nums.clone(); // Preserve the original array
        int left = 1, right = queries.length, answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canTransform(originalNums, queries, mid)) {
                answer = mid;
                right = mid - 1; // Try for a smaller k
            } else {
                left = mid + 1; // Need more queries
            }
        }

        return answer;
    }

    private boolean canTransform(int[] originalNums, int[][] queries, int k) {
        int n = originalNums.length;
        int[] diff = new int[n]; // Difference array

        // Apply first k queries
        for (int i = 0; i < k; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];

            diff[left] += value;
            if (right + 1 < n) {
                diff[right + 1] -= value;
            }
        }

        // Compute the transformed array using the difference array
        int[] transformedNums = originalNums.clone();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i]; 
            transformedNums[i] -= sum;
        }

        return isAlreadyZero(transformedNums);
    }

    private boolean isAlreadyZero(int[] nums) {
        for (int num : nums) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}   
