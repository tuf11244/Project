/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 09/13/2024
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
 * @author parth
 */
public class LongestSubarraywithMaximumBitwiseAND {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
     //   System.out.println(1 & 2);
        System.out.println();
    }
    public int longestSubarray(int[] nums) {
        //Find the maximum element 
        int max = 0;
        for(int i = 0; i < nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int count = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length;i++){
              if((nums[i]  & max ) == max){
                count++;
              }else{
                count = 0;
              }
              maxLength = Math.max(count,maxLength);

        }
        return maxLength;
    }
}
