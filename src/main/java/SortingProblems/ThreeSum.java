/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
/**
 *Date: 01/17/2024
 * https://leetcode.com/problems/3sum/
 * https://leetcode.com/problems/3sum-closest/
 * @author parth
 */
public class ThreeSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        List<List<Integer>> list = threeSum(nums);
        
        for(List<Integer> x : list){
            System.out.println(x);
        }
       
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort to efficiently use two-pointer approach
        Set<List<Integer>> result = new HashSet<>(); // Use HashSet to avoid duplicates
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates at the beginning of the triplet
            }
            int target = -nums[i]; // We need to find two numbers that sum to target (-nums[i])
            List<List<Integer>> twoSum = findTwoSum(i + 1, nums, target);
            
            for (List<Integer> triplet : twoSum) {
                triplet.add(0, nums[i]); // Add nums[i] as the first element of the triplet
                result.add(triplet); // Add the triplet to the result set (avoids duplicates)
            }
        }
        
        return new ArrayList<>(result); // Convert result set to list
    }

    // Helper method to find two numbers that sum to the target
    public static List<List<Integer>> findTwoSum(int i, int[] nums, int target) {
        int j = nums.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                list.add(temp);
                
                // Skip duplicates for both pointers
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            } else if (sum < target) {
                i++; // Need larger sum, move left pointer to the right
            } else {
                j--; // Need smaller sum, move right pointer to the left
            }
        }
        
        return list; // Return all pairs that sum up to the target
    }
//    public static List<List<Integer>> threeSum(int[] nums){
//        List<List<Integer>> list = new ArrayList<>();
//        for(int i = 0; i < nums.length;i++){
//            int j = i+1;
//            while(j < nums.length){
//                int k = j+1;
//                while(k < nums.length){
//                    if(nums[i] + nums[j] + nums[k] == 0){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        if(!list.contains(temp)){
//                            list.add(temp); 
//                        }                    
//                    }
//                    k++;
//                }
//                j++;
//            }
//        }
//        return list;
//    }
//    
//    
//    //O(N^2) probability 
//    public static List<List<Integer>> threeSumOptimized(int[] nums) {
//    List<List<Integer>> list = new ArrayList<>();
//
//    // Sort the array to make it easier to handle duplicates
//    Arrays.sort(nums);
//
//    for (int i = 0; i < nums.length - 2; i++) {
//        // Skip duplicates for the first element
//        if (i > 0 && nums[i] == nums[i - 1]) {
//            continue;
//        }
//
//        int j = i + 1;
//        int k = nums.length - 1;
//
//        while (j < k) {
//            int sum = nums[i] + nums[j] + nums[k];
//
//            if (sum == 0) {
//                // Add the triplet to the result list
//                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
//
//                // Skip duplicates for the second element
//                while (j < k && nums[j] == nums[j + 1]) {
//                    j++;
//                }
//
//                // Skip duplicates for the third element
//                while (j < k && nums[k] == nums[k - 1]) {
//                    k--;
//                }
//
//                // Move both pointers towards each other
//                j++;
//                k--;
//            } else if (sum < 0) {
//                // Increment j if the sum is less than 0
//                j++;
//            } else {
//                // Decrement k if the sum is greater than 0
//                k--;
//            }
//        }
//    }
//
//    return list;
//}
//    
    public static int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
         int closest = 0; 
         int minDiff = Integer.MAX_VALUE;
       for(int i = 0; i < nums.length-2;i++){
           int j = i + 1;
           int k = nums.length-1;
           while(j < k){
               int sum = nums[i] + nums[j] + nums[k];
               if(sum == target){
                   return sum;
               }else if (sum > target){
                   k--;
               }else{
                   j++;
               }
               
               int diff = Math.abs(sum - target);
               if(diff < minDiff){
                   minDiff = diff;
                   closest = sum;
           }
           }
       }
        return closest;
    }

}
