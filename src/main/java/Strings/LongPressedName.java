/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 * Date: 12/15/2023
 *https://leetcode.com/problems/long-pressed-name/
 * @author parth
 */
public class LongPressedName {
    
    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(longPressedName("saeed","ssaaedd"));
		
	}
    public static boolean longPressedName(String word, String typed){
	    int pointer1 = 0;
	    int pointer2 = 0;
	    
	    while(pointer1 < word.length() && pointer2 < typed.length()){
	        if(word.charAt(pointer1) == typed.charAt(pointer2)){
	            pointer1++;
	            pointer2++;
	            continue;
	        }
	        if(pointer1 > 0 && word.charAt(pointer1 - 1) == typed.charAt(pointer2)){
	            pointer2++;
	        }else{
	            return false;
	        }
	    }
	    if(pointer1 < word.length()){
	        return false;
	    }
	    while(pointer2 < typed.length()){
	        if(word.charAt(word.length()-1) != typed.charAt(pointer2)){
	            return false;
	        }else{
	            pointer2++;
	        }
	    }
	    return true;
	}
}
