/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date: 03/06/2024
 * @author parth
 */
public class LongestSubarraywithequal0s1sand2s {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,1,2,0,1,0,1,2,1,2,2,0,1};
       // System.out.println(longestsubarraywithEqual0s1s2s(arr));
        System.out.println(countSubArrayswithEqual0s1sand2s(arr));
    }
    
    public static int longestsubarraywithEqual0s1s2s(int[] arr){
        int maxLength = 0;
        HashMap<String,Integer> hm = new HashMap<>();
        int count0s = 0;
        int count1s = 0;
        int count2s = 0;
        
        //Difference between count1 - count0
        int delta10 = count1s - count0s;
        //Difference between count2 - count1;
        int delta21 = count2s - count1s;
        
        String key = delta10 + "#" + delta21;
        hm.put(key,-1);
        
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                count0s++;
            }else if(arr[i] == 1){
                count1s++;
            }else{
                count2s++;
            }
            
            //Calcuate Delta again
            delta10 = count1s - count0s;
            delta21 = count2s - count1s;
            key = delta10 + "#" + delta21;
            if(!hm.containsKey(key)){
                hm.put(key, i);
            }
            else{
                int length = i - hm.get(key);
                if(length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;        
    }
    
    
    //Count of subarrays with equal number of 0s,1s and2s
    public static int countSubArrayswithEqual0s1sand2s(int[] arr){
        int count = 0;
        HashMap<String,Integer> hm = new HashMap<>();
        int count0s = 0;
        int count1s = 0;
        int count2s = 0;
        
        //Difference between count1 - count0
        int delta10 = count1s - count0s;
        //Difference between count2 - count1;
        int delta21 = count2s - count1s;
        
        String key = delta10 + "#" + delta21;
        hm.put(key, 1);
        for(int i = 0; i < arr.length;i++){
              if(arr[i] == 0){
                count0s++;
            }else if(arr[i] == 1){
                count1s++;
            }else{
                count2s++;
            }
            
            //Calcuate Delta again
            delta10 = count1s - count0s;
            delta21 = count2s - count1s;
            key = delta10 + "#" + delta21;
            if(!hm.containsKey(key)){
                hm.put(key, 1);
            }else{
                int oldFrequency = hm.get(key);
                count = count + oldFrequency;
                hm.put(key, oldFrequency + 1);
            }
        }
        return count;
    }
}
