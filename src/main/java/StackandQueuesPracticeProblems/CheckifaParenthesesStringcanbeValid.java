package StackandQueuesPracticeProblems;

import java.util.*;

/**
 * Date: 01/11/2025
 * This program solves the problem of checking if a parentheses string 
 * can be valid based on whether certain positions in the string 
 * can be locked (unchangeable) or unlocked (changeable).
 * Problem Link: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
 * Author: Parth
 */
public class CheckifaParenthesesStringcanbeValid {

    /**
     * Main method serves as the entry point of the program. 
     * It contains the application logic for testing the function.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        // TODO: Add testing logic here if needed.
    }
    
    /**
     * Determines if a given parentheses string `s` can be valid after modifications.
     * The string `locked` specifies whether a character in `s` can be modified (`0` means modifiable, `1` means locked).
     *
     * @param s      the parentheses string consisting of '(' and ')'
     * @param locked the string of '0's and '1's indicating modifiability of positions in `s`
     * @return true if the parentheses string can be made valid; otherwise, false
     */
    public static boolean canbeValid(String s, String locked) {
        
        // Stack to store the indices of open brackets that cannot be changed
        Stack<Integer> open = new Stack<>();
        
        // Stack to store the indices of brackets (either open or close) that can be modified
        Stack<Integer> openClose = new Stack<>();
        
        // If the length of the string is odd, it is impossible to balance it
        if (s.length() % 2 != 0) {
            return false;
        }
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            
            // If the current character is modifiable, add its index to the openClose stack
            if (locked.charAt(i) == '0') {
                openClose.add(i);
            }
            // If the current character is an open bracket and is locked, add its index to the open stack
            else if (s.charAt(i) == '(') {
                open.add(i);
            }
            // If the current character is a close bracket and is locked
            else if (s.charAt(i) == ')') {
                // First attempt to balance it with a previously added open bracket (locked)
                if (!open.isEmpty()) {
                    open.pop();
                }
                // If no locked open bracket exists, try balancing with a modifiable character
                else if (!openClose.isEmpty()) {
                    openClose.pop();
                }
                // If no brackets are available for balancing, the string cannot be valid
                else {
                    return false;
                }
            }
        }
        
        // Post-traversal: Balance remaining open brackets with modifiable ones
        // Ensure that open brackets on the left can only be balanced by brackets on the right
        while (!open.isEmpty() && !openClose.isEmpty() && open.peek() < openClose.peek()) {
            open.pop();       // Remove a locked open bracket
            openClose.pop();  // Remove a modifiable bracket
        }
        
        // If all locked open brackets are balanced, the string can be valid
        return open.isEmpty();
    }
}
