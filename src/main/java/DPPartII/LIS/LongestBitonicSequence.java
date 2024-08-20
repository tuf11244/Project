/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;

/**
 *Date: 08/07/2024
 * https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
 * @author parth
 */
public class LongestBitonicSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minimumMountainRemovals(int[] nums){
        int n = nums.length;
        int[] LIS = new int[n]; //longest increasing subsequence 
        int[] LDS = new int[n]; //longest decreasing subsequence 
        
       for(int i = 0; i < n;i++){
           int max = 0; 
           
           for(int j = 0; j < i;j++){
               if(nums[j] < nums[i]){
                   max = Math.max(LIS[j],max);
               }
           }
           LIS[i] = max + 1;
       }
       
       for(int i = n - 1; i >= 0; i--){
           int max = 0;
           for(int j = n-1; j > i;j--){
               if(nums[j] < nums[i]){
                   max = Math.max(LDS[j], max);
               }
           }
           LDS[i] = max + 1;
       }
       
       int maxMountain = 0;
       
       for(int i = 0; i < n;i++){
           if(LIS[i] > 1 && LDS[i] > 1){
           maxMountain = Math.max(maxMountain, LIS[i] + LDS[i] - 1);
       }
       }
       return n - maxMountain;
    }
}
