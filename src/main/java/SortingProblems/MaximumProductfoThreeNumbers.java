/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 * Date: 01/10/2024
 *https://leetcode.com/problems/maximum-product-of-three-numbers/
 * @author parth
 */
public class MaximumProductfoThreeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int maximumProduct(int[] nums){
        if(nums.length == 3){
            int product = 1;
            for(int i = 0; i < nums.length;i++){
                product = product * nums[i];
            }
            return product;        
    }
        
       Arrays.sort(nums);
        //Either all the numbers are negative or all the numbers are positive//
        if(nums[nums.length-1] < 0 || (nums[0] > 0 && nums[nums.length-1] > 0)){
        return nums[nums.length -1] * nums[nums.length -2] * nums[nums .length -3];
        }
        
       //return the max between the product of 2 minimums and 1 largest or all the 3 largest
       return Math.max(nums[0]*nums[1] * nums[nums.length-1], nums[nums.length -1] * nums[nums.length -2] * nums[nums .length -3]); 
    }
       
}
