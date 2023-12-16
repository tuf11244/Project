/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 * Date: 12/15/2023
 *https://leetcode.com/problems/length-of-last-word/
 * @author parth
 */
public class LengthofLastWord {
    public static void main(String[] args) {
		System.out.println("Hello World");
		String input = "my name is Parth";
		System.out.println(lengthoflastword(input));
	}
    public static int lengthoflastword(String input){
	    int count = 0;
	    for(int i = input.length() -1; i >= 0; i--){
	        char ch = input.charAt(i);
	        if(ch!=' '){
	            count = count+1;
	        }
	        if(ch == ' '){
	            break;
	        }
	    }
	    return count;
	}
   
}
