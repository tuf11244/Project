/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *Date: 05/07/2024
 *https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 * @author parth
 */
public class ConnectingCitieswithMinimumCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] connections = {
            {1,2,5},
            {1,3,6},
            {2,3,1}
        };
        minimumCost(connections,3);
    }
    public static void minimumCost(int[][] connections, int n){
        List<cpair> [] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] connection : connections){
            int src = connection[0];
            int nbg = connection[1];
            int cost = connection[2];
            
            graph[src].add(new cpair(src,nbg,cost));
            graph[nbg].add(new cpair(nbg,src,cost));
        }
        
        int totalCost = 0;
        
        PriorityQueue<cpair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        
        pq.add(new cpair(0,1,0));
        while(!pq.isEmpty()){
            cpair rem = pq.poll();
            
            if(visited[rem.nbg] == true){
                continue;
            }
            totalCost = totalCost + rem.cost;
            visited[rem.nbg] = true;
            
            for(cpair p : graph[rem.nbg]){
                if(visited[p.nbg] == false){
                    pq.add(p);
                }
            }
        }
        // Check if all cities are visited
        for (int i = 1; i <= n; i++) {
        if (visited[i] == false) {
            System.out.println(-1);
            return;
        }
    }
        
        System.out.println(Arrays.toString(graph));
        System.out.println(totalCost);
    }
}

class cpair implements Comparable<cpair>{
    int src;
    int nbg;
    int cost;
    
    public cpair(int src,int nbg, int cost){
        this.src = src;
        this.nbg = nbg;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Pair{" + "src=" + src + ", nbg=" + nbg + ", cost=" + cost + '}';
    }

    
    
    
    @Override
    public int compareTo(cpair o) {
        return this.cost - o.cost;
    }
    
}
