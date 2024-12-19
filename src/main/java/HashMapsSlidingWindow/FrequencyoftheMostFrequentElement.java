/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.Arrays;

/**
 *02/10/2024
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 * @author parth
 */
public class FrequencyoftheMostFrequentElement {

    /**
     * Logic 
 In the array {1,2,4} our goal is the maximize within the frequency within K moves 
 
 {1,2,4}; lets says we are trying to make element 3 than the prefixSum operations would 
 be 1 + 2 moves , and 2 + 1 moves : so prefixSum 3 moves because we cannot decrement a number 
 
 {1,2,4} : lets say we are trying to make element 5 than the prefixSum operations would 
 be 1 + 4 moves + 2 + 3 moves + 4 + 1 moves so prefixSum 8 moves
 
 so we will get the max frequency we are trying to make other numbers present in the array to one already present in the array
 in this case we are trying to convert 1 and 2 to element 4
 
 Sort the array 
 for example : the arr give is {1,8,13,4}
 lets say we are making all elements equal to 8 so the only 2 candidates eligible would be 1 and 4 because 13 can't be 8 as decrement is not allowed
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        long prefixSum = 0;  // To keep track of the sum of elements in the window
        int left = 0;
        int maxFrequency = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Add the current number to the prefixSum
            prefixSum += nums[right];
            
            // Check if the current window is valid
            // If not, shrink the window by moving `left`
            while (((long)(right - left + 1) * nums[right] ) - prefixSum > k) {
                prefixSum -= nums[left];
                left++;
            }
            
            // Update the max frequency
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }
        
        return maxFrequency;
    }

    
}
