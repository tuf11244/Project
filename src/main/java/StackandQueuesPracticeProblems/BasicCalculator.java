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
public class BasicCalculator {

    //https://leetcode.com/problems/basic-calculator/
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	public static int calculate(String S){
	   int sum = 0;
	   int sign = 1;
	   
	   Stack<Integer> stack = new Stack<>();
	   
	   for(int i = 0; i < S.length();i++){
	       char ch = S.charAt(i);
	        if(Character.isDigit(ch)){
	           int value = 0;
	           while(i < S.length() && Character.isDigit(S.charAt(i))){
	               value = value*10 + (S.charAt(i) - '0');
	               i = i+1;
	           }
	           i = i -1;
	           value = value * sign;
	           sum = sum + value;
	           sign = 1;
	       } else if(ch == '('){
	           stack.push(sum);
	           stack.push(sign);
	           
	           //Reset the sum and sign to 0 and 1 to begin calculating what's inside the parantheses
	           sum = 0;
	           sign = 1;
	           
	       } else if(ch == ')'){
	           //Getting out of the parantheses we have to multiply the sum with the sign;
	           sum = sum * stack.pop();
	           
	           //Also update the Sum 
	           sum = sum + stack.pop();
	           
	           
	       } else if(ch == '-'){
	           //if ch is negative than we need to update the sign
	           sign = sign * -1;
	       }
	   }
	   return sum;
	}

	
}

