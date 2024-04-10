/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 *Date: 04/10/2024
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 * @author parth
 */
public class MaximumSumofDistinceSubarrayswithSizeK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {1,5,4,2,9,9,9};
        maximumSubarraySum(nums,3);
    }
    public static long maximumSubarraySum(int[] nums, int k) {
      long maxSum = 0;
      long currentSum = 0;
      int i = 0; 
      int j = 0;
      HashSet<Integer> set = new HashSet<>();
        while(i < nums.length){

            while(j < nums.length && set.size() < k && !set.contains(nums[j])){
                set.add(nums[j]);
                currentSum = currentSum + nums[j];
                j++;
            }
            if(set.size() == k){
                maxSum = Math.max(currentSum,maxSum);
            }

            //Reduce the the size of window
            currentSum = currentSum - nums[i];
            set.remove(nums[i]);
            i++;
        } 
        return maxSum;
    }
}
