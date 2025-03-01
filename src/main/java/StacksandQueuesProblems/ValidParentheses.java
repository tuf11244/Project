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
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 * @author parth
 */


public class ValidParentheses {

    public static void main(String[] args) {
       // String expression = "(){}[]";
       // System.out.println(validParentheses("(){}[]"));
        //System.out.println(minAddToMakeValid("{{"));
        System.out.println(minInsertions("())"));
        
    }

    public static boolean validParentheses(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);  //Only 1 set of parentheses need to be pushed to stack
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
//Method 2 for Question 2     
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
    //Method 3 for question 3 
    public static  int minInsertions(String s){
       int i = 0;
        Stack<Character> st = new Stack<>();
        int count = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else {
                // Handling ')'
                if (st.isEmpty()) {
                    count++; // Need one '(' before this ')'
                } else if (st.peek() == '(') {
                    st.pop(); // Pair with '('
                } else {
                    count++; // Need an extra ')'
                }

                // Check next character
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Skip next ')'
                } else {
                    count++; // Need one more ')' to balance single ')'
                }
            }

            i++;
        }

        // Each remaining '(' needs "2 )"
        while (!st.isEmpty()) {
            st.pop();
            count += 2;
        }

        return count;
   
}
}

