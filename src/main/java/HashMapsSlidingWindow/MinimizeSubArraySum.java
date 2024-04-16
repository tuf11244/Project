/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 04/16/2024
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * @author parth
 */
public class MinimizeSubArraySum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int answer = nums.length;
        int j = 0;
        int sum = 0;
        //EdgeCase 
        int prefixSum = 0;
        for(int i = 0; i < nums.length;i++){
            prefixSum = prefixSum + nums[i];
        }
        if(prefixSum < target){
            return 0;
        }
        for(int i = 0; i < nums.length;i++){
            sum = sum + nums[i];
            
            //sum is greater than equal to target 
            while(sum >= target){
                //Calculate the length;
                int length = i - j + 1;
                answer = Math.min(answer,length);
                //Shrink our window 
                sum = sum - nums[j];
                j++;
            }
        }
        return answer;
    }
}
