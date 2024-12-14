/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 06/22/2024
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * https://leetcode.com/problems/continuous-subarrays/ (Date: 12/13/2024)
 * @author parth
 */
public class LongestContinuousSubarraywithAbsDiffLessthanorEqualtoLimit {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int longestSubarray(int[] arr, int limit) {
        // Deques to keep track of max and min values in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int start = 0;
        int maxLength = 0;
        
        for (int end = 0; end < arr.length; end++) {
            // Maintain the maxDeque to store maximums in decreasing order
            while (!maxDeque.isEmpty() && arr[end] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(arr[end]);

            // Maintain the minDeque to store minimums in increasing order
            while (!minDeque.isEmpty() && arr[end] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.addLast(arr[end]);

            // If the current window is invalid, move the start pointer to the right
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == arr[start]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == arr[start]) {
                    minDeque.pollFirst();
                }
                start++;
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
        
    }
}
