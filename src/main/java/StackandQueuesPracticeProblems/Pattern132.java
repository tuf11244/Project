/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

//https://leetcode.com/problems/132-pattern/
import java.util.Arrays;
import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        int[] arr = {1,3,2,0};
        System.out.println(find132pattern(arr));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int thirdElement = Integer.MIN_VALUE;  // Represents the "2" in the "132" pattern

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // If we find a "1" (nums[i] < thirdElement), return true
            if (nums[i] < thirdElement) return true;

            // Maintain a decreasing stack and find the potential "2"
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                thirdElement = stack.pop();  // Pop from stack → found a valid "2"
            }

            stack.push(nums[i]);  // Push current element as potential "3"
        }

        return false;
    }
}
