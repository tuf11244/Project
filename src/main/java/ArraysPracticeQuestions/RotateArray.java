/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 *Date: 01/24/2024
 * https://leetcode.com/problems/rotate-array/
 * @author parth
 */
public class RotateArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
       // rotate(arr,3);
       rotateOptimized(arr,-1);
        System.out.println(Arrays.toString(arr));
    }
    
    //Passes 37/38 test cases on LeetCode
    public static void rotate(int[] arr, int k){
        k = k % arr.length;
        int i = arr.length-1;
        int j = arr.length-2;
        while(k > 0){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            swap(arr,i,j);
            k--;
        }
    }
    public static void swap(int[] arr, int first, int second){
        while(second!=0){
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
            first--;
            second--;
    }
    }
    
    //Passes all the test cases ..submitted on LeetCode
    public static  void rotateOptimized(int[] arr, int k) {
    int n = arr.length;
    if(k < 0){
        k = k + n;
    }
    k = k % n;
    
    //Reverse the entire Array -- Part 1
    reverse(arr, 0, n - 1);
    //Reverse the array from index 0 to k-1 -- Part 2
    reverse(arr, 0, k - 1);
    //Reverse the array from index k to n-1 -- Part 3
    reverse(arr, k, n - 1);
    }
    public static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
}
