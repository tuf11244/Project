/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 *DateL 03/14/2024
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * https://leetcode.com/problems/subarray-sums-divisible-by-k
 * @author parth
 */
public class SubArraySumEqualsK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3};
        subArraySum(arr,2);
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
        
        
        return count;
    }
}
