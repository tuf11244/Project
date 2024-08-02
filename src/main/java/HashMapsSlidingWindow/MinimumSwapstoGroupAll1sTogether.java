/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 08/01/2024
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 * @author parth
 */
public class MinimumSwapstoGroupAll1sTogether {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nums = {1,1,0,0,1};
        System.out.println(minSwaps(nums));
    }
    
    public static int minSwaps(int[] nums) {
        
     // Find the total number of ones
    int windowSize = 0;
    for (int num : nums) {
        if (num == 1) {
            windowSize++;
        }
    }
    
    // Create an array of size 2 * nums.length for sliding window
    //Because its giving in Question that it is a cicular array 
    //very Important
    int[] arr = new int[2 * nums.length];
    for (int i = 0; i < nums.length; i++) {
        arr[i] = nums[i];
        arr[i + nums.length] = nums[i];
    }
    
    // Initialize sliding window
    int i = 0;
    int j = 0;
    int swaps = 0;
    int minSwaps = Integer.MAX_VALUE;
    
    // Initial window setup
    for (i = 0; i < windowSize; i++) {
        if (arr[i] == 0) {
            swaps++;
        }
    }
    minSwaps = swaps;
    
    // Sliding window
    while (i < arr.length) {
        if (arr[i] == 0) {
            swaps++;
        }
        if (arr[j] == 0) {
            swaps--;
        }
        minSwaps = Math.min(minSwaps, swaps);
        i++;
        j++;
    }
    
    return minSwaps;
    }
}
