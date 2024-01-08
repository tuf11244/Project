/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 01/07/2023
 *https://leetcode.com/problems/orderly-queue/
 * @author parth
 */
public class OrderlyQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static String orderlyqueue(String s, int k){
	    /*Logic
	     1. if k = 1, you have to rotate first character piece by piece until you reach the last String 
	        Add all the string in list and sort the list and return the first element 
	     2. if k > 1 ; you just have to sort the String and return it */
	    
	    //if K is greater than 1 we just need to sort the String and return it 
	    if(k > 1){
	        char ch[] = s.toCharArray();
	        Arrays.sort(ch);
	        String result = "";
	        for(int i = 0; i < ch.length;i++){
	            result = result + ch[i];
	        }
	        return result;
	    }
	    
	    //if k = 1
	    List<String> list = new ArrayList<>();
	    for(int i = 0; i < s.length();i++){
	        String temp = s.substring(i) + s.substring(0,i);
	        list.add(temp);
	    }
	    Collections.sort(list);
	    
	    return list.get(0);
	}
}
