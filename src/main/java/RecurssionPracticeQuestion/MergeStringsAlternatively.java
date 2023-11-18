/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *Date: 11/17/2023
 * https://leetcode.com/problems/merge-strings-alternately/
 * @author parth
 */
public class MergeStringsAlternatively {

   
    public static void main(String args[]) {
        System.out.println("Hello World");
	System.out.println(mergeAlernatively("abcd","pq"));
    }
    public static String mergeAlernatively(String word1, String word2){
	    String merge = "";
	    return helper(merge,word1,word2);
	}
	private static String helper(String merge,String word1,String word2){
	    if(word1.length() == 0 && word2.length() == 0){
	        return merge;
	    }
	    if(word1.length() == 0 && word2.length() != 0){
	        return merge + word2;
	    }
	    if(word1.length() != 0 && word2.length() == 0){
	        return merge + word1;
	    }
	    merge = merge + word1.charAt(0) + word2.charAt(0);
	    return helper(merge,word1.substring(1),word2.substring(1));
	  
	}
}
