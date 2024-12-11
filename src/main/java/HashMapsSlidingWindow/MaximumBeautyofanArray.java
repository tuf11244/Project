/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 12/10/2024 POTD 
 *https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 * @author parth
 */
public class MaximumBeautyofanArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Overlapping Interval Method - Approach 1
    public static int maxBeauty(int[] nums, int k){
        
         // Convert nums into ranges
        List<int[]> ranges = new ArrayList<>();
        for (int num : nums) {
            ranges.add(new int[]{num - k, num + k});
        }

        // Sort the ranges based on their start point
        ranges.sort((a, b) -> Integer.compare(a[0], b[0]));

        int maxBeauty = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        // Iterate over sorted ranges
        for (int[] range : ranges) {
            while (!deque.isEmpty() && deque.peekFirst() < range[0]) {
                deque.pollFirst();
            }
            deque.offerLast(range[1]);

            maxBeauty = Math.max(maxBeauty, deque.size());
        }

        return maxBeauty;
        
    }
    
    //Using Binary Search
    public static int maxBeautyBS(int[] nums, int k){
        int result = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length;i++){
            
            int idx = binarySearch(nums,nums[i] + 2*k);
            result = Math.max(result,idx - i + 1);
        }
        return result;
    }
    
    public static int binarySearch(int[] nums, int target){
        int low = 0;
        int end = nums.length -1;
        
        while(low <= end){
            int mid = low + (end - low)/2;
            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
    
    
    //Using sliding window
    public static int  maxBeautySlidingWindow(int[] nums, int k){
        int maxBeauty = 0;
        int j = 0;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            
            if(nums[i] > nums[j] + 2 * k){
                j++;
            }
            
            maxBeauty = Math.max(maxBeauty, i- j+1);
        }
        
        return maxBeauty;
    }
}


