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
    
    
    public static int longestValidParenthesesConstantSpace(String input){
        int open = 0;
        int close = 0;
        int maxLength = 0;
        
        //We traverse the string from 0 to n
        for(int i = 0; i < input.length();i++){
            char ch = input.charAt(i);
            
            if(ch == '('){
                open++;
            }else{
                close++;
            }
            
            if(open == close){ //Means it valid 
                maxLength = Math.max(open+close,maxLength);
            }else if(close > open){
                //Reset the open and close 
                open = 0;
                close = 0;
            }
        }
        
        open = 0;
        close = 0;
        //We traverse the string from n to 0;
        for(int i = input.length()-1; i >= 0; i--){
            char ch = input.charAt(i);
            
            if(ch == '('){
                open++;
            }else{
                close++;
            }
            
            if(open == close){ //Means it valid 
                maxLength = Math.max(open+close,maxLength);
            }else if(open > close){
                //Reset the open and close 
                open = 0;
                close = 0;
            }
        }
        return maxLength;
    }

}
