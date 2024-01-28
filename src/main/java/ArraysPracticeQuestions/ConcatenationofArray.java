/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/concatenation-of-array/
 * Date: 01/27/2024
 * @author parth
 */
public class ConcatenationofArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("Hello World");
	int[] nums = {1,2,1};
	System.out.println(Arrays.toString(getConcatenation(nums)));
    }
    public static int[] getConcatenation(int[] nums){
	    int[] answer = new int[nums.length*2];
	    int i = 0;
	    int j = 0;
	    while(i < nums.length){
	        answer[i]= nums[i];
	        i++;
	    }
	    j = i;
	    for(int k = 0; k < nums.length;k++){
	        answer[j] = nums[k];
	        j++;
	    }
	    return answer;
	}
}
