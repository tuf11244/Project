/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 11/14/2024
 *https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 * @author parth
 */
public class ShortestSubarraytobeRemovedtoMakearraySorted {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {1,2,3,10,4,2,3,5};
        
        System.out.println(findLengthOfShortestSubarray(arr));
    }
    
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        // Find the left-most part where array is increasing
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the entire array is already sorted, return 0
        if (left == n - 1) {
            return 0;
        }

        // Find the right-most part where array is increasing
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        System.out.println(left);
        System.out.println(right);
        
        // Start with removing one of the two parts entirely (prefix or suffix)
        int minRemove = Math.min(n - left - 1, right);
        // System.out.println(minRemove);
        // Try merging prefix with suffix using a two-pointer approach
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                // We found a valid merging point
                minRemove = Math.min(minRemove, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minRemove;
    }
}


