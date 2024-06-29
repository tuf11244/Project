/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/28/2024
 *https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 * @author parth
 */
public class AllancestorsofaNodeinDAG {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> answer = new ArrayList<>();
        List<link> [] graph = new ArrayList[n];
        for(int i = 0; i < n;i++){
           graph[i] = new ArrayList<>();
        }   
        //Reverse the graph
        for(int[] edge : edges){
            int src = edge[0];
            int nbg = edge[1];
            graph[nbg].add(new link(nbg, src));

        }

        for(int i =0; i < n;i++){
            List<Integer> temp = new ArrayList<>();
            dfs(i,temp,graph);
            Collections.sort(temp);
            answer.add(temp);
        }

        return answer;

    }

    public void dfs(int src, List<Integer> temp, List<link>[] graph){
        if(graph[src] == null){
            return;
        }

        for(link e : graph[src]){
            if(temp.contains(e.nbg)){
                continue;
            }
            temp.add(e.nbg);
            dfs(e.nbg,temp,graph);
        }
    }
}

class link{
    int src;
    int nbg;

    public link(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
