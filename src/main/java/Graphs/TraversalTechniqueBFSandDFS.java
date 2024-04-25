/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 04/24/2024
 * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 * https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * @author parth
 */
public class TraversalTechniqueBFSandDFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class BFSSolution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            answer.add(node);
            
            for(Integer x : adj.get(node)){
                if(visited[x] == false){
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        return answer;
    }
}

class DFSSolution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean visited[] = new boolean[V];
        dfs(answer,visited,V,adj,0);
        return answer;
    }
    
    public void dfs(ArrayList<Integer> answer, boolean[] visited, int V, ArrayList<ArrayList<Integer>> adj, int startPoint){
        visited[startPoint] = true;
        answer.add(startPoint);
        
        for(Integer x : adj.get(startPoint)){
            if(visited[x] == false){
                dfs(answer,visited,V,adj,x);
            }
        }
    }
}
