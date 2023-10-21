/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.Stack;

/**
 *https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * Solved by own good job parth; 
 * Date: 10/20/2023
 * @author parth
 */
public class RemoveAllAdjacentDuplicatesinString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(removeAdjacentDuplicates("azxxzy"));
    }
    public static String removeAdjacentDuplicates(String input){
       if(input.length() == 0){
           System.out.println("Nothing to remove..not a damn thing");
       }
       Stack<Character> stack = new Stack<>();
       for(int i = 0; i < input.length();i++){
          char currentChar = input.charAt(i);
          if(stack.isEmpty()){
              stack.push(currentChar);
          }else{
              char top = stack.peek();
              if(top!= currentChar){
                  stack.push(currentChar);
              } else{
                  stack.pop();
              }
          }         
       }
       String answer = "";
       while(!stack.isEmpty()){
           char currentchar = stack.pop();
           answer = answer + currentchar;
       }
       String reverse = "";
       for(int i = answer.length()-1; i>=0;i--){
           reverse = reverse + answer.charAt(i);
       }
        return reverse;
    }
    }
