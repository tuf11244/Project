/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *
 * @author parth
 */
public class KthElementof2SortedArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
       int arr1[] = {2, 3, 6, 7, 9};
       int arr2[] = {1, 4, 8, 10};
       
        System.out.println(kthElement(arr1,arr2,5));
    }
    public static int kthElement(int[] nums1, int[] nums2, int k){
        //Base Case;
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int totalLength = n1 + n2;
        if(k > totalLength){
            return -1;
        }
        //We are performing Binary Search on the smallest array length
        if(n1 > n2){
            return kthElement(nums2, nums1,k);
        }
        int low = Math.max(0, k-n2);
        int end = Math.min(k,n1);
        int left = k;
        while(low <= end){
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
               return Math.max(left1,left2);
            }
            else if(left1 > right2){
                end = mid1 -1;
            }else{
                 low = mid1 + 1;
            }
        }
        }
        return 0;
    }
}
