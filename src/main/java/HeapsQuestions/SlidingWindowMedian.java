/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *Date: 04/02/2024
 * Passes 42/43 test cases
 * https://leetcode.com/problems/sliding-window-median/
 * @author parth
 */
public class SlidingWindowMedian {
   //Max PriorityQueue and Min PriorityQueue 
      public static PriorityQueue<Integer> minHeap = new PriorityQueue<>() ;
      public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {1,2,3,4,2,3,1,4,2};
        double[] arr = medianSlidingWindow(nums,3);
        System.out.println(Arrays.toString(arr));
    }
    private static void add(int num){
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        //balance heap
        balance();
    }
    private static void balance(){
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    private static void remove(int num){
        //remove element from the correct heap
        if(num <= maxHeap.peek()){
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }
        //balance heap
        balance();
    }
    private static double findMedian(){
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        return maxHeap.peek()/2.0 + minHeap.peek() /2.0;
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int j = 0;
        double[] result = new double[nums.length - k + 1 ];
        
        for(int i=0; i < nums.length; i++) {
            add(nums[i]);
            int size = (i - j + 1);
            if(size == k) {
                result[j] = findMedian();
                remove(nums[j]); // remove the j number as we move forward the next window size
                j++; // move j window ahead
            }
        }
        
        
        return result;
    }
    
    
}
