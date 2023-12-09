/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

import java.util.Stack;

/**
 *https://leetcode.com/problems/parsing-a-boolean-expression/
 * Date: 12/08/2023
 * @author parth
 */
public class ParsingaBooleanExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello,World");
        boolean answer = evaluateBooleanExpression("&(|(f))");
        System.out.println(answer);
    }
    public static boolean evaluateBooleanExpression(String input){
       Stack<Character> result = new Stack<>();
       
       for(int i = 0; i < input.length();i++){
           char ch = input.charAt(i);
           if(ch == ','){
               continue;
           }
           else if(ch == ')'){
               boolean hasTrue = false;
               boolean hasFalse = false;
               while(result.peek() == 't' || result.peek() == 'f'){
                   if(hasTrue == false && result.peek() == 't'){
                        hasTrue = true;
                   }
                   if(hasFalse == false && result.peek() == 'f'){
                       hasFalse = true;
                   }
                   result.pop();
               }
              char operation = result.pop();
               if(operation == '&'){
                   if(hasFalse){
                       result.push('f');
                   }else{
                       result.push('t');
                   }
               }
               else if(operation == '|'){
                   if(hasTrue){
                       result.push('t');
                   }else{
                       result.push('f');
                   }
               }else { //operation == !
                   if(hasTrue){
                       result.push('f');
                   }else{
                       result.push('t');
                   }
               }
           }else if(ch != '('){
               result.push(ch);
           }      
       }
       return result.pop() == 't';
    }
}
