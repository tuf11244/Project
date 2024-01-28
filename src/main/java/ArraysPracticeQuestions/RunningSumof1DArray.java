/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 01/28/2024
 *https://leetcode.com/problems/running-sum-of-1d-array/
 * @author parth
 */
public class RunningSumof1DArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("Hello World");
	int[] arr = {3,1,2,10,1};
	System.out.println(Arrays.toString(runningSum(arr)));
    }
    public static int[] runningSum(int[] arr){
	   int sum = 0;
	   int[] sumArray = new int[arr.length];
	   for(int i = 0; i < sumArray.length;i++){
	        sum = sum + arr[i];
	        sumArray[i] = sum;
	   }
	   return sumArray;
	}
}
