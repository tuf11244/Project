/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;
import java.util.Arrays;
/**
 *https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * https://www.geeksforgeeks.org/count-1s-sorted-binary-array
 * 
 * Same question logic used for find the count of given element in binary sorted array
 * first occurrence - last occurence + 1;
 * @author parth
 */

//Java + DSA Bootcamp Kunal Kushwaha
public class FindingFirstandLastIndexoftheElement07162023 {
     /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args){
	System.out.println("Hello World");
	int[]arr ={5,7,7,8,8,8,10};
        int[] nums = {1,1,0,0};
	//System.out.println(Arrays.toString(searchRange(arr,8)));
        //System.out.println(countNumberofOnes(nums));
        System.out.println(countNumberofOnesinDecreasingArray(nums));
                
	}
    public static int[] searchRange(int[] nums, int target) {
        int start = helper(nums,target);
        int end =  searchRangeHelper(nums,target);

        return new int[]{start,end};
    }
    public static int helper(int[] nums, int target){
        int low = 0;
        int end = nums.length -1;
        int result = -1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(nums[mid] == target){
                result = mid;
                end = mid - 1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                end = mid - 1;
            }            
        }
        return result;
    }
    public static int searchRangeHelper(int[] nums, int target){
        int low = 0;
        int end = nums.length -1;
        int result = -1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(nums[mid] == target){
                result = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                end = mid - 1;
            }            
        }
        return result;
    }
    
    
    //Question Find the number of ones, count number ones, its the same question we just have find the first occurence of 1 
    //int[] arr = {0,0,1,1,1}
    public static int countNumberofOnes(int[] arr){
        int low = 0;
        int end = arr.length - 1;
        int result = -1;
        while(low <= end){
           int mid = low + (end - low)/2;
           if(arr[mid] == 1){
               result = mid;
               end = mid - 1;
           }else if(arr[mid] == 0){
               low = mid + 1;
           }
        }
        //Below statement states that if result is -1 that means there are no ones so return 0 
        //If not than return the arr.length - first occurence 
        //for example arr = {0,0,0,0,1,1}
        //return 2 which is arr.length - 4, 4 being first occurence of 1
        return result == -1 ? 0 : arr.length - result;
    }
    
    //Decreasing Array 
    //int[] arr = {1,1,0,0,0]
    public static int countNumberofOnesinDecreasingArray(int[] arr){
        int low = 0;
        int end = arr.length -1;
        int result = -1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] == 1){
                result = mid;
                low = mid + 1;
            }else if (arr[mid] == 0){
                end = mid - 1;
            }
        }
        return result + 1;
    }
    
}
   
