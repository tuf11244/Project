/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 * Date: 12/15/2023
 *https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @author parth
 */
public class FindtheIndexoftheFirstOccurrenceinaString {
    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(strStr("sadbusted","ts"));
		
	}
    public static int strStr(String haystack, String needle){
	    if(haystack.length() < needle.length()){
	        return -1;
	    }
	    int pointer1 = 0;
	    int pointer2 = 0;
	    int answer =0;
	    while(pointer1 < haystack.length() && pointer2 < needle.length()){
	        if(haystack.charAt(pointer1) == needle.charAt(pointer2)){
	            if(pointer2 ==0){
	                answer = pointer1;
	            }
	            pointer1++;
	            pointer2++;
	        }else{
	            pointer1++;
	        }
	    }
	    if(pointer2 == needle.length()){
	        return answer;
	    }
	    if(pointer2 < needle.length()){
	        return -1;
	    }
	    
	    return -1;
	}
  
}
