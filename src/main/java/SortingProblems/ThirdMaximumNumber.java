/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author parth
 */
public class ThirdMaximumNumber {

    /**
     * https://leetcode.com/problems/third-maximum-number/
     * Date: 01/10/2024
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int nums[] = {1,1,2};
        System.out.println(thirdMaxOptimized(nums));
    }
    public static int thirdMax(int[] nums) {
        if(nums.length < 3){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        List<Integer> list = new ArrayList<>();

        for(int i : nums){
            if(!list.contains(i)){
                list.add(i);
            }
        }
        Collections.sort(list);

        if(list.size() < 3){
            return list.get(list.size()-1);
        }
        return list.get(list.size()-3);
    }
    
    //Optimize Solution O(n)
    public static int thirdMaxOptimized(int[] num){
        Integer max1 = null;
        Integer max2  = null;
        Integer max3 = null;
        
        for(Integer nums : num){
            if(nums.equals(max1) || nums.equals(max2) || nums.equals(max3)){
                continue;
            }
            if(max1 == null || nums > max1){
               max3 = max2;
               max2 = max1;
               max1 = nums;
            } else if(max2 == null || nums >= max2){
                max3 = max2;
                max2 = nums;
            }else if(max3 == null || nums >= max3){
                max3 = nums;
            }
        }
        if(max3 == null){
            return max1;
        }
        return max3;
    }
}
