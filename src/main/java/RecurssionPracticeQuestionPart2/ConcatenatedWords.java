/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/concatenated-words/
import java.util.List;
import java.util.ArrayList;

public class ConcatenatedWords{
	public static void main(String[] args) {
		System.out.println("Hello World");
		String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		List<String> answer = concatenatedWords(words);
		
		System.out.println(answer);
	}
	
	public static List<String> concatenatedWords(String[] words){
	    List<String> answer = new ArrayList<>();
	    List<String> duplicateList = new ArrayList<>();
	    
	    //Add the all words from array to another ArrayList duplicateList
	    for(String element : words){
	        duplicateList.add(element);
	    }
	    
	    for(String word : words){
	  	    //Create a new function which checks if the word when broken down is present in the duplicateList;
	        if(isConcatenated(duplicateList,word)){
	            answer.add(word);
	        }
	    }
	    
	    return answer;
	}
	public static boolean isConcatenated(List<String> duplicateList, String word){
	    for(int i = 0; i < word.length();i++){
	        String prefix = word.substring(0,i+1);
	        String remaining = word.substring(i+1);
	        //Below condition checks if both prefix and remaining part are present in duplicateList than return true 
	        //Also apply recursion on the remaining string so that it is broken down again
	        if(duplicateList.contains(prefix) && duplicateList.contains(remaining) || isConcatenated(duplicateList,remaining)){
	            return true;
	        }
	    }
	    return false;
	}
}