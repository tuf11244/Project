/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.Stack;

/**
 *
 * @author parth
 */
public class RemoveOuterMostParentheses {

    /*
     * Date:10/20/2023
     * https://leetcode.com/problems/remove-outermost-parentheses/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(removeOuterBrackets("(()())(())"));
        // TODO code application logic here
    }
    public static String removeOuterBrackets(String input) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
        char currentChar = input.charAt(i);
        if (currentChar == '(') {
            if (!stack.isEmpty()) {
                sb.append(currentChar);
            }
            stack.push(currentChar);
        } else {
            stack.pop();
            if (!stack.isEmpty()) {
                sb.append(currentChar);
            }
        }
    }
    return sb.toString();
}

}
