/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date: 11/12/2024
 * https://leetcode.com/problems/count-the-number-of-fair-pairs/
 * @author parth
 */
public class CounttheNumberofFairPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long pairsLower = 0;
        long pairsUpper = 0;
        int i = 0; 
        int j = nums.length - 1;
        Arrays.sort(nums);
       

       //Find number of pairs for which sum < lower
        while(i < j){
            int sum = nums[i] + nums[j];

            if(sum < lower){
                pairsLower = pairsLower + (long)(j-i);
                i++;
            }else{
                j--;
            }
            
         }

         //Find number of pairs for which sum <= upper;
        i = 0;
        j = nums.length - 1;

        while(i < j){

            int sum = nums[i] + nums[j];

             if(sum <= upper){
                pairsUpper = pairsUpper + (long)(j-i);
                i++;
             }else{
                j--;
             }
        }

        return pairsUpper - pairsLower;

    }
}
