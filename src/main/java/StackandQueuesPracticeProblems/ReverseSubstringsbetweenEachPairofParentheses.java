/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 07/10/2024
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @author parth
 */
public class ReverseSubstringsbetweenEachPairofParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public String reverseParentheses(String s) {
       Stack<Character> st = new Stack<>();
       Queue<Character> queue = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') { // Trigger point
                while (st.peek() != '(') {
                    queue.add(st.pop());
                }
                st.pop(); // to pop the '(' bracket 
                while (!queue.isEmpty()) {
                    st.push(queue.poll());
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString(); 
    }
}
