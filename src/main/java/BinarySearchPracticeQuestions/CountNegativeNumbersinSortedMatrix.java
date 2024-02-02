/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *
 * @author parth
 */
public class CountNegativeNumbersinSortedMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {4,3,2,-1};
        int[][] grid = {
            {4,3,2,-1},
            {3,2,1,-1},
            {1,1,-1,-2},
            {-1,-1,-2,-3}
        };
        //countNegatives(arr);
      // countNegativein2DArray(grid);
       countNeg(grid);
       // System.out.println(Arrays.toString(grid[0]));
    }
    //Count Negatives in an array using binary search
    public static void countNegatives(int[] arr){
        int low = 0;
        int end = arr.length - 1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] < 0){
                end = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        /*
        In 1D array we have find the index of the first negative element and than 
        subtract it from array length that would give us the total number of negative elements 
        For example = arr = {4,3,2,-1}
        The first -ve element is at index 3, so the total number of negative elements is 4 - 3 = 1
        
        arr = {-1,-1,-2,-3}
        The first -ve element is at index 0, so the total number of negative elements is 4 - 0 = 4
        */
        System.out.println(arr.length - low); 
    }
    //Optimal Solution (O(m*logN));
    public static void countNegativein2DArray(int[][] arr){
       int row = 0;
       int[] count = {0};
       
       while(row < arr.length){
           helper(arr[row],row,count);
           row++;
       }
        System.out.println(count[0]);
    }
    public static void helper(int[] arr, int row,int[] count){
        int low = 0;
        int end = arr.length - 1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] < 0){
                count[0] = count[0] + (end - mid + 1);
                end = mid - 1;
            }else{
                low = mid + 1;
            }
        }
       // System.out.println(count);
    }
    
    
    //Best Approach Full Optimized (O(m+n)
    public static void countNeg(int[][] arr){
        int row = arr.length - 1;
        int column = 0;
        int count = 0;
        while(row >= 0 && column < arr[0].length){
            if(arr[row][column] < 0){
                count = count + (arr[0].length - column);
                row--;
            }else{
                column++;
            }
        }
        System.out.println(count);
    }
   
}
