package GraphProblemsPartII;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;

/**
 *Date: 07/28/2024
 * https://leetcode.com/problems/second-minimum-time-to-reach-destination/
 * @author parth
 */
public class SecondMinimumTimeToReachDestination {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<U>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph[src].add(new U(src, dest));
            graph[dest].add(new U(dest, src));
        }
        
        int[] minDistance1 = new int[n+1];
        int[] minDistance2 = new int[n+2];
        
        Arrays.fill(minDistance1,Integer.MAX_VALUE);
        Arrays.fill(minDistance2, Integer.MAX_VALUE);
        
        minDistance1[1] = 0;
        
        PriorityQueue<I> pq = new PriorityQueue<>();
        pq.add(new I(1,0));
        
        while(!pq.isEmpty()){
            I rem = pq.poll();
            
            if(minDistance2[n] != Integer.MAX_VALUE && rem.v == n){
                //Means we have reached the node 2 times so its the second minimum
                // We have reached the destination twice, return the second minimum time
                return minDistance2[n];
            }
            
            int signal = rem.time / change;
            if(signal % 2 != 0){ //signal is red
                int extraTime = rem.time % change;
                int waitingTime = change - extraTime;
                rem.time = rem.time + waitingTime;
            }else{ //signal is green
                rem.time = rem.time; //basically rem.time stays the same if its green
            }
            
            for(U e : graph[rem.v]){
                if(minDistance1[e.nbg] > rem.time + time){
                    minDistance2[e.nbg] = minDistance1[e.nbg];
                    minDistance1[e.nbg] = rem.time + time;
                    pq.add(new I(e.nbg,rem.time + time));
                }
                else if(minDistance2[e.nbg] > rem.time + time && minDistance1[e.nbg] != rem.time + time){
                    minDistance2[e.nbg] = rem.time + time;
                    pq.add(new I(e.nbg,rem.time + time));
                }
                
            }
        }
        return -1;
        
    }
}


class I implements Comparable<I>{
    int v;
    int time;
    
    public I(int v, int time){
        this.v = v;
        this.time = time;
    }

    @Override
    public int compareTo(I o) {
        return this.time - o.time;
    }
            
}


class U{
    int src;
    int nbg;
    
    public U(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}