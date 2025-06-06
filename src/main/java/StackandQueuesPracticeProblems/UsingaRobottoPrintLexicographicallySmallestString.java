/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 06/06/2025
 * https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 * @author parth
 */
public class UsingaRobottoPrintLexicographicallySmallestString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public String robotWithString(String s) {
        int n = s.length();
        char[] minCharRight = new char[n];
        minCharRight[n - 1] = s.charAt(n - 1);

        // Step 1: Precompute the minimum character to the right
        for (int i = n - 2; i >= 0; i--) {
            minCharRight[i] = (char) Math.min(s.charAt(i), minCharRight[i + 1]);
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Step 2: Simulate the robot operation
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            stack.push(c);

            while (!stack.isEmpty() && stack.peek() <= minCharRight[Math.min(i + 1, n - 1)]) {
                result.append(stack.pop());
            }
        }

        // Step 3: Empty the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
