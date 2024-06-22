/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/21/2024
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 * @author parth
 */
public class NumberWaystoArriveatDestination {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }


    public static int countPaths(int n, int[][] roads) {
      List<Edge1>[] graph = new ArrayList[n];
        for(int i =0; i < n;i++){
            graph[i] = new ArrayList<>();     
        }
        
        for(int[] road : roads){
            int src = road[0];
            int nbg = road[1];
            int wt = road[2];
            
            graph[src].add(new Edge1(src,nbg,wt));
            graph[nbg].add(new Edge1(nbg,src,wt));
        }
        
        
        PriorityQueue<P> pq = new PriorityQueue<>();
        pq.add(new P(0,0));
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int[] ways = new int[n];
        
        distance[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9+7);
        
        while(!pq.isEmpty()){
           P rem = pq.poll();
           
           for(Edge1 e : graph[rem.v]){
               if(rem.wsf + e.wt < distance[e.nbg]){
                   distance[e.nbg] = rem.wsf + e.wt;
                   pq.add(new P(e.nbg,rem.wsf + e.wt));
                   ways[e.nbg] = ways[rem.v];
               }
               else if(rem.wsf + e.wt == distance[e.nbg]){
                   ways[e.nbg] = (ways[e.nbg] + ways[rem.v]) % mod;
               }
           }
            
        }
        return ways[n-1]%mod;  
    }
}

class P implements Comparable<P>{
     int v;
     int wsf;
     
     public P(int v, int wsf){
         this.v = v;
         this.wsf = wsf;
     }

    @Override
    public int compareTo(P o) {
        return this.wsf - o.wsf;
    }
}

class Edge1{
    int src;
    int nbg;
    int wt;
    
    public Edge1(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }
}
