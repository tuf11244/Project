/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *02/10/2024
 * 
 * @author parth
 */
public class FrequencyoftheMostFrequentElement {

    /**
     * Logic 
     * In the array {1,2,4} our goal is the maximize within the frequency within K moves 
     * 
     * {1,2,4}; lets says we are trying to make element 3 than the total operations would 
     * be 1 + 2 moves , and 2 + 1 moves : so total 3 moves because we cannot decrement a number 
     * 
     * {1,2,4} : lets say we are trying to make element 5 than the total operations would 
     * be 1 + 4 moves + 2 + 3 moves + 4 + 1 moves so total 8 moves
     * 
     * so we will get the max frequency we are trying to make other numbers present in the array to one already present in the array
     * in this case we are trying to convert 1 and 2 to element 4
     * 
     * Sort the array 
     * for example : the arr give is {1,8,13,4}
     * lets say we are making all elements equal to 8 so the only 2 candidates eligible would be 1 and 4 because 13 can't be 8 as decrement is not allowed
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int maxFrequency(int[] nums, int k) {
        int frequency = 0;
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int targetIndex = 0; targetIndex < nums.length; targetIndex++) {
            frequency = Math.max(frequency, binarySearch(nums, k, targetIndex, prefixSum));
        }
        return frequency;
    }

    public static int binarySearch(int[] nums, int k, int targetIndex, long[] prefixSum) {
        int target = nums[targetIndex];
        int low = 0;
        int end = targetIndex;
        int result = 0;
        while (low <= end) {
            int mid = low + (end - low) / 2;
            //Total number of element from mid to targetIndex (up to and including targetIndex)
            long count = targetIndex - mid + 1;
            //Total Window Sum ;
            //for example : arr = {1,4,8,13};
            //lets say are arr[targetIndex] = 8;
            //we are trying to convert elements from 1,4,8 to 8 
            //so the windowSum = 8 * 3 = 34
            //3 is nothing but the count we obtained from previous step 
            long windowSum = target * count;
            //Total Current Sum 
            //lets say arr = {1,3,7,9,10}
            //prefix sum for arr = {1,4,11,20,30};
            //Let say if somebody asks us to find out the sum from index 1 to index 3 i.e 3 + 7 + 9 = 19
            // we can get form the prefix sum also prefix[3] - prefix[1] + arr[1]
            //                           which is 20 - 4 + 3 = 19
            long currentSum = prefixSum[targetIndex] - prefixSum[mid] + nums[mid];
            if (windowSum - currentSum <= k) {
                //could be possible answer, now lets make the window little bit longer
                result = mid;
                end = mid - 1;
            } else {
                //need to shorted the window becauase its taking more than k operations 
                low = mid + 1;
            }
        }
        //we are returning the length from result to targetIndex 
        //as all the elements are equal to arr[targetIndex} within k operations 
        return targetIndex - result + 1;
    }
}
