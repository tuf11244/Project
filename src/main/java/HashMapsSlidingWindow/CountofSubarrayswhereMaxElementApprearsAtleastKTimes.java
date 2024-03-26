/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 03/25/2024
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 * @author parth
 */
public class CountofSubarrayswhereMaxElementApprearsAtleastKTimes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public long countSubarrays(int[] nums, int k) {
       int count = 0;
       long total = 0;
        int j = 0;
        int max = -1;
       for(int t = 0; t < nums.length;t++){
         max = Math.max(max, nums[t]);
       }

       for(int i = 0; i < nums.length;i++){
        if(nums[i] == max){
            count++;
        }

         while(count >=k){
            total = total + nums.length - i;
            if(nums[j] == max){
            count --;
         }
         j++;
       }       

    }
    return total;
}
}
