/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * Multiple Ways to Solve the problem
 * @author parth
 */
public class MaximumProductof2ElementsinArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,5,4,5};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : arr){
            pq.add(x);
        }
        int max1 = pq.poll();
        int max2 = pq.poll();
        
        return (max1-1) * (max2-1);
}
}
