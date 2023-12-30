/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

import java.util.Arrays;

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
	Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);   
	}
}
