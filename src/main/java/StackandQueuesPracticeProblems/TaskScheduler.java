/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

//https://leetcode.com/problems/task-scheduler/
import java.util.Arrays;
public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26]; // Frequency array for each task

        // Count the map of each task
        for (char task : tasks) {
            map[task - 'A']++;
        }
        System.out.println(Arrays.toString(map));
        Arrays.sort(map);
        System.out.println(Arrays.toString(map));
        // Find the task with the maximum map
        int maxFrequency = map[25];
       
        int holes = maxFrequency - 1;
        /*
        for example A - 4
                    B - 3
                    C - 2
        and n = 2
        holes is -- between  A--A--A--A
        
        */
        int idleSlots = holes * n;
        for(int i = 24; i >= 0; i--){
            idleSlots = idleSlots - Math.min(map[i],holes);
        }
        
        if(idleSlots > 0){
            return tasks.length + idleSlots;
        }
        return tasks.length;
    }
}
