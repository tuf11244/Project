/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Date: 09/11/2023
 * Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * @author parth
 */
public class LargestAreaHistogram {
    
    /**
     * Function to calculate the largest rectangular area in a histogram.
     * @param heights an array representing the heights of histogram bars
     * @return the maximum area of any rectangle in the histogram
     */
    public int largestRectangleArea(int[] heights) {
        
        // Arrays to store the nearest smaller index on the left and right
        int[] nearestSmallerIdxOnLeft = function1(heights);
        int[] nearestSmallerIdxOnRight = function2(heights);

        int maxHeight = 0; // Variable to store the maximum rectangular area

        // Iterate through each bar in the histogram
        for(int i = 0; i < heights.length; i++){
            // Calculate width using the nearest smaller elements on both sides
            int width = nearestSmallerIdxOnRight[i] - nearestSmallerIdxOnLeft[i] - 1;
            int heightOfHistogram = heights[i];

            // Update the maximum area found so far
            maxHeight = Math.max(maxHeight, heightOfHistogram * width);
        }

        return maxHeight;
    }

    /**
     * Function to find the index of the nearest smaller element to the left for each bar.
     * @param heights array representing the histogram
     * @return an array where arr[i] contains the index of the nearest smaller element on the left of heights[i]
     */
    public int[] function1(int[] heights) {
        int[] arr = new int[heights.length]; // Array to store results

        arr[0] = -1; // The first element has no smaller element on the left, so set it to -1

        Stack<Integer> st = new Stack<>(); // Stack to maintain indices
        st.push(0); // Push the first index

        // Iterate through the heights array
        for(int i = 1; i < heights.length; i++) {

            // Pop elements from stack while they are greater than or equal to the current element
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If stack is empty, it means there is no smaller element on the left
            if(st.isEmpty()) {
                arr[i] = -1;
            } else {
                arr[i] = st.peek(); // The top element is the nearest smaller element
            }

            st.push(i); // Push the current index onto the stack
        }

        return arr;
    }

    /**
     * Function to find the index of the nearest smaller element to the right for each bar.
     * @param heights array representing the histogram
     * @return an array where arr[i] contains the index of the nearest smaller element on the right of heights[i]
     */
    public int[] function2(int[] heights) {
        int[] arr = new int[heights.length]; // Array to store results

        // The last element has no smaller element on the right, so set it to the length of the array
        arr[arr.length - 1] = arr.length; 

        Stack<Integer> st = new Stack<>(); // Stack to maintain indices
        st.push(arr.length - 1); // Push the last index

        // Iterate from right to left
        for(int i = heights.length - 2; i >= 0; i--) {

            // Pop elements from stack while they are greater than or equal to the current element
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If stack is empty, it means there is no smaller element on the right
            if(st.isEmpty()) {
                arr[i] = heights.length; 
            } else {
                arr[i] = st.peek(); // The top element is the nearest smaller element
            }

            st.push(i); // Push the current index onto the stack
        }

        return arr;
    }
}
