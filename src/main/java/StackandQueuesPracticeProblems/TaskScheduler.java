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
        int[] frequency = new int[26]; // Frequency array for each task

        // Count the frequency of each task
        for (char task : tasks) {
            frequency[task - 'A']++;
        }
        System.out.println(Arrays.toString(frequency));
        // Find the task with the maximum frequency
        int maxFrequency = 0;
        for (int freq : frequency) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        // Calculate the number of tasks with maximum frequency
        int countMaxFrequency = 0;
        for (int freq : frequency) {
            if (freq == maxFrequency) {
                countMaxFrequency++;
            }
        }

        // Calculate the minimum time required to execute the tasks
        int idleSlots = (n - countMaxFrequency + 1) * (maxFrequency - 1);
        int remainingTasks = tasks.length - maxFrequency * countMaxFrequency;
        int idleTime = Math.max(0, idleSlots - remainingTasks);

        return tasks.length + idleTime;
    }
}
