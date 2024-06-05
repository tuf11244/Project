/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/05/2024
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * @author parth
 */
public class MinCosttoConnectAllPoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minCostConnectPoints(int[][] matrix) {
        //Build the graph 
        List<Pair4> [] graph = new ArrayList[matrix.length];
        for(int i =0; i < matrix.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < matrix.length;i++){
            for(int j = i+1; j < matrix.length;j++){
                int [] point1 = matrix[i];
                int [] point2 = matrix[j];
                int wt = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                graph[i].add(new Pair4(i,j,wt));
                graph[j].add(new Pair4(j,i,wt));
            }
        }

        PriorityQueue<pqPair> pq = new PriorityQueue<>();
        pq.add(new pqPair(0,0));
        int cost = 0;
        boolean[] visited = new boolean[matrix.length];
        while(!pq.isEmpty()){
            pqPair rem = pq.poll();

            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            cost = cost + rem.wt;
            for(Pair4 p : graph[rem.v]){
                if(visited[p.nbg] == false){
                    pq.add(new pqPair(p.nbg,p.wt));
                }
            }
        }
    return cost;

    }
}
class pqPair implements Comparable<pqPair>{
    int v;
    int wt;

    public pqPair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
    public int compareTo(pqPair o){
        return this.wt - o.wt;
    }
}

class Pair4{
    int src;
    int nbg;
    int wt;

    public Pair4(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }
}

