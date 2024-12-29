/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;
import java.util.*;
/**
 *Date: 09/19/2024
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * @author parth
 */
public class MaximumSumof3NonOverlappingArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int[] left = new int[nums.length];
        int[] right =new int[nums.length];
        
        int sum = 0;
        
        //From left to Right
        for(int i = 0; i < nums.length;i++){
            if(i < k){
                sum = sum + nums[i];
                left[i] = sum;
            }else {
                sum = sum + nums[i] - nums[i-k];
                left[i] = Math.max(left[i-1],sum);
            }
        }
        
        //From right to left
        sum = 0;
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + k >= nums.length){
                sum = sum + nums[i];
                right[i] = sum;
            }else{
                sum = sum + nums[i] - nums[i+k];
                right[i] = Math.max(right[i+1], sum);
            }
        }
        
        //Third Array or the middle array 
        //Please note that the starting index of middle array would be from k to n - 2k;
        
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        for(int i = 1; i < nums.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        int maxSum = 0;
        int startPointforMiddleArray = -1;
        int leftSum = -1;
        int rightSum = -1;
        
        int[] result = new int[3];
        
          // Iterate over possible middle subarray starting points
        for (int i = k; i <= nums.length - 2 * k; i++) {
            int middleSum = prefixSum[i + k - 1] - prefixSum[i - 1];
            int totalSum = left[i - 1] + middleSum + right[i + k];
            
            if (totalSum > maxSum) {
                maxSum = totalSum;
                startPointforMiddleArray = i;
                leftSum = left[i - 1];
                rightSum = right[i + k];
            }
        }
        
        for(int i = k - 1;i < startPointforMiddleArray ; i++){
            //i < startPointforMiddleArray because if i == startPointforMiddleArray means begining of middleArray
            if(prefixSum[i] - (i - k < 0 ? 0 : prefixSum[i-k]) == leftSum){
                System.out.println("Left SubArray starting Index is :" + (i-k +1));
                result[0] = i - k +1;
                break;
            }
        }
        
        
        result[1] = startPointforMiddleArray;
        
           // Find starting index for right subarray
        for (int i = startPointforMiddleArray + k; i < nums.length - k + 1; i++) {
            if (prefixSum[i + k - 1] - prefixSum[i - 1] == rightSum) {
                result[2] = i;
                break;
            }
        }
        
        return result;
    }
    
    
        public int[][] dp; // Memoization table to store intermediate results.

   /**
    * Finds the starting indices of three non-overlapping subarrays of length `k` 
    * with the maximum sum using recursion with memoization.
    *
    * @param nums Array of integers.
    * @param k Length of each subarray.
    * @return Array of starting indices of the three subarrays with the maximum sum.
    */
   public int[] maxSumOfThreeSubarraysRecursion(int[] nums, int k) {
       List<Integer> list = new ArrayList<>(); // List to store the indices of the subarrays.

       // Initialize the memoization table with -1 (uncomputed state).
       dp = new int[20001][4]; // Maximum index is assumed to be 20000, and at most 3 subarrays to select.
       for (int[] arr : dp) {
           Arrays.fill(arr, -1);
       }

       // Calculate the sum of all subarrays of size `k` using a sliding window approach.
       int[] subArraySum = new int[nums.length - k + 1];
       int i = 0, j = 0, windowSum = 0;

       // Build the `subArraySum` array, which contains the sum of every subarray of size `k`.
       while (i < nums.length) {
           windowSum += nums[i]; // Add the current element to the sliding window.

           if (i - j + 1 == k) { // If the window size becomes `k`:
               subArraySum[j] = windowSum; // Store the current window sum.
               windowSum -= nums[j]; // Slide the window by removing the leftmost element.
               j++; // Move the start of the window.
           }
           i++; // Expand the window from the right.
       }

       // Solve the problem recursively and build the list of indices.
       solve(subArraySum, 3, 0, k, list);

       // Convert the list of indices to an array of size 3 as the result.
       int[] result = new int[3];
       for (int idx = 0; idx < list.size(); idx++) {
           result[idx] = list.get(idx);
       }

       return result; // Return the result as an array of starting indices.
   }

   /**
    * Recursive function to solve the problem by selecting indices for subarrays.
    * 
    * @param subArraySum Array of subarray sums.
    * @param count Remaining number of subarrays to select.
    * @param idx Current index in `subArraySum`.
    * @param k Length of each subarray.
    * @param list List to store the indices of the selected subarrays.
    */
   public void solve(int[] subArraySum, int count, int idx, int k, List<Integer> list) {
       // Base case: If no subarrays are left to select or index goes out of bounds.
       if (count == 0) {
           return; // No more subarrays to select.
       }
       if (idx >= subArraySum.length) {
           return; // Reached the end of the array.
       }

       // Compute the scores for the two choices:
       // 1. Take the current index (`idx`) as a subarray starting point.
       int take_idx = subArraySum[idx] + helper(subArraySum, idx + k, count - 1, k);

       // 2. Skip the current index and consider the next index.
       int not_take_idx = helper(subArraySum, idx + 1, count, k);

       // Choose the option that maximizes the score, favoring lexicographically smaller indices.
       if (take_idx >= not_take_idx) {
           list.add(idx); // Add the current index to the list of selected subarray indices.
           solve(subArraySum, count - 1, idx + k, k, list); // Recur for the next subarray.
       } else {
           solve(subArraySum, count, idx + 1, k, list); // Recur for the next index.
       }
   }

   /**
    * Helper function for recursion + memoization.
    * Computes the maximum score of selecting a given number of subarrays starting from a given index.
    * 
    * @param subArraySum Array of subarray sums.
    * @param index Current index in the `subArraySum` array.
    * @param remainingSubArrays Remaining number of subarrays to select.
    * @param k Length of each subarray.
    * @return Maximum possible score.
    */
   public int helper(int[] subArraySum, int index, int remainingSubArrays, int k) {
       // Base case: No more subarrays to select or index out of bounds.
       if (remainingSubArrays == 0) {
           return 0; // No more score to add.
       }
       if (index >= subArraySum.length) {
           return Integer.MIN_VALUE; // Impossible state, return negative infinity.
       }

       // Return the memoized result if already computed.
       if (dp[index][remainingSubArrays] != -1) {
           return dp[index][remainingSubArrays];
       }

       // Compute the two choices:
       // 1. Take the subarray starting at the current index.
       int take = subArraySum[index] + helper(subArraySum, index + k, remainingSubArrays - 1, k);

       // 2. Skip the current index and consider the next index.
       int not_take = helper(subArraySum, index + 1, remainingSubArrays, k);

       // Memoize and return the maximum of the two choices.
       dp[index][remainingSubArrays] = Math.max(take, not_take);

       return dp[index][remainingSubArrays];
   }
   }