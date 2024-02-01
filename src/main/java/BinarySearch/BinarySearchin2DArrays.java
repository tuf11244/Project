/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;
import java.util.Arrays;

/**
 *https://leetcode.com/problems/search-a-2d-matrix/
 * @author parth
 */
public class BinarySearchin2DArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {10,20,30,40},
            {15,25,35,45},
            {28,29,37,49},
            {33,34,38,50},
        };
        System.out.println(Arrays.toString(binarySearch(arr,37)));
        // TODO code application logic here
    }
    public static int[] binarySearch(int[][] arr, int target){
        int row = 0;
        int column = arr.length-1;
        while(row < arr.length && column >= 0){
            if(arr[row][column]== target){
                return new int[]{row,column};
            }
            if(arr[row][column] < target){
                row = row + 1;
            }
            else{
                column = column -1;
            }
        }
        return new int[]{-1,-1};
    }
    
    
    
    public boolean searchMatrix(int[][] arr, int target) {
       int row = binarySearchHelper(arr,target);
       if(row == -1){
           return false;
       }
       boolean isFound = helper(arr,row,target);
       return isFound;
    }
    public static int binarySearchHelper(int[][] arr, int target){
        int low = 0;
        int end = arr.length - 1;
        int lc = arr[0].length - 1;
        while(low <= end){
            int mid = low + (end -low)/2;
            if(arr[mid][0] <= target && arr[mid][lc] >= target){
                return mid;
            }else if(arr[mid][lc] > target){
                end = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static boolean helper(int[][] arr, int row, int target){
        int low = 0;
        int end = arr[0].length - 1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[row][mid] == target){
                return true;
            }else if(arr[row][mid] < target){
                low = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
