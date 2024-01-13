/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 *https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 * Date: 01/12/2024
 * @author parth
 */
public class HowManyNumbersSmallerThanCurrentNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {3,4,5,2};
        int[] target = {4,2,3,5};
        System.out.println(canBeEqual(nums,target));
        //smallerThanTheCurrentNumber(nums);
        maxProduct(nums);
    }
    public static void smallerThanTheCurrentNumber(int[] nums){
        int[] answer = new int[nums.length];
       int count = 0;
       for(int i = 0; i < nums.length;i++){
           count = 0;
           for(int j = 0; j < nums.length;j++){
               if(nums[i] > nums[j]){
                   count++;
               }
           }
            answer[i] = count;
           // System.out.println(count);
       }
        System.out.println(Arrays.toString(answer));
    }
    public static void maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;i++){
            for(int j = 0; j < nums.length;j++){
                if(i!=j){
                   max = Math.max(max,(nums[i]-1)*(nums[j]-1));
                }
            }
        }
        System.out.println(max);
    }
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
       int index = 0; 
       while(index < target.length && index < arr.length){
           if(target[index] != arr[index]){
               return false;
           }
           index++;
       }
       return true;
    }
    public static  boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1]- arr[0];
        for(int i = 1; i < arr.length;i++){
            int actualDifference = arr[i] - arr[i-1];
            if(difference != actualDifference){
                return false;
            }
        }
        return true;
    }
}
