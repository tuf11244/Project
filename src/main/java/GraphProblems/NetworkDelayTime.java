/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;

/**
 *Date: 05/09/2024
 * https://leetcode.com/problems/network-delay-time/
 * @author parth
 */
public class NetworkDelayTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] times = {
            {1,2,1}
        };
        
        int ans = networkDelayTime(times,2,2);
        System.out.println(ans);
    }
    public static int networkDelayTime(int[][] times, int n, int k){
        List<N> [] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] time : times){
            int src = time[0];
            int nbg = time[1];
            int wt = time[2];
            
            graph[src].add(new N(src,nbg,wt));
        }
        
        graph[0].add(new N(0,k,0)); //dummy edge for our source 
        PriorityQueue<pairpq> pq = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();
        
        pq.add(new pairpq(0,0));
        
        while(!pq.isEmpty()){
            pairpq rem = pq.poll();
            
            if(visited.contains(rem.v)){
                continue;
            }
            if(visited.size() == n){
                return rem.wsf;
            }
            visited.add(rem.v);
            
            for(N edges : graph[rem.v]){
                if(visited.contains(edges.nbg) == false){
                    pq.add(new pairpq(edges.nbg,rem.wsf+edges.wt));
                }
            }
            
        }
        System.out.println(Arrays.toString(graph));
        return -1;
    }
}
class pairpq implements Comparable<pairpq>{
    int v;
    int wsf;
    
    public pairpq(int v, int wsf){
        this.v = v;
        this.wsf = wsf;
    }

    @Override
    public int compareTo(pairpq o) {
        return this.wsf - o.wsf;
    }
    
}

class N{
    int src;
    int nbg;
    int wt;
    
    public N(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }

    @Override
    public String toString() {
        return "N{" + "src=" + src + ", nbg=" + nbg + ", wt=" + wt + '}';
    }
    
}
