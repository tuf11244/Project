/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 * Date: 02/05/2024
 *https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @author parth
 */
public class RotationCountinRotatedBinarySearch07172023 {

    /**
     * The property of a rotated sorted array is the one side of it is sorted and the other is unsorted 
     * arr = {0,1,2,3,4,5};
     * int start = 0;
     * int end = arr.length - 1;
     * Sorted Array Property : arr[start] < arr[end];
     * 
     * Rotate Sorted Array 
     * arr = {3,4,5,0,1,2]
     * int start = 0;
     * int end = arr.length - 1;
     * int mid = 5
     * So from 3 to 5 the array is sorted and from 5 to element 2 the array is unsorted 
     * 
     * Please note that Find how many times the sorted array has been rotated , find the minimum in the sorted rotated array 
     * use the same logic as mentioned above 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {4,5,6,7,0,1,2};
       // System.out.println(countRotation(arr));
       // System.out.println(findMin(arr));
        // TODO code application logic here
    }
    public static int countRotation(int[]arr){
        int pivot = findPivot(arr);
        return pivot+1;
        
    }
    public static int findPivot(int[]arr){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int middle = start + (end-start)/2;
            //Case 1: 
            if(middle < end && arr[middle]>arr[middle+1]){
                return middle;
            }
            if(middle > start && arr[middle]<arr[middle-1]){
                return middle-1;
            }
            if(arr[start]>=arr[middle]){
                end = middle-1;
            }
            else{
                start = middle+1;
            }
        }
        
        return -1;
        
    }
    
    
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    public static int findMin(int[] arr){
        int low = 0;
        int end = arr.length - 1;
        int answer = Integer.MAX_VALUE;
        while(low <= end){
            int mid = low + (end - low)/2;
           
            if(arr[low] <= arr[mid]){
                answer = Math.min(answer,arr[low]);
                low = mid + 1;
            }else{
                answer = Math.min(answer,arr[mid]);
                end = mid - 1;
            }            
        }
        return answer;
    }
}
