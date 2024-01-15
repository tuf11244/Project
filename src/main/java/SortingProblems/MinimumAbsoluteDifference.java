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
        
    }
    public static List<List<Integer>> minimumAbsDifference(int[] nums) {
        Arrays.sort(nums);
       int min = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length;i++){
            min = Math.min(min,Math.abs(nums[i-1] - nums[i]));            
        }
        min = Math.min(min,Math.abs(nums[nums.length-1] - nums[0]));
        System.out.println(min);
        
        List<List<Integer>> list = new ArrayList<>();

        for(int j = 1; j < nums.length;j++){
            if(nums[j] - nums[j-1] == min){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[j-1]);
                temp.add(nums[j]);
                list.add(temp);
            }
        }      
    
        return list;       
    }
}
