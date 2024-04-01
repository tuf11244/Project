/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 02/07/2024
 * https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
 * Date: 04/01/2024
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author parth
 */
public class MedianofaRowWiseSortedMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {1,3,4},
            {2,5,6},
            {7,8,9}
        };
        median(arr);
    }
    public static void median(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        
        //Total number of elements 
        int size = rows * columns;
        int low = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        for(int i = 0; i < rows;i++){
            low = Math.min(arr[i][0], low);
            end = Math.max(arr[i][columns-1], end);
        }
        while(low <= end){
            int mid = low + (end - low)/2;
            int smallerThanEqualTo = helper(arr,mid);
            if(smallerThanEqualTo <= size/2){
                low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        System.out.println(low);
    }
    
    public static void kthSmallest(int[][] arr, int k){
        int rows = arr.length;
        int columns = arr[0].length;
        
        int low = arr[0][0];
        int end = arr[rows-1][columns-1];
        
        while(low<= end){
            int mid = low +(end - low)/2;
            int smallerThanEqualTo = helper(arr,mid);
            if(smallerThanEqualTo < k){
                low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(low);
    }
    
    public static int helper(int[][] arr, int mid){
    int count = 0;
    for(int i = 0; i < arr.length;i++){
        count = count + cieling(arr[i],mid);
    }
    
    return count;
    }
    public static int cieling(int[] arr, int target){
        int low = 0;
        int end = arr.length-1;
        while(low <= end){
         int  mid = low + (end - low)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

}

