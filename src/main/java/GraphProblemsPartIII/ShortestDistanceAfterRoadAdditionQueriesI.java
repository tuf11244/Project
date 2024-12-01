package GraphProblemsPartIII;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.util.*;
/**
 *Date : POTD 11/26/2024
 * https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/
 * @author parth
 */
public class ShortestDistanceAfterRoadAdditionQueriesI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];

        // Create a Graph
        List<Edge>[] graph = new ArrayList[n];

        // Initialize the graph with roads from city i to city i+1
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            graph[i].add(new Edge(i, i + 1));
        }

        // Process each query
        int index = 0;
        for (int[] edge : queries) {
            int src = edge[0];
            int nbg = edge[1];

            // Add the new road for the current query
            graph[src].add(new Edge(src, nbg));

            // Calculate the shortest distance from city 0 to city n-1
            answer[index] = bfs(graph, 0, n - 1);
            index++;
        }

        return answer;
    }

    public int bfs(List<Edge>[] graph, int src, int dest) {
        Queue<pair> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(new pair(src, 0));

        // BFS to find the shortest path from src to dest
        while (!queue.isEmpty()) {
            pair rem = queue.poll();

            // If we reach the destination, return the number of steps
            if (rem.v == dest) {
                return rem.steps;
            }
            if(visited.contains(rem.v)){
                continue;
            }
            visited.add(rem.v);

            // Visit all neighbors
            for (Edge e : graph[rem.v]) {
                if (!visited.contains(e.nbg)) {
                    queue.add(new pair(e.nbg, rem.steps + 1));
                }
            }
        }

        return -1; // No path found
    }
}

class pair {
    int v;
    int steps;

    public pair(int v, int steps) {
        this.v = v;
        this.steps = steps;
    }
}

class Edge {
    int src;
    int nbg;

    public Edge(int src, int nbg) {
        this.src = src;
        this.nbg = nbg;
    }
}

