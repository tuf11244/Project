/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 03/14/2025
 * https://leetcode.com/problems/house-robber-iv/
 * @author parth
 */
public class HouseRobberIV {
    
    public static void main(String[] args) {
        
    }
    
    public int minCapability(int[] nums, int k) {

        int low = Integer.MAX_VALUE;
        int end = 0;

        for(int i = 0; i < nums.length;i++){
            low = Math.min(low,nums[i]);
            end = Math.max(end,nums[i]);
        }

        int answer = -1;
        while(low <= end){
            int mid = end + (low - end)/2;

            if(isPossible(nums,k,mid)){
                answer = mid;
                end = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }

    public boolean isPossible(int[] nums, int k, int mid){

        int counter = 0;

        for(int i = 0; i < nums.length;i++){

            if(nums[i] <= mid){
                counter++;
                i++;
            }
        }

        return counter >= k;

    }
    
}
