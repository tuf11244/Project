/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/product-of-array-except-self/
 * Date: 01/27/2024
 * @author parth
 */
public class ProductofArrayExceptSelf {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         int[] nums = {-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length-1] = 1;
        
        for(int i = 1; i < leftProduct.length;i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];        
            
        }
        for(int i = rightProduct.length-2; i>= 0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
