/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathsforDSA;

/**
 * Date: 05/23/2025
 * LeetCode: https://leetcode.com/problems/find-the-maximum-sum-of-node-values/
 * Problem: You are given a tree and can apply XOR operation with a fixed value k to any subset
 *          of nodes. The goal is to maximize the total sum of node values after applying XOR.
 *          However, XOR must be applied to an **even number** of nodes (including 0).
 * Approach: Greedy + Counting + Bit Manipulation.
 * Author: parth
 */
public class FindMaximumSumOfNodeValues {
    public static void main(String[] args) {
        // Test cases can be added here if needed
    }

    /**
     * @param nums  - Initial values at each node
     * @param k     - XOR value that can be applied to any number of nodes
     * @param edges - Edge list of the tree (unused in this logic as it doesn't affect the value)
     * @return Maximum possible sum of node values after applying XOR to any even-sized subset
     */
    public long maximumValueSum(int[] nums, int k, int[][] edges){
        long sum = 0;           // Stores the total sum after optimal XORing
        int count = 0;          // Count of nodes where XOR gives a better value
        int loss = Integer.MAX_VALUE; // Minimum "loss" in switching one XORed node back to original

        // Iterate over each node's value
        for(int num : nums){
            
            // If XORing this value with k increases the value, we consider it
            if((num ^ k) > num){
                sum += (num ^ k);   // Add the increased value
                count++;            // Count this as an XORed node
            }else{
                sum += num;         // Otherwise, keep the original value
            }
            
            // Compute the loss if we *undo* one XOR (needed when count is odd)
            loss = Math.min(loss, Math.abs((num ^ k) - num));
        }

        // We are only allowed to apply XOR to an even number of nodes.
        // If count is even, we are good; return the total sum directly.
        if(count % 2 == 0){
            return sum;
        }

        // If count is odd, we must undo one XORed node to make count even.
        // Undoing the one with minimum loss gives the best result.
        return sum - loss;
    }
}
