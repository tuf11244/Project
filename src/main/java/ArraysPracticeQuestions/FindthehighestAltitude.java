/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/find-the-highest-altitude/
 * @author parth
 */
public class FindthehighestAltitude {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
       System.out.println("Hello World");
	int[] arr = {-5,1,5,0,-7};
	largestAltitude(arr);
    }
    public static void largestAltitude(int[] arr){
	    int[] gain = new int[arr.length + 1];
	    gain[0] = 0;
	    for(int i = 1; i < gain.length;i++){
	        gain[i] = gain[i-1] + arr[i-1];
	    }
	    System.out.println(Arrays.toString(gain));
	    
	    int max = Integer.MIN_VALUE;
	    
	    for(int altitude : gain){
	        max = Math.max(altitude,max);
	    }
	    System.out.println(max);
	    
	}
}
