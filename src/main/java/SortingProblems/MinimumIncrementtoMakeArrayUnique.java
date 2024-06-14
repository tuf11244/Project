/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 * @author parth
 */
public class MinimumIncrementtoMakeArrayUnique {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }
    
    public static int minIncrementForUnique(int[] nums){
       // Sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // Calculate the increment needed
                int increment = nums[i - 1] - nums[i] + 1;
                // Increment the current element to make it unique
                nums[i] += increment;
                // Add the number of moves
                moves += increment;
            }
        }
        return moves;
                
    }
}
