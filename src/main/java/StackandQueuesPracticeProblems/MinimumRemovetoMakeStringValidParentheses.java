/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 10/02/2024
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * @author parth
 */
public class MinimumRemovetoMakeStringValidParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();  // To track indices of '('
        HashSet<Integer> invalidIndices = new HashSet<>();  // To track all invalid indices

        // First pass: Mark invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);  // Store the index of '('
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    invalidIndices.add(i);  // Mark unmatched ')' as invalid
                } else {
                    stack.pop();  // Pop the matched '(' from the stack
                }
            }
        }

        // If the stack is not empty, it means there are unmatched '('
        while (!stack.isEmpty()) {
            invalidIndices.add(stack.pop());  // Mark unmatched '(' as invalid
        }

        // Second pass: Build the result string, skipping invalid parentheses
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndices.contains(i)) {
                result.append(s.charAt(i));  // Append valid characters only
            }
        }

        return result.toString();
    }
}
