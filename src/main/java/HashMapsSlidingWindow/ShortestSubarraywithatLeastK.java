/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 11/16/2024
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * @author parth
 */
public class ShortestSubarraywithatLeastK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    public int shortestSubarray(int[] nums, int k) {
        
      // Deque to maintain indices of prefix sums in a monotonic increasing order
        Deque<Integer> deque = new LinkedList<>();
        
        // Array to store prefix sums, used to calculate the sum of subarrays efficiently
        long[] prefixSum = new long[nums.length];
        
        // Initialize the result to a value larger than the array size
        // This acts as a sentinel to check if a valid subarray was found
        int result = nums.length + 1;

        // Pointers for traversing the array
        int i = 0;

        // Iterate through the array
        while (i < nums.length) {
            // Calculate the prefix sum for the current index
            if (i == 0) {
                prefixSum[i] = (long) nums[0]; // First element is its own prefix sum
            } else {
                prefixSum[i] = prefixSum[i - 1] + (long) nums[i];
            }

            // Check if the subarray [0..i] satisfies the condition
            if (prefixSum[i] >= k) {
                result = Math.min(result, i + 1); // Subarray length is i+1 (0-based indexing)
            }

            // Shrink the window from the left by removing indices from the deque
            // If the difference between the current prefix sum and the smallest in deque >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.peekFirst()); // Update result
                deque.pollFirst(); // Remove the leftmost index as it's processed
            }

            // Remove indices from the deque if the current prefix sum is less than or equal to
            // the prefix sum at the back of the deque (to maintain monotonicity)
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast(); // Remove the last element to maintain monotonicity
            }

            // Add the current index to the deque
            deque.add(i);

            // Move to the next index
            i++;
        }

        // If result was not updated, no valid subarray was found
        return result == nums.length + 1 ? -1 : result;  
      
        
    }
}
