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
		System.out.println(strStr("etcode","co"));
		
	}
    public static int strStr(String haystack, String needle){
	int length = needle.length();

        for(int i = 0; i < haystack.length();i++){
          if(length > haystack.length()){
              return -1;
          }
          String substring = haystack.substring(i,length);
          if(substring.equals(needle)){
              return i;
          }
          length++;
      }
      return -1;
	}
    
    public static int optimizedStrStr(String hayStack, String needle){
        if(hayStack.contains(needle)){
            return hayStack.indexOf(needle);
        }
        return -1;
    }
  
}
