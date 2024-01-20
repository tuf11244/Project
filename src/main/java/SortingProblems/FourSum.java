/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 1/17/2024
 *https://leetcode.com/problems/4sum/
 * @author parth
 */
public class FourSum {

    
    public static void main(String args[]) {
       int[] nums = {1,0,-1,0,-2,2};
       List<List<Integer>> result = fourSum(nums,0);
       
       for(List<Integer> list : result){
           System.out.println(list);
       }
       
    }
    public static List<List<Integer>> fourSum(int[] nums, int target){   
        List<List<Integer>> list = new ArrayList<>();
        
        if(nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int currentValue = nums[i];
            int newTarget = target - currentValue;
            List<List<Integer>> subResult = threeSum(nums,i+1,newTarget);
            
            for(List<Integer> element : subResult){
                element.add(currentValue);
                list.add(element);
            }
        }
        return list;
    }
    public static List<List<Integer>> threeSum(int[] nums, int start,int newTarget){
        

        List<List<Integer>> subResult = new ArrayList<>();
        
        if(nums.length - start < 3){
            return subResult;
        }
        
        for(int i = start; i < nums.length -2;i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            int currentValue = nums[i];
            int target = newTarget - currentValue;
            List<List<Integer>> twoSumResult = twoSum(nums,i+1,nums.length-1,target);
            
            for(List<Integer> element : twoSumResult){
                element.add(currentValue);
                subResult.add(element);
            }            
        }
        return subResult;
    }
    public static List<List<Integer>> twoSum(int[] nums,int start, int end, int target){
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = end;
        
        while(left < right){
            if(left > start && nums[left] == nums[left-1]){
                left++;
                continue;
            }
            int sum = nums[left] + nums[right];
            if(sum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                result.add(temp);
                
                left++;
                right--;
            }else if(sum > target){
                right--;
            }else{
              left++;   
            }
        }
        
        
        return result;
        
        
}
}
