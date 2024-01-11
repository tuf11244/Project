/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 *Date: 01/10/2024
 * https://leetcode.com/problems/array-partition/
 * @author parth
 */
public class ArrayPartition {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
    public static int arrayPairSum(int[] nums){
        int i = 0;
        int result = 0;
        
        /* Logic 
         We choose two numbers to make a pair.
        Then we take min(a,b) = val
        This sum of val's has to be maximum.
        So, in all the pairs we make , if we take a bigger number and a very small number and take min of these two numbers then we are just wasting away the bigger number as it could be used with some other number for pairing so that it will contribute to the final sum.
        So, when we do sorting , we make the adjacent numbers numerically close to each others. So, we can take pairwise elements like 1st and 2nd elements, 3rd and 4th element.. etc so reduce the difference between two numbers in each pair.
        example:

        input = [1, 1000, 3, 999]

        Then if we take (1,1000) and (3,999) as pairs :

        min1 = min(1,1000) = 1;
        min2 = min(3,999) = 3;

        Final sum = min1 + min2 = 4;

        But if we sorted the array, we can choose adjacent numbers in the array as the pairs.

        then: input = [1,3,999,1000]
        min1 = min(1,3)
        min2 = min(999,1000)

        final sum = min1 + min2 = 1 + 999 = 1000;
        */
        Arrays.sort(nums);
        
        while(i < nums.length){
            if(i+1 < nums.length){
                result = result + Math.min(nums[i], nums[i+1]); 
            }
            i = i+2;
        }
        return result;
    }
}
