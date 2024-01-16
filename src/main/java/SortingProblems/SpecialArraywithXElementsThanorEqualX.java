/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 * Date 01/16/2024
 *https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * @author parth
 */
public class SpecialArraywithXElementsThanorEqualX {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i <= nums[j]) {
                    count++;
                }
            }
            if (i == count) {
                return i;
            }
        }
        return -1;
    }
}
