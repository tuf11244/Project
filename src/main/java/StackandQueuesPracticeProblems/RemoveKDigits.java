/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date : 10/06/2024
 *https://leetcode.com/problems/remove-k-digits/
 * @author parth
 */
public class RemoveKDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        // Traverse through the digits of the number
        for (char ch : num.toCharArray()) {
            // While we can remove digits (k > 0) and the current digit is smaller than the top of the stack, pop the stack
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        // If there are still digits to remove (k > 0), remove them from the end
        while (k > 0) {
            st.pop();
            k--;
        }
        
        // Build the result string
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        // Reverse the string as we built it backwards
        sb.reverse();
        
        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        // Return the result, or "0" if empty
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
