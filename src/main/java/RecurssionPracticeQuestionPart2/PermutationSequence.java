/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
//https://leetcode.com/problems/permutation-sequence/
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author parth
 */
public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println("Hello World");
	String answer = makeString(4,"");
        ArrayList<String> list = new ArrayList<>();

           permutations("",answer,list);
            Collections.sort(list); 
            System.out.println(list);

            String result = getPermutation(list,9);
            System.out.println(result);
	}
	public static String makeString(int n,String answer){
	    if(n == 1){
	        answer = answer + Integer.toString(n);
	        return answer;
	    }
	    answer = answer + Integer.toString(n);
	    return makeString(n-1,answer);
	}
	public static void permutations(String processed,String unprocessed, ArrayList<String> list){
	    if(unprocessed.length() == 0){
	        list.add(processed);
	        return;
	    }
	    char ch = unprocessed.charAt(0);
	    for(int i = 0; i <= processed.length();i++){
	        String first = processed.substring(0,i);
	        String second = processed.substring(i,processed.length());
	        permutations(first+ch+second,unprocessed.substring(1),list);
	    }
	}
	public static String getPermutation(ArrayList<String> list, int k){
	    for(int i = 0; i < list.size();i++){
	        if(i == k-1){
	            return list.get(i);
	        }
	    }
	    return "null";
	}
	
}

