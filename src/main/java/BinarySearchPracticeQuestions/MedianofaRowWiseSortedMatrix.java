/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 02/07/2024
 * https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
 * @author parth
 */
public class MedianofaRowWiseSortedMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {1,3,5},
            {2,6,9},
            {3,6,6}
        };
        median(arr);
    }
    public static void median(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        
        //Total number of elements 
        int size = rows * columns;
        int low = findMin(arr,rows,columns);
        int end = findMax(arr,rows,columns);
        
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
    public static int findMin(int[][] arr, int rows,int columns){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < rows;i++){
            if(arr[i][0] < min){
                min = arr[i][0];
                index = i;
            }
        }
        return index;
    }
     public static int findMax(int[][] arr, int rows,int columns){
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < rows;i++){
            if(arr[i][columns-1] > max){
                max = arr[i][columns-1];
                index = i;
            }
        }
        return index;
    }
    public static int helper(int[][] arr, int mid){
    int count = 0;
    int rows = arr.length;
    int columns = arr[0].length;
    
    for(int i = 0; i < rows; i++){
        int low = 0;
        int end = columns - 1;
        while(low <= end){
            int middle = low + (end - low) / 2;
            if(arr[i][middle] <= mid){
                count += middle + 1;
                low = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }
    
    return count;
}

}

