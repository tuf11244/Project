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
        Stack<Integer> stack = new Stack<>();
        int maxK = Integer.MIN_VALUE;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                maxK = stack.pop();
            }
            stack.push(nums[i]);
        }
        
        return false;
    }
}
