/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/03/2024
 * https://leetcode.com/problems/path-with-maximum-probability/
 * @author parth
 */
public class PathwithMaximumProbability {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //Build the graph
        List<Pair3> [] graph = new ArrayList[n];

        for(int i =0; i < n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i < edges.length;i++){
            int[] edge = edges[i];
            int src = edge[0];
            int nbg = edge[1];
            double wt = succProb[i];

           graph[src].add(new Pair3(src,nbg,wt));
           graph[nbg].add(new Pair3(nbg,src,wt));
        }

        PriorityQueue<pqpair> pq = new PriorityQueue<>(); //max Heap
        pq.add(new pqpair(start_node,1.0));
        double[] probabilities = new double[n];
        probabilities[start_node] = 1.0;

        while(!pq.isEmpty()){
          pqpair rem = pq.poll();
        
            
          if(rem.v == end_node){
            return rem.wt;
          }

         

          for(Pair3 nbrs : graph[rem.v]){
            double newProb = rem.wt * nbrs.wt;
                if (newProb > probabilities[nbrs.nbg]) {
                    probabilities[nbrs.nbg] = newProb;
                    pq.add(new pqpair(nbrs.nbg, newProb));
                }
          }
        }
        return 0.0;
    }
}
class pqpair implements Comparable<pqpair>{
    int v;
    double wt;

    public pqpair(int v, double wt){
        this.v = v;
        this.wt = wt;
    }
    @Override
    public int compareTo(pqpair o){
        return Double.compare(o.wt, this.wt);
    }
}
class Pair3{
    int src;
    int nbg;
    double wt;

    public Pair3(int src, int nbg, double wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }
}

