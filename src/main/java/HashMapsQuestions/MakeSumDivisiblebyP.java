/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 10/10/2024
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 * @author parth
 */
public class MakeSumDivisiblebyP {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int minSubArray(int[] nums, int p){
        int sum = 0;
        
        for(int num : nums){
            sum = (sum + num) % p; //so that the value of sum doesn't go more thant int capacity 
        }
        
        if(sum % p == 0){
            return 0;
        }
        
        int target = sum % p;
        
        int minLength = nums.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0, -1); // To handle the case where the whole prefix is the answer
        
        int currentSum = 0;
        for(int i = 0; i < nums.length;i++){
             currentSum = (currentSum + nums[i]) % p;
            
             // Calculate what we need to remove
            int needed = (currentSum - target + p)%p;
            
            if(hm.containsKey(needed)){
                minLength = Math.min(minLength, i - hm.get(needed));
            }
            
            // If we have seen the needed remainder, we can consider this subarray
            hm.put(currentSum,i);
        }
        
        return minLength == nums.length ? -1 : minLength;
        
    }
}
