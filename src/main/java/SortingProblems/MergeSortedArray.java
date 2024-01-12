/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 *Date: 01/11/2024
 *https://leetcode.com/problems/merge-sorted-array/
 * @author parth
 */
public class MergeSortedArray {

    
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
       int j = 0;
        for (int i = m; i < nums1.length && j < n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    
    public static void mergeOptimized(int[] nums1, int m, int[] nums2, int n){
        int pointer1 = m-1;
        int pointer2 = n-1;
        
        int i = m + n - 1;
        
        while(pointer2 >= 0){
            if(pointer1 >= 0  && nums1[pointer1] > nums2[pointer2]){
                nums1[i] = nums1[pointer1];
                i--;
                pointer1--;
            }else{
                nums1[i] = nums2[pointer2];
                i--;
                pointer2--;
            }
        }
    }
}
