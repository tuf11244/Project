/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *Date: 02/06/2024
 *https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * @author parth
 */
public class SearchinRotatedBinaryArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {4,5,6,7,0,1,2};
        int[] nums = {1,0,1,1,1};
       // System.out.println(search(arr,1));
        System.out.println(searchwithDuplicates(nums,1));
    }
    public static int search(int[] arr, int target){
        //Index of minimum Element 
        int minIndex = countRotations(arr);
        int leftSearch  = binarySearch(arr,target,0,minIndex-1);
        int rightSearch = binarySearch(arr,target,minIndex,arr.length-1);
        
        //Element not present
        if(leftSearch == - 1 && rightSearch == - 1){
            return -1;
        }
        if (leftSearch == - 1){
            return rightSearch;
        }
        return leftSearch;
    }
    public static int countRotations(int[] arr){
        int low = 0;
        int end = arr.length - 1;
        int minimum = Integer.MAX_VALUE;
        int index = -1;
        while(low <= end){
            int mid = low + (end - low)/2;
            //If the search space is already sorted, than 
            //the minimum would always be arr[low];
            if(arr[low] < arr[end]){
                if(arr[low] < minimum){
                    index = low;
                    minimum = arr[low];
                }
                break;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] < minimum){
                    index = low;
                    minimum = arr[low];
                }
                low = mid + 1;
            }else{
                if(arr[mid] < minimum){
                    index = mid;
                    minimum = arr[mid];
                }
                end = mid - 1;
            }            
        }
        return index;
    }
    public static int binarySearch(int[]arr, int target, int low, int end){
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    
    
    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    
  public static boolean searchwithDuplicates(int[] arr, int target) {
        int low = 0;
        int end = arr.length - 1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[end]){
                low++;
                end--;
                continue;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    end = mid - 1;
                }else{
                    low = mid +1;
                }
            }else{
                if(arr[mid] <= target && target <= arr[end]){
                    low = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
