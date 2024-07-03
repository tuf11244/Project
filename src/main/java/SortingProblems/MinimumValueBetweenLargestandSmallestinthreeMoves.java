/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: 07/03/2024
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 * @author parth
 */
public class MinimumValueBetweenLargestandSmallestinthreeMoves {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
 
    public static int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        result = Math.min(result, nums[n - 4] - nums[0]);  //Last 3 elements were modified
        result = Math.min(result, nums[n - 1] - nums[3]);  //First 3 elements were modified
        result = Math.min(result, nums[n - 3] - nums[1]);  //Last 2 elements and first element were modified 
        result = Math.min(result, nums[n - 2] - nums[2]); //First 2 elements and last element were modified

        return result;
    }
    }
