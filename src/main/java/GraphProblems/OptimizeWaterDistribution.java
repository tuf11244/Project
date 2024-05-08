/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *Date: 05/07/2024
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 * https://www.geeksforgeeks.org/minimum-cost-to-provide-water/
 * @author parth
 */
public class OptimizeWaterDistribution {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] wells = {3,9,12,10,6};
        int[][] pipes = {
            {1,2,2},
            {1,4,12},
            {2,4,8},
            {2,3,4},
            {2,5,14},
            {3,5,7}
        };
       int answer = buildGraph(wells.length,wells,pipes);
        System.out.println(answer);
    }
    public static int buildGraph(int n, int[] wells, int[][] pipes){
        List<PairQ> [] graph = new ArrayList[n+1];
        
        //For n houses
        //Note that 0 is a dummy node for wells 
        for(int i = 0; i <=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        //Lets connect the wells 
        for(int i = 1; i <= n;i++){
             graph[i].add(new PairQ(0,wells[i-1]));
             graph[0].add(new PairQ(i,wells[i-1])); //For bi-direction connection
                        
        }
        
        //Lets connect the pipes
        for(int[] arr : pipes){
            int src = arr[0]; 
            int nbg = arr[1];
            int cost = arr[2];
            graph[src].add(new PairQ(nbg, cost));
            graph[nbg].add(new PairQ(src, cost)); // For bidirectional connection
        }
        
        System.out.println(Arrays.toString(graph));
        
        boolean[] visited = new boolean[n+1];
        
        return primsAlgo(graph,visited,wells);
    }
    public static int primsAlgo(List<PairQ> [] graph, boolean[] visited, int[] wells){
        int totalCost = 0;
        PriorityQueue<PairQ> pq = new PriorityQueue<>();
        
        pq.add(new PairQ(0,0));
        
        
        while(!pq.isEmpty()){
            PairQ rem = pq.poll();
            
            if(visited[rem.nbg] == true){
                continue;
            }
            visited[rem.nbg] = true;
            totalCost = totalCost + rem.cost;
            
            for(PairQ p : graph[rem.nbg]){
                if(visited[p.nbg] == false){
                    pq.add(new PairQ(p.nbg,p.cost));
                }
            }
            
        }
        
        return totalCost;
    }
}

class PairQ implements Comparable<PairQ>{
    int nbg;
    int cost;
    
    public PairQ(int nbg, int cost){
        this.nbg = nbg;
        this.cost = cost;
    }
    

    @Override
    public int compareTo(PairQ o) {
       return this.cost - o.cost;
    }
}
