/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Date: 02/28/2024
 *https://leetcode.com/problems/top-k-frequent-elements/
 * @author parth
 */
public class TopKFrequentElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {4,1,-1,2,-1,2,3};
        
        int[] answer = topKFrequentUsingHashMaps(nums,2);
    }
   
    
     public static int[] topKFrequentUsingHashMaps(int[] nums, int k){
         HashMap<Integer,Integer> hm = new HashMap<>();
         
         //Build a Frequency Map
         for(int i = 0; i < nums.length;i++){
             if(hm.containsKey(nums[i])){
                 int oldFrequency = hm.get(nums[i]);
                 int newFrequency = oldFrequency + 1;
                 hm.put(nums[i],newFrequency);
             }else{
                 hm.put(nums[i],1);
             }
         }
         System.out.println(hm);
         
         //Create an Priority Queue of arrays min which is sorted based on frequencies
         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] arr) -> arr[1]));
         
         for(Integer element : hm.keySet()){
             pq.add(new int[]{element,hm.get(element)});
             if(pq.size() > k){
                 pq.poll();
             }
         }
         
         int[] answer = new int[pq.size()];
         int i = 0;
         while(!pq.isEmpty()){
            int[] pair = pq.poll();
            answer[i] = pair[0];
            i++;
         }
         return answer;
         
}
}
    
 

