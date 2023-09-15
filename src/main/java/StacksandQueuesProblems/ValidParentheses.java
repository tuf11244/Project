/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Stack;
/**
 *Date: 09/14/2023
 * https://leetcode.com/problems/valid-parentheses/description/
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * @author parth
 */


public class ValidParentheses {

    public static void main(String[] args) {
       // String expression = "(){}[]";
        System.out.println(validParentheses("(){}[]"));
        System.out.println(minAddToMakeValid("{{"));
    }

    public static boolean validParentheses(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false; // There is no corresponding opening bracket.
                }

                char top = stack.pop();

                if (currentChar == ')' && top != '(') {
                    return false;
                }
                if (currentChar == '}' && top != '{') {
                    return false;
                }
                if (currentChar == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // Stack should be empty if all brackets are matched.
    }
    public static int minAddToMakeValid(String expression){
        int count = 0;
        Stack<Character> stack = new Stack<>();
        
         for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    count = count + 1;
                }

                char top = stack.pop();

                if (currentChar == ')' && top != '(') {
                    count = count + 1;
                }
                if (currentChar == '}' && top != '{') {
                    count = count + 1;
                }
                if (currentChar == ']' && top != '[') {
                    count = count + 1;
                }
            }
        }
        return count + stack.size();
       
}
}

