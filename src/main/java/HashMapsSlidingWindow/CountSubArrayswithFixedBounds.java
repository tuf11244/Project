/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date 04/06/2024
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
 * @author parth
 */
public class CountSubArrayswithFixedBounds {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        
        int minKposition = -1;
        int maxKposition = -1;
        int culpritIndex = -1;

        for(int i = 0; i < nums.length;i++){
            //Below statement means that the element is culprit
            if(nums[i] < minK || nums[i] > maxK){
                culpritIndex = i;
            }
            if(nums[i] == minK){
                minKposition = i;
            }
            if(nums[i] == maxK){
                maxKposition = i;
            }
            long smaller = Math.min(minKposition, maxKposition);
            long temp = smaller - culpritIndex;

            if(temp < 0){
                answer = answer + 0;
            }else{
                answer = answer + temp;
            }

        }
        return answer;
    }
}
