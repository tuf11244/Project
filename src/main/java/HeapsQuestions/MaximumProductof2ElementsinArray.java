/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Multiple Ways to Solve the problem
 * @author parth
 */
public class MaximumProductof2ElementsinArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,5,4,5};
        //System.out.println(maxProduct(arr));
        int[] nums = {7,10,4,3,20,15};
        //System.out.println(findkthLargest(nums,2));
        System.out.println(findkthSmallest(nums,3));
    }
    public static int maxProduct(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x : arr){
            pq.add(x);
        }
        System.out.println(pq);
        int max1 = pq.poll();
        int max2 = pq.poll();
        
        return (max1-1) * (max2-1);
}
    public static int findkthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x: nums){
            pq.add(x);
        }
        System.out.println(pq);
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
    
    public static int findkthSmallest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x: nums){
            pq.add(x);
        }
        System.out.println(pq);
        
        
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
    
}
