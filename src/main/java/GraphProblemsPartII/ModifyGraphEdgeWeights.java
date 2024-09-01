/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 08/31/2024
 *https://leetcode.com/problems/modify-graph-edge-weights/
 * @author parth
 */
public class ModifyGraphEdgeWeights {
    private static final int LARGE_VALUE = (int) 2e9;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
       
        
        
        int shortestDistance = djikstra(n,edges,source,destination);
        
        if(shortestDistance < target){
            return new int[0][0];
        }
        boolean matched = shortestDistance == target;
        
        if(matched){ //shortestDistance == target
             for(int[] edge : edges){
                if(edge[2] < 0){
                    edge[2] = LARGE_VALUE;
                }
            }
            return edges;
        }
        
       for(int[] edge : edges){
            if(edge[2] == -1){
           edge[2] = (matched == true) ? LARGE_VALUE : 1; //assing the smallest possible value 
           if(matched == false){
               
           int newShortestDistance = djikstra(n,edges,source,destination);
           
           if(newShortestDistance <= target){
               matched = true;
               edge[2] = edge[2] + (target - newShortestDistance);
             }
            }
            }
       }
       if(matched == false){
           return new int[0][0];
       }
       return edges;
    }
    
    public static int djikstra(int n,int[][] edges, int source, int dest){
        
        //Build the graph 
        List<Graph> [] graph = new ArrayList[n];
        for(int i = 0; i < n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int nbg = edge[1];
            int wt = edge[2];
            
            graph[src].add(new Graph(src,nbg,wt));
            graph[nbg].add(new Graph(nbg,src,wt));
        }
        PriorityQueue<coord> pq = new PriorityQueue<>();
        
        pq.add(new coord(source,0));
        boolean visited[] = new boolean[graph.length];
        
        while(!pq.isEmpty()){
            coord rem = pq.poll();
            
            if(rem.v == dest){
                return rem.wt;
            }
            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            
            for(Graph e : graph[rem.v]){
                if(visited[e.nbg] == false && e.wt > 0){
                    pq.add(new coord(e.nbg,rem.wt + e.wt));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
class coord implements Comparable<coord>{
    int v;
    int wt;
    
    public coord(int v, int wt){
        this.v = v;
        this.wt = wt;
    }

    @Override
    public int compareTo(coord o) {
        return this.wt - o.wt;
    }
}
class Graph{
    int src;
    int nbg;
    int wt;
    
    public Graph(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }
}
