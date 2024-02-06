/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * @author parth
 */
public class CheckIfNandItsDoubleExits {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    //Brute Force Complexity O(N^2);
    public  boolean checkIfExist(int[] arr) {
        Boolean A = helperA(arr);
        Boolean B = helperB(arr);

        return A || B;      
    }
    public boolean helperA(int[] arr){
        for(int i = 0; i < arr.length;i++){
           for(int j = i+1; j < arr.length;j++){
               if(arr[i] == 2 * arr[j] && i!=j){
                   return true;
               }
           }
       }
       return false;
    }

    public boolean helperB(int[] arr){
        for(int j = 0; j < arr.length;j++){
           for(int i = j+1; i < arr.length;i++){
               if(arr[i] == 2 * arr[j] && i!=j){
                   return true;
               }
           }
       }
       return false;
    }
    
    //Optimized using BinarySearch
    public boolean checkIfExistOptimized(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        for(int element : nums){
            if(element!=0){
                if(binarySearch(nums,2*element)){
                    return true;
                }
            }else{
                zeroCount++;
            }
        }
        return zeroCount >= 2;        
    }

    public static boolean binarySearch(int[] arr, int target){
        int low = 0;
        int end = arr.length -1;
        while(low <= end){
            int mid = low +(end-low)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                end = mid -1;
            }else{
                low = mid +1;
            }
        }
        return false;
    }
}
