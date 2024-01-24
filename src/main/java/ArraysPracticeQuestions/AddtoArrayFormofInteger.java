/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 *Date: 01/23/2024
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * @author parth
 */
public class AddtoArrayFormofInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {9,9,9,9,9,9,9,9,9,9};
        addToArrayForm(nums,1);
    }
    public static void addToArrayForm(int[] nums, int k){
       
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length-1; i >= 0 || k > 0;i--){
            if(i >= 0){
                result.add(0,(nums[i]+k)%10);
                k = (nums[i]+k)/10;
            }else{
                result.add(0,k%10);
                k = k/10;
            }
        }
        System.out.println(result);
    }
    
    
}
