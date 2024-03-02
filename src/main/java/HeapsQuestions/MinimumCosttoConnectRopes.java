/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.PriorityQueue;

/**
 * Date: 03/01/2024
 *https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 * @author parth
 */
public class MinimumCosttoConnectRopes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] nums = {2,4,3};
       minimizeCost(nums);
    }
    public static void minimizeCost(int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x : nums){
            pq.add(x);
        }
       
        int totalCost = 0;
        while(pq.size() >= 2){
            int first = pq.poll();
            int second = pq.poll();
            totalCost = totalCost + first + second;
            pq.add(first+second);
        }
        
        System.out.println(totalCost);
    }
}
