/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: 03/30/2025
 * https://leetcode.com/problems/put-marbles-in-bags/
 * Similar logic to Array Partition
 * @author parth
 */
public class PutMarbelsinBag {
    public static void main(String[] args) {
        
    }
    public long putMarbles(int[] weights, int k) {
        if (k == 1) return 0;  // If only one partition is needed, there's no difference

        long[] arr = new long[weights.length - 1];

        // Step 1: Compute adjacent pair sums
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long) (weights[i] + weights[i + 1]);
        }

        // Step 2: Sort the array
        Arrays.sort(arr);

        long minSum = 0, maxSum = 0;

        // Step 3: Compute minSum and maxSum by taking the k-1 smallest and largest elements
        for (int i = 0; i < k - 1; i++) {
            minSum += arr[i]; // k-1 smallest values
            maxSum += arr[arr.length - 1 - i]; // k-1 largest values
        }

        // Step 4: Return the difference
        return maxSum - minSum;
    }
}
