/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 11/27/2024
 * https://leetcode.com/problems/parallel-courses-iii/
 * @author parth
 */
public class ParallelCoursesIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int minimumTime(int n, int[][] relations, int[] time) {

        // Create an adjacency list for the graph and an indegree array
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];

        // Initialize graph
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph and calculate indegrees
        for (int[] relation : relations) {
            int src = relation[0];
            int dest = relation[1];
            graph[src].add(dest);
            indegree[dest]++;
        }

        // Use a queue for Kahn's algorithm and a dp array for tracking completion times
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[n + 1]; // dp[i] = minimum time to complete course i

        // Initialize queue with courses having no prerequisites
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i - 1]; // Initial time for courses with no prerequisites
            }
        }

        // Process courses in topological order
        while (!queue.isEmpty()) {
            int course = queue.poll();

            // Update times for neighbors
            for (int neighbor : graph[course]) {
                dp[neighbor] = Math.max(dp[neighbor], dp[course] + time[neighbor - 1]);
                indegree[neighbor]--;

                // Add to queue if all prerequisites are completed
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // The result is the maximum time among all courses
        int totalTime = 0;
        for (int i = 1; i <= n; i++) {
            totalTime = Math.max(totalTime, dp[i]);
        }

        return totalTime;
    }
}
