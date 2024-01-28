/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @author parth
 */
public class HowManyNumbersareSmallerThanTheCurrentNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("Hello World");
	int[] arr = {6,5,4,8};
	System.out.println(Arrays.toString(smallerNumbers(arr)));
    }
    public static int[] smallerNumbers(int[] arr){
	    int[] smallerNumbers = new int[arr.length];
	    for(int i = 0; i < smallerNumbers.length;i++){
	        int count = 0;
	        for(int j = 0; j < smallerNumbers.length;j++){
	                if(arr[i] > arr[j]){
	                    count = count+1;
	                }
	           
	        }
	        smallerNumbers[i] = count;
	    }
	    return smallerNumbers;
	}
}
