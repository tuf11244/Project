/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 * Date: 01/28/2024
 *https://leetcode.com/problems/number-of-good-pairs/
 * @author parth
 */
public class NumberofGoodPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static  int numIdenticalPairs(int[] nums) {
         int count= 0;
         for(int i = 0; i < nums.length;i++){
             for(int j = i+1; j < nums.length;j++){
                 if(j < nums.length && nums[i] == nums[j]){
                     count++;
                 }
             }
         }
         return count;
    }
}
