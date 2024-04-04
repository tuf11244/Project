/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *Date: 04/03/2024
 *https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 * @author parth
 */
public class MinimumCosttoHireKWorkers {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here    
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        double answer = mincostToHireWorkers(quality,wage,2);
        System.out.println(answer);
    }
    
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
         int n = quality.length;
        Worker[] workers = new Worker[n];
        
        // Create Worker objects with quality, wage, and ratio
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        // Sort the workers based on their wage-to-quality ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        
        // Max heap to keep track of the maximum quality within a given window
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int sumQuality = 0; // Initialize the sum of quality
        double minCost = Double.MAX_VALUE; // Initialize the minimum cost

        // Iterate through the sorted workers
        for (Worker worker : workers) {
            maxHeap.offer(worker.quality); // Add the quality of the current worker to the max heap
            sumQuality += worker.quality; // Update the sum of quality
            
            // If the window size exceeds k, remove the worker with the highest quality
            if (maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }
            
            // If the window size is equal to k, calculate the cost and update the minimum cost
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, sumQuality * worker.ratio);
            }
        }

        return minCost; // Return the minimum cost
    }
}
// Worker class to represent a worker with quality, wage, and ratio
class Worker {
    int quality; // Quality of the worker
    int wage; // Wage of the worker
    double ratio; // Wage-to-quality ratio of the worker

    // Constructor to initialize the Worker object
    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
        this.ratio = (double) wage / quality; // Calculate the wage-to-quality ratio
    }
}

