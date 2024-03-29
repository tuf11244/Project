/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *DateL 03/14/2024
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * https://leetcode.com/problems/subarray-sums-divisible-by-k
 * https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
 * @author parth
 */
public class SubArraySumEqualsK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2, 2, -5, 12, -11, -1, 7};
        //subArraySum(arr,2);
        System.out.println(longSubArraywithSumDivbyK(arr,3));
    }
    public static int subArraySum(int[] arr, int k){
        //Create a Hashmap containing prefix sum and its frequency 
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int sum = 0;
        hm.put(0,1);
        for(int i = 0; i < arr.length;i++){
            sum = sum + arr[i];
            if(hm.containsKey(sum-k)){
                count = count + hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            
        }
        return count;
    }
    
    //https://leetcode.com/problems/subarray-sums-divisible-by-k
    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int remainder = 0;
        //Create a HashMap of remainder and its frequencies 
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        
        for(int i = 0; i < nums.length;i++){
            sum = sum + nums[i];
            remainder = sum % k;
            if(remainder < 0){
                remainder = remainder + k;
            }
            if(hm.containsKey(remainder)){
                count = count + hm.get(remainder);
                hm.put(remainder,hm.get(remainder)+1);
            }else{
                hm.put(remainder,1);
            }
        }       
        return count;
    }
    
   // https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
    public static int longSubArraywithSumDivbyK(int[] arr, int k){
        int maxLength = 0;
        //Create a HashMap of Remainder vs Index 
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int remainder = 0;
        hm.put(0,-1);
        for(int i = 0; i < arr.length;i++){
            sum = sum + arr[i];
            remainder = sum % k;
            if(remainder < 0){
                remainder = remainder + k;
            }
            if(hm.containsKey(remainder)){
                int length = i - hm.get(remainder);
                if(length > maxLength){
                    maxLength = length;
                }
            }else{
                hm.put(remainder,i);
            }
        }
        return maxLength;
    }
    
    
}
