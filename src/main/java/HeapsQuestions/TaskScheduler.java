/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *Date: 04/04/2024
 *https://leetcode.com/problems/task-scheduler
 * @author parth
 */
public class TaskScheduler {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        char[] tasks = {'A','A','A', 'B','B','B'};
       int answer = leastInterval(tasks,2);
        System.out.println(answer);
    }
    
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        String s = new String(tasks);
        for(int i = 0; i < s.length();i++){
            map[s.charAt(i)-'A']++;
        }
     //   System.out.println(Arrays.toString(map));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int i = 0; i < map.length;i++){
           if(map[i] > 0){
               pq.add(map[i]);
           }
       }
        int time = 0;
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> list = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    list.add(currentFreq - 1);
                }
                taskCount++;
                cycle--;
            }
            // Restore updated frequencies to the heap
            for (int updatedFreq : list) {
                pq.offer(updatedFreq);
            }
                // Add time for the completed cycle
            if (pq.isEmpty()) {
                time += taskCount;
            } else {
                 time += n + 1;
            }     
        }
        return time;
    }
              
} 
    
   
