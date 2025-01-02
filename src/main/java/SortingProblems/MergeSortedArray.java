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
       int i = m - 1; // Pointer for the last element in nums1's initial part
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last position in nums1
        
        // Merge nums1 and nums2 from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        
        // No need to handle remaining elements of nums1, as they are already in place
    }
}
