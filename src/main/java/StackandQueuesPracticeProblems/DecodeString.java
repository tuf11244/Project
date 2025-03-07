/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;


import java.util.Stack;

/**
 *Date: 10/24/2023
 * https://leetcode.com/problems/decode-string/
 * @author parth
 */
public class DecodeString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
     public static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(val);
                i--; // Adjust for increment in loop
            
            } else if (ch == '[') {
                st.push("["); // Push an opening bracket as a marker
            } else if (ch == ']') {
                // Construct the repeated string
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    sb.insert(0, st.pop()); // Maintain order
                }
                st.pop(); // Remove the '[' marker

                int count = numStack.pop();
                String repeated = sb.toString().repeat(count); // Repeat the extracted string

                st.push(repeated); // Push the expanded result back onto the stack
            } else { 
                // It's a letter, so push it onto the stack
                st.push(String.valueOf(ch));
            }
            i++;
        }

        // Construct final string from stack
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop()); // Maintain order
        }

        return result.toString();
    }
}
