/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 *Date: 11/17/2023
 * https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 * @author parth
 */
public class NumberofStringsthatappearasSubstringsintheWord {

    public static void main(String args[]) {
       // System.out.println(helper("","abc"));
	String[] patterns = {"a","b","c"};
	System.out.println(numOfString(patterns,"aaaaabbbbb"));
    }
        
    public static int numOfString(String[] patterns, String word){
            int count = 0;
            for(int i = 0; i < patterns.length;i++){
                if(word.contains(patterns[i])){
                    count++;
                }
            }
            return count;
        }
}
