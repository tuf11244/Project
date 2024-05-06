/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.Arrays;
import java.util.HashSet;

/**
 *Date: 05/06/2024
 *https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
 * @author parth
 */
public class MinimumNumberofOpertationstoMakeArrayContinuous {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int minOperations(int[] nums) {
        int answer = Integer.MAX_VALUE;

        //Create a HashSet for all the unqiue values
        HashSet<Integer> set = new HashSet<>();
        for(int i  = 0; i < nums.length;i++){
            set.add(nums[i]);
        }
        //We are creating an array for all the unique values 
        int[] arr = new int[set.size()];
        int index = 0;
        for(int num : set){
            arr[index] = num;
            index++;
        }
        //sort the arr 
        Arrays.sort(arr);

        int j = 0; 
        //i would only run on the array with out any duplicates
        for(int i = 0; i < arr.length;i++){

            //expand the size of the window
            while(j < arr.length && arr[j] < arr[i] + nums.length){
                j++;
            }
            int count = j - i; //how many numbers we can include in the range
            //nums.length - count = how many numbers we need to flip
            answer = Math.min(answer,nums.length-count); 
        }
        return answer;
        
    }
}
