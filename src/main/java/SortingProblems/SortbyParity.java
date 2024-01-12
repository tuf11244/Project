/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Date: 01/11/2024
 * https://leetcode.com/problems/sort-array-by-parity/description/
 * https://leetcode.com/problems/sort-array-by-parity-ii/description/
 * @author parth
 */
public class SortbyParity {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {4,2,5,7};
        sortArrayByParityII(nums);
        System.out.println(Arrays.toString(nums));
    }
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i : nums){
            if(i%2 == 0){
                even.add(i);
            }else{
                odd.add(i);
            }
        }
        even.addAll(odd);
        int[] answer = new int[even.size()];

        for(int j = 0; j < even.size();j++){
            answer[j] = even.get(j);
        }
        return answer;
    }
    public static void sortArrayByParityII(int[] nums) {
        int i = 0; 
        int j = 0;
        
        while(i < nums.length && j < nums.length){
            if((i%2 == 0 && nums[i] % 2 == 0) || (i%2!=0 && nums[i] % 2 != 0)){
                i++;
                j++;
            }
            else if(i%2 == 0 && nums[i] % 2 != 0){
              while(nums[j]%2 != 0){
                  j++;
              }
             swap(nums,i, j);
             //Reset j pointer 
              j = i;
           }
           else if(i%2 != 0 && nums[i] % 2 == 0){
              while(nums[j]%2 == 0){
                  j++;
              }
             swap(nums,i, j);
             //Reset j pointer 
             j = i;
           }
    }
    }
    
   private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
   }
    
}
