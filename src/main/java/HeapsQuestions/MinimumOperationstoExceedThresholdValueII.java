/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 02/12/2025
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
 * @author parth
 */
public class MinimumOperationstoExceedThresholdValueII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int x : nums) {
            pq.add((long)x);  // Store as long
        }
        
        int steps = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long add = num1 * 2 + num2;  // Ensure correct long computation
            pq.add(add);
            steps++;
        }
        
        return steps;
    }
}
