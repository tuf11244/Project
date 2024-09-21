/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;

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
}
