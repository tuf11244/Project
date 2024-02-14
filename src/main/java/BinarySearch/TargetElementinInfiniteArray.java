/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
 * @author parth
 */
public class TargetElementinInfiniteArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr ={3,5,7,9,10,20,30,40,150,160,170,180,190,200};
        int[] nums = {0,0,1,1,1,1};
        
        int target = 10;
        System.out.println(elementinInfiniteArray(arr,target));
        System.out.println(firstOccurrenceinInfiniteSortedArray(nums));
        
        // TODO code application logic here
    }
 public static int elementinInfiniteArray(int[]arr, int target){
     //box of size 2
     int low = 0;
     int end = 1;
     while (arr[end] < target) {
            low = end;
            end = end * 2;
        }
     while(low <= end){
         int mid = low + (end - low)/2;
    
         if(arr[mid] == target){
             return mid;
         }
         else if(arr[mid] > target){
             end = mid - 1;
         }else{
             low = mid + 1;
     }
}    	return -1;
 }
 
 public static int firstOccurrenceinInfiniteSortedArray(int[] arr){
     int low = 0;
     int end = 1;
     while(arr[end] < 1){
         low = end;
         end = end * 2;
     }
     int answer = -1;
     while(low <= end){
         int mid = low + (end - low)/2;
         if(arr[mid] == 1){
             answer= mid;
             end = mid -1;
        }else{
             low = mid + 1;
         }
 }
        return answer;
}
}

