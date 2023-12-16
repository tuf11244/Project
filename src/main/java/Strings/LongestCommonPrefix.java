/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/longest-common-prefix/
 * Date: 12/15/2023
 * @author parth
 */
public class LongestCommonPrefix {

   public static void main(String[] args) {
		System.out.println("Hello World");
		String[] strs = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
	}
    public static String longestCommonPrefix(String[] strs){
	    ArrayList<String> list = new ArrayList<>();
	    int i = 0;
	    int n = strs[0].length();
	    while(i <= n){
	        String prefix = strs[0].substring(0,i);
	        boolean allcontainsPrefix = true;
	            for(int j = 1; j < strs.length;j++){
	                if(!strs[j].contains(prefix)){
	                    allcontainsPrefix = false;
	                    break;
	                }
	            }
	           if (!allcontainsPrefix) {
                break;
                 }
                if(allcontainsPrefix){
                    list.add(prefix);
                }
	           i++; 
	        }
	     System.out.println(list);
	     if(list.size()!=0){
	         return list.get(list.size()-1);
	     }
	    return ""; 	    
	}
}
