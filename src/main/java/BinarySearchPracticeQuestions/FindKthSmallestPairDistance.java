/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;
import java.util.*;
/**
 *Date: 08/13/2024
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * @author parth
 */
public class FindKthSmallestPairDistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = (low + high) / 2;
            int count = countPairs(nums, mid);
            
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        
        return count;
    }
}
