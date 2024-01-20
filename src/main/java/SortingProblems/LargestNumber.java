/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/largest-number/
 * Date: 01/19/2024
 * @author parth
 */
public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums){
        String[] arr = new String[nums.length];
        
        for(int i = 0; i < nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b)->{
            long n1 = Long.parseLong(a+b);
            long n2 = Long.parseLong(b+a);
            
            if(n1 > n2){
                return 1;
            }else if(n1 < n2){
                return -1;
            }else{
                return 0;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int k = arr.length-1;k>= 0;k--){
            sb.append(arr[k]);
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();       
    }
}
