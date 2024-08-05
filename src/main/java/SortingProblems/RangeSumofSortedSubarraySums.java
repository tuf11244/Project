/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: 08/03/2024
 *https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 * @author parth
 */
public class RangeSumofSortedSubarraySums {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public int rangeSum(int[] nums, int n, int left, int right) {
       
       int [] sums = new int[n* (n+1)/2];
       int idx = 0;

       for(int i =0; i < nums.length;i++){
        int sum = nums[i];
        sums[idx] = sum;
        idx++;
        for(int j = i+1; j < nums.length;j++){
            sum = sum + nums[j];
            sums[idx] = sum;
            idx++;
        }
       }

       Arrays.sort(sums);
      

      // Calculate the range sum from left to right
        long mod = 1000000007; // Correct modulus
        long rangeSum = 0;
        for (int i = left - 1; i < right; i++) {
            rangeSum = (rangeSum + sums[i]) % mod;
        }

        return (int) rangeSum;
      
      }
}
