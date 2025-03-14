/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPPartII.Kadane;
import java.util.*;
/**
 *Date: 03/13/2025
 * https://leetcode.com/problems/find-all-good-indices/
 * @author parth
 */
public class FindAllGoodIndices {
    public static void main(String[] args) {
        
    }
    
    
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Compute the left (non-increasing) array
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        
        // Step 2: Compute the right (non-decreasing) array
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        
        // Step 3: Find valid indices
        for (int i = k; i < n - k; i++) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                result.add(i);
            }
        }
        
        return result;
    }
}
