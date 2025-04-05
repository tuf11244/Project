/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 04/03/2025
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/
 * @author parth
 */
public class MaximumValueofAnOrderedTripletII {
    public static void main(String[] args) {
        
    }
    public long maximumTripletValue(int[] nums) {
        long answer = 0;
        int[] leftMax = new int[nums.length];

        leftMax[0] = 0;

        for(int i = 1; i < nums.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],nums[i-1]);
        }
        int[] rightMax = new int[nums.length];

        rightMax[nums.length-1] = 0;

        for(int i = nums.length-2; i >=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],nums[i+1]);
        }

        for(int i = 1; i < nums.length; i++){
            long product = (long)(leftMax[i] - nums[i]) * (long)rightMax[i];
            answer = Math.max(answer,product);
        }

        return answer;
    }
}
