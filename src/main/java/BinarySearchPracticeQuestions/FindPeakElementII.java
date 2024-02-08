/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *Date: 02/07/2024
 * https://leetcode.com/problems/find-a-peak-element-ii/
 * @author parth
 */
public class FindPeakElementII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {10,20,15},
            {21,30,14},
            {7,16,32}};
        int[] answer = findPeakGrid(arr);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] findPeakGrid(int[][] arr){
        int row = arr.length;
        int column = arr[0].length;
        int low = 0;
        int end = column - 1;
        
        while(low <= end){
            //mid is nothing but mid Column
            int mid = low + (end - low)/2;
            //Find out the maxRowIndex rules out that the element at the row index is greater 
            //than its respective top and bottom elements 
            //for example arr = {10,20,15}
            //                  {21,30,14}
            //                  {17,16,32}
            //so in the  column 0 the max is at row number 1 which is 21 that means its greater than 10 and 17 (top and bottom)
            int maxRowIndex = findMaxRowIndex(arr,row,column,mid);
            int left = mid - 1 >= 0 ? arr[maxRowIndex][mid-1] : -1;
            int right = mid + 1 < column ? arr[maxRowIndex][mid+1] : -1;
            if(arr[maxRowIndex][mid] > left && arr[maxRowIndex][mid] > right){
                return new int[] {maxRowIndex,mid};
            }else if(arr[maxRowIndex][mid] < left){
                end = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int findMaxRowIndex(int[][] arr, int row, int column,int mid){
        int maxValue = -1;
        int index = -1;
        
        for(int i = 0; i < row; i++){
            if(arr[i][mid] > maxValue){
                maxValue = arr[i][mid];
                index = i;
            }
        }
        return index;
    }
    
}
