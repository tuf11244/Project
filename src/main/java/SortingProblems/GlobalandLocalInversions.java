/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Date: 02/18/2024
 *https://leetcode.com/problems/global-and-local-inversions/
 * @author parth
 */
public class GlobalandLocalInversions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static  boolean isIdealPermutation(int[] arr) {
        int[] nums = Arrays.copyOfRange(arr,0,arr.length);
	List<Integer> localInversion = new ArrayList<>();
	    
        int globalInversion = mergeSort(nums,0,nums.length-1);
	    
	    //Local Inversion 
	    for(int i = 0; i < arr.length-1;i++){
	        int count = 0;
	        if(arr[i] > arr[i+1]){
	            count++;
	        }
	        localInversion.add(count);
	    }
	    //For the last element
	    localInversion.add(0);
	 
	    int sumLocalInversion = 0;
	    
	    for(int y : localInversion){
	        sumLocalInversion = sumLocalInversion + y;
	    }
	    System.out.println(globalInversion);
	    System.out.println(localInversion);
	    
	    return sumLocalInversion == globalInversion;
    }
    public static int mergeSort(int[] nums,int low, int high){
	    int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(nums, low, mid);  // left half
        cnt += mergeSort(nums, mid + 1, high); // right half
        cnt += merge(nums, low, mid, high);  // merging sorted halves
        return cnt;
	}
	private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }
}
