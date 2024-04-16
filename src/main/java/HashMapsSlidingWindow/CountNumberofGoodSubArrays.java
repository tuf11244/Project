/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 *Date: 04/14/2024
 *https://leetcode.com/problems/count-the-number-of-good-subarrays/
 * @author parth
 */
public class CountNumberofGoodSubArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static long countGood(int[] nums, int k) {
       HashMap<Integer,Integer> hm = new HashMap<>();
       int j = 0;
       long answer = 0;
       int pairs  = 0;

       for(int i = 0; i < nums.length;i++){
        //Create a Frequency Map
         hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        //Calculate the number of pairs with the same value
        pairs = pairs + hm.get(nums[i])-1;

        while(pairs >= k){
            //Calculate the answer
            answer = answer + (nums.length-i);
            //Reduce the window size 
            hm.put(nums[j],hm.get(nums[j])-1);
            //Update the pairs also 
            pairs = pairs - hm.get(nums[j]);
            j++;
        }
       } 
       return answer;
    }
}

