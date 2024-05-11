/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;
/**
 *Date: 05/10/2024
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * Based of Tarjan's Algorithm to find Articulation Point 
 * In this case we just return the bridges 
 * @author parth
 */
public class CriticalConnectioninNetwork {
    public static int[] parent;
    public static int[] discovery;
    public static int[] low;
    public static boolean[] visited;
    public static int time;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        List<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(0);
        List<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(3);
        
        connections.add(a);
        connections.add(b);
        connections.add(c);
        connections.add(d);
        
        criticalConnections(4,connections);
    }
    
    public static void criticalConnections(int n, List<List<Integer>> connections){
        
        //Build the graph
        List<C> [] graph = new ArrayList[n];
        for(int i = 0; i < n;i++){
            graph[i] = new ArrayList<>();
            
        }
        
        for(List<Integer> conn : connections){
            int src = conn.get(0);
            int nbg = conn.get(1);
            
            graph[src].add(new C(src,nbg));
            graph[nbg].add(new C(nbg,src));
        }
        
        System.out.println(Arrays.toString(graph));
        
        parent  = new int[n];
        discovery = new int[n];
        low = new int[n];
        visited = new boolean[n];
        time = 0;
        List<List<Integer>> answer = new ArrayList<>();
        dfs(0,graph,answer);
          
        for(List<Integer> K : answer){
            System.out.println("The answer is " + K);
       }
        
    }
    
    public static void dfs(int src, List<C> [] graph,List<List<Integer>> answer){
        discovery[src] = time;
        low[src] = time;
        time++;
        visited[src] = true;
        List<C> nbrs = graph[src];
        
        for(int i = 0; i < nbrs.size();i++){
            int nbg = nbrs.get(i).nbg;
            
            if(parent[src] == nbg){
                continue;
            }
            else if(visited[nbg] == true){
                low[src] = Math.min(low[src], discovery[nbg]);
            }
            else{
                //Make the neighbour visited 
                parent[nbg] = src;
                dfs(nbg,graph,answer);
                low[src] = Math.min(low[src], low[nbg]); //backtracking
                
                 if(low[nbg] > discovery[src]){
                     List<Integer> temp = new ArrayList<>();
                     temp.add(src);
                     temp.add(nbg);
                     answer.add(temp);
                }
                
            }
        }
    }
}

class C{
    int src;
    int nbg;
    
    public C(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }

    @Override
    public String toString() {
        return "C{" + "src=" + src + ", nbg=" + nbg + '}';
    }
    
    
}
