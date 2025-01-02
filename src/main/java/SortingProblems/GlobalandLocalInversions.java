/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Date: 02/18/2024
 *https://leetcode.com/problems/global-and-local-inversions/
 * @author parth
 */
public class GlobalandLocalInversions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static  boolean isIdealPermutation(int[] nums) {
         int max = 0;

        for(int i = 0; i < nums.length - 1;i++){
            if(max > nums[i+1]){
                return false;
            }
            max= Math.max(max,nums[i]);
        }
        return true;
    }
    
}
