/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 *Date: 11/17/2023
 * https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 * @author parth
 */
public class NumberofStringsthatappearasSubstringsintheWord {

    public static void main(String args[]) {
        System.out.println(helper("","abc"));
	String[] patterns = {"a","a","a"};
	System.out.println(numberofString(patterns,"ab"));
    }
    public static List<String> helper(String processed,String unprocessed){
	    List<String> answer = new ArrayList<>();
	    if(unprocessed.isEmpty()){
	        answer.add(processed);
	        return answer;
	    }
	    char ch = unprocessed.charAt(0);
	    List<String> left = helper(processed,unprocessed.substring(1));
	    List<String> right = helper(processed+ch,unprocessed.substring(1));
	    left.addAll(right);
	    return left;
	}
	public static int numberofString(String[] patterns,String word ){
	    int count = 0;
	    List<String> result = helper("",word);
	    for(int i = 0; i < result.size();i++){
	        for(String element : patterns){
	            if(element.equals(result.get(i))){
	                count = count + 1;
	            }
	        }
	    }
	    return count;
	}
}
