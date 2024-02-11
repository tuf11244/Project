/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 02/10/2024
 *https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
 * @author parth
 */
public class MinimumAbsoluteDifferencewithConstraint {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,3,2,10,15};
        int x = 1;
        minAbsoluteDifference(arr,x);
    }
    public static void minAbsoluteDifference(int[] arr, int x){
        int result = Integer.MAX_VALUE;
        for(int j = arr.length-1; j-x >= 0; j--){
            result = Math.min(result,Math.abs(binarySearch(arr,j,0,j-x) - arr[j]));
        }
        System.out.println("The lowest absolute difference is " +  result);;
    }
    public static int binarySearch(int[] arr, int element,int low, int end){
       int[] copiedArray = Arrays.copyOfRange(arr, low, end+1);
       Arrays.sort(copiedArray);
       System.out.println(Arrays.toString(copiedArray));
       int start = 0;
       int high = copiedArray.length - 1;
       if(copiedArray.length == 1){
           return copiedArray[0];
       }
       if(copiedArray.length == 0){
           return 0;
       }
       while(start <= high){
           int mid = start + (high - start)/2;
           if(copiedArray[mid] == arr[element]){
                return copiedArray[mid];
           }else if(copiedArray[mid] < arr[element]){
               start = mid + 1;
           }else{
               high = mid -1 ;
           }
       }
        return copiedArray[high];
       
       
    }
}
