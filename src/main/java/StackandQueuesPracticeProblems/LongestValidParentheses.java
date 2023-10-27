/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.Stack;

/**
 *https://leetcode.com/problems/longest-valid-parentheses/
 * Date: 10/27/2023
 * @author parth
 */
public class LongestValidParentheses {

    public static void main(String args[]) {
        System.out.println(longestValidParentheses("()((()()"));
    }
    public static int longestValidParentheses(String input) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1); // Push -1 as the base index into the stack
    int maxLength = 0;

    for (int i = 0; i < input.length(); i++) {
        char currentChar = input.charAt(i);
        if (currentChar == '(') {
            stack.push(i); // Push the index of '(' into the stack
        } else {
            stack.pop(); // Pop the top element from the stack (corresponding '(')
            if (!stack.isEmpty()) {
                maxLength = Math.max(maxLength, i - stack.peek());
            } else {
                stack.push(i); // Push the current index as the new base
            }
        }
    }

    return maxLength;
}

}
