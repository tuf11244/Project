/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapTopKPatternQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *Date: 02/28/2024
 * https://leetcode.com/problems/top-k-frequent-elements/
 * @author parth
 */
public class TopKFrequentElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
         
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
