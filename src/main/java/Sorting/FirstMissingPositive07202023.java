/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 * https://leetcode.com/problems/first-missing-positive/
 */
package Sorting;

import java.util.Arrays;

/**
 *
 * @author parth
 */
public class FirstMissingPositive07202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {3,4,-1,1};
        System.out.println(firstMissingPositiveNumber(arr));
        // TODO code application logic here
    }
     public static int firstMissingPositiveNumber(int[]arr){ 
        int i = 0;
        while(i < arr.length){
            int correctIndex  = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]){
               int temp = arr[i];
               arr[i] = arr[correctIndex];
               arr[correctIndex] = temp;
            }
            else{
               i++;
            }
        } 
        System.out.println(Arrays.toString(arr));
        for(int index = 0; index < arr.length;index++){
            if(arr[index] != index + 1){
                return index + 1;
            }
        }           
     return arr.length + 1;   
    }
}
