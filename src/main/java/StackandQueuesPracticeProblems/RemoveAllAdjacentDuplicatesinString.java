/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.Stack;

/**
 *https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author parth
 */
public class RemoveAllAdjacentDuplicatesinString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(removeAdjacentDuplicates("abbaca"));
    }
    public static String removeAdjacentDuplicates(String input){
        if(input.length() == 0){
            return "";
        }
        String answer = input.charAt(input.length()-1) + "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length()-1;i++){
            stack.push(input.charAt(i));
        }
        while(!stack.isEmpty()){
            if(stack.peek()!=answer.charAt(0)){
            answer = answer + stack.peek();
            }else{
                 stack.pop();
              }
        }
        return answer;
    }
    }
