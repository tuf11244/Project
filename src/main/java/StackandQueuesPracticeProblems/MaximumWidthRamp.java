/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 10/09/2024
 * https://leetcode.com/problems/maximum-width-ramp/
 * @author parth
 */
public class MaximumWidthRamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxRamp = 0;

        // Step 1: Build a decreasing stack of indices
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // Step 2: Traverse from the end to start and check for valid ramps
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxRamp = Math.max(maxRamp, j - stack.pop());
            }
        }

        return maxRamp;
    }
    
    
    //Approach 2 : Using 2 pointers
    //We find the maximum Element on right side 
    
    public static int maxWidthRampApproach2(int[] nums){
        
        int[] maxonRightSide = new int[nums.length];
        
        maxonRightSide[nums.length - 1] = nums[nums.length - 1];
        
        for(int i = nums.length - 2; i >= 0; i--){
            maxonRightSide[i] = Math.max(nums[i],maxonRightSide[i+1]);
        }
        
        int ramp = 0;
        int i = 0; 
        int j = 0;
        
        while(j < nums.length){
            
            while(nums[i] > maxonRightSide[j]){
                i++;
            }
            
            ramp = Math.max(ramp, j-i);
            j++;
        }
        return ramp;
    }
}
