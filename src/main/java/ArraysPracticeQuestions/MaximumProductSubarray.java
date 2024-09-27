/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 09/26/2024
 *https://leetcode.com/problems/maximum-product-subarray/
 * @author parth
 */
public class MaximumProductSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
       
       int prefix = 1;
       int suffix = 1;

        int result = 0;
       for(int i = 0; i < nums.length;i++){

           if(prefix == 0){
               prefix = 1; //Beginning of new array
           } 
           if(suffix == 0){
              suffix = 1; //Beginning of new array
           }

           prefix = prefix * nums[i];
           suffix = suffix * nums[nums.length - i -1];

           result = Math.max(result,Math.max(prefix,suffix));
       }

       return result;
    }
}
