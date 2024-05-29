/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/28/2024
 * https://leetcode.com/problems/find-eventual-safe-states/
 * @author parth
 */
public class FindEventualSafeStates {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] graph = {
            {1,2},
            {2,3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        
        eventualSafeNodes(graph);
    }
    
    public static List<Integer> eventualSafeNodes(int[][] graph){
        //Reverse the graph 
        List<List<Integer>> adj = new ArrayList<>();
        
        //we are using kahn algorithm to see what nodes are part of a cycle
        int[] indegree = new int[graph.length];
        
        for(int i = 0;i < graph.length;i++){
            adj.add(new ArrayList<>());
        }
        
        //Reverse the graph
        for(int u = 0; u < graph.length;u++){
             for(int v : graph[u]){
                 adj.get(v).add(u);
                 indegree[u]++;
             }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        //We add all the vertices with indegree 0 for kahn algorithm 
        for(int i = 0; i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
       
        boolean[] isSafe = new boolean[graph.length];
        
        while(!queue.isEmpty()){
            //if it was added in queue that means it wasn;t a part of cycle 
            int rem = queue.poll();
            
            isSafe[rem] = true; //this is a safe vertex 
            //Decrease the indegree of the neighbours
            List<Integer> list = adj.get(rem);
            for(int v : list){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.add(v);
                }
           }           
        }
        
       // System.out.println(Arrays.toString(isSafe));
       List<Integer> answer = new ArrayList<>();
       for(int i = 0; i < graph.length;i++){
           if(isSafe[i] == true){
                answer.add(i);
           }
       }
       return answer; 
    }
    
}

