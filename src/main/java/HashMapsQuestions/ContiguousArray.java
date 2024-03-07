/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/062024
 *https://leetcode.com/problems/contiguous-array/
 * https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/
 * @author parth
 */
public class ContiguousArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,0,0,1,0,1,1};
        System.out.println(countSubArrayswithEqual0sand1s(arr));
    }
    public static int findMaxLength(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                sum = sum + -1;
            }else{
                sum = sum + 1;
            }
            if(!hm.containsKey(sum)){
                 hm.put(sum,i);
            }else{
                int length = i - hm.get(sum);
                if(length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
    
    public static int countSubArrayswithEqual0sand1s(int[] arr){
        //Create a HashMap of sum and frequencies 
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                sum = sum -1;
            }else{
                sum = sum + 1;
            }
            
            if(!hm.containsKey(sum)){
                hm.put(sum,1);
            }else{
                int oldFrequency = hm.get(sum);
                count = count + oldFrequency;
                hm.put(sum,oldFrequency+1);
            }
        }
        return count;
        
    }
    
}
