/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * 02/16/2024
 *https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @author parth
 */
public class MedianofTwoSortedArrays {

    /**
     * Very complex code 
     * Striver Binary Search Playlist
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int end = n1;
        int left = (n1 + n2 + 1)/2;
        int totalLength = n1 + n2;
        
        while(low <= end){
            int mid1 = (low + end)/2;
            int mid2 = left - mid1;
            
            //Left Symmetry 
            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            
            //Right Symmetry
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;
            
            if(mid1 < n1){
                right1 = nums1[mid1];
            }
            if(mid2 < n2){
                right2 = nums2[mid2];
            }
            if(mid1 - 1 >= 0){
                left1 = nums1[mid1-1];
            }
            if(mid2 - 1 >= 0){
                left2 = nums2[mid2-1];
            }
            if(left1 <= right2 && left2 <= right1){
                //if totalLength is even
                if(totalLength%2 == 0){
                    return((double)(Math.max(left1, left2) + Math.min(right1, right2)))/2.0;
                }else{
                   return Math.max(left1,left2);
                }
            }
            else if(left1 > right2){
                end = mid1 -1;
            }else{
                 low = mid1 + 1;
            }
        }
        return 0;
        
    }
}
