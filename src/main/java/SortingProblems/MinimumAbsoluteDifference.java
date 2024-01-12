/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.com/problems/minimum-absolute-difference/
 * @author parth
 */
public class MinimumAbsoluteDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {3,8,-10,23,19,-4,-14,27};
        helper(nums);
    }
    public static void helper(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length;i++){
            min = Math.min(min,Math.abs(nums[i-1] - nums[i]));            
        }
        min = Math.min(min,Math.abs(nums[nums.length-1] - nums[0]));
        System.out.println(min);
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,nums,min,0);
        
        for(List<Integer> element : list){
            System.out.println(element);
        }
        
    }

    private static void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, int min, int start) {
        if(temp.size() == 2 && temp.get(0) < temp.get(1) && Math.abs(temp.get(1) - temp.get(0)) == min){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length;i++){
            temp.add(nums[i]);
            helper(list,temp,nums,min,start+1);
            temp.remove(temp.size()-1);
        }
    }
}
