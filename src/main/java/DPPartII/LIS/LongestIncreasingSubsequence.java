/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *Date: 08/06/2024
 *https://leetcode.com/problems/longest-increasing-subsequence/
 * @author parth
 */
public class LongestIncreasingSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Time Complexity = 0(N^2);
    public static int lengthofLIS(int[] nums){
        
        int[] dp = new int[nums.length];
        int answer = 0;
        for(int i = 0; i < dp.length;i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                   max = Math.max(dp[j], max);                    
            }
            }
            dp[i] = max + 1;
            answer = Math.max(answer,dp[i]);
        
    }
      return answer;  
    }
    
    //Time Complexity = O(NlogN)
    
    public static int LISusingBS(int[] nums){
        
        List<Integer> sorted = new ArrayList<>();
        
        for(int i = 0; i < nums.length;i++){
             /*
                Why lower bound?
                We want an increasing subsequence, and hence
                we want to eliminate the duplicates as well.
                lower_bound returns the index of "next greater or equal to."
            */
             int index = lowerBoundBS(sorted,nums[i]);
             
             /*
             If no such index is found (i.e., answer remains -1), 
             the element is larger than all current elements in the sorted list, and it should be appended to the end.
             
             If index is -1, the element should be appended to sorted.
             If index is a valid index, the element at that index should be replaced with nums[i]
             */
             if(index == -1){ //meaning no element equal to greater found
                 sorted.add(nums[i]); //greater element so false
                 
             }else{ //meaning we found a index of the element that is greater than or equal to our nums[i]
                 sorted.set(index,nums[i]); //so we replace
            }
    }
        return sorted.size();
    }
    
    
    private static int lowerBoundBS(List<Integer> sorted, int target){
        int low = 0;
        int end = sorted.size();
        int answer = -1;
        
        while(low < end){
            int mid = low + (end - low)/2;
            
            if(sorted.get(mid) < target){
                low = mid + 1;
            }else{
                answer = mid; //could be potential answer
                end = mid;
                
            }
        }
        return answer;
        
        
    }
}
