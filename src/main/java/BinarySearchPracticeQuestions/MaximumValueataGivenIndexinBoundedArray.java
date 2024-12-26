/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 02/10/2024
 *https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 * @author parth
 */
public class MaximumValueataGivenIndexinBoundedArray {

    /** The question is tough, it was asked by google revision would be needed
     * https://www.youtube.com/watch?v=d50vvNSrqfk
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int answer = maxValue(6,1,10);
        System.out.println(answer);
    }
    // Function to calculate the sum of elements in a sequence
    public static long getSumElements(long count, long val) {
        return val * count - (count * (count + 1)) / 2;
    }

    // Function to find the maximum value at a given index in a bounded array
    public static int maxValue(int n, int index, int maxSum) {
        long left = 1;
        long right = maxSum;
        long midVal;
        int result = 0;

        // Binary search to find the maximum value
        while (left <= right) {
            midVal = left + (right - left) / 2;

            // Calculate the sum of elements on the left side of the index in O(1)
            long leftCount = Math.min((long) index, midVal - 1);
            long leftSum = getSumElements(leftCount, midVal);
            leftSum += Math.max(0, index - (midVal - 1)); //For remaining Ones

            // Calculate the sum of elements on the right side of the index in O(1)
            long rightCount = Math.min((long) n - index - 1, midVal - 1);
            long rightSum = getSumElements(rightCount, midVal);
            rightSum += Math.max(0, n - index  - 1 - (midVal - 1)); //For remainign Ones

            // Check if the sum of both sides along with midVal is less than or equal to maxSum
            if (leftSum + rightSum + midVal <= maxSum) {
                // Update the result with the maximum value found so far
                result = (int) Math.max(result, midVal);
                // Move the search to the right side
                left = midVal + 1;
            } else {
                // If the sum is greater than maxSum, move the search to the left side
                right = midVal - 1;
            }
        }

        // Return the final result
        return result;
    }
}
