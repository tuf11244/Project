/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/06/2024
 *https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 * @author parth
 */
public class LargestSubArraywithzeroSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {6,-1,-3,4,-2,2,4,6,-12,-7};
       // System.out.println(largestSubArray(arr));
        System.out.println(countSubArrayswithZeroSum(arr));
    }
    public static int largestSubArray(int[] arr){
        //We are creating a hashmap that stores the prefix sum with the index 
        HashMap<Integer,Integer> hm = new HashMap<>();
        //Below we have 0 prefix sum at index -1;
        hm.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for(int i = 0; i < arr.length;i++){
            sum = sum + arr[i];
            //Our hashmap doesnt; contain the sum we simply add it in our hashmap 
            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }else{
               //If the sum is already present in our hashmap, than we calculate the length from the index it was present at 
               int length = i - hm.get(sum);
               if(length > maxLength){
                   maxLength = length;
               }
            }
        }
        return maxLength;
    }
    
    
    public static int countSubArrayswithZeroSum(int[] arr){
        //This time we are creating a HashMap of sum and its frequencies 
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int sum = 0;
        //Below statement means that the sum of 0 has occurred 1 time
        hm.put(0,1);
        int count = 0;
       for(int i = 0; i < arr.length;i++){
           sum = sum + arr[i];
           if(!hm.containsKey(sum)){
               hm.put(sum, 1);
           }else{
               //if the sum is already present in our hashmap;
               int oldFrequency = hm.get(sum);
               count = count + oldFrequency;
               //put the sum back in the hash map and increase the oldFrequency + 1;
               hm.put(sum,oldFrequency+1);
           }
       }
        return count;
    }
}
