/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/valid-palindrome-ii/
 * Date:12/15/2023
 * @author parth
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(validPalindromeII("abca"));
	
	}
	public static boolean validPalindromeII(String s){
	   int start = 0;
	   int end = s.length()-1;
	   while(start <= end){
	       if(s.charAt(start) == s.charAt(end)){
	           start++;
	           end--;
	       }else{
	           return isPalindrome(s,start+1,end) || isPalindrome(s,start,end-1);
	       }
	       
	       if(start > end){
	           return true;
	       }
	   }
	   return false;
	}
	public static boolean isPalindrome(String s, int start, int end){
	    while(start <= end){
	        if(s.charAt(start) == s.charAt(end)){
	            start++;
	            end--;
	        }
	        if(start > end){
	            return true;
	        }
	    }
	    return false;
	}
}
