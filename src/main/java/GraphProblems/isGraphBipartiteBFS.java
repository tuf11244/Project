/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *Date: 04/25/2024
 * https://leetcode.com/problems/is-graph-bipartite/
 * @author parth
 */
public class isGraphBipartiteBFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }


    public static boolean isBipartite(int[][] graph) {
        //Convert the matrix in adjacency list 
        int vertices = graph.length;
        List<Edge> [] adjList = new ArrayList[vertices];
        
        //Below code is to convert the matrix into adjacency matrix 
        for(int i = 0; i < graph.length;i++){
            adjList[i] = new ArrayList<>();
            for(int j = 0; j < graph[i].length;j++){
                int neighbour = graph[i][j];
                adjList[i].add(new Edge(i,neighbour));
            }
        }

        int visited[] = new int[vertices];
        Arrays.fill(visited,-1);
        for(int v = 0; v < vertices;v++){
            if(visited[v] == -1){
                boolean isBipartite = isBipartiteBFS(adjList,visited,v);
                if(isBipartite == false){                 
                    return false;
                }
            }
        }
        return true;
    }
    public static  boolean isBipartiteBFS(List<Edge> [] adjList, int[] visited, int src){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,src+"",0));

        while(!queue.isEmpty()){
            Pair rem = queue.poll();
            if(visited[rem.v] != -1){ //means is was visited before 
                if(rem.level != visited[rem.v]){
                    return false;   //they are not on same level
                }
            }
            visited[rem.v] = rem.level;
            for(Edge e : adjList[rem.v]){
                if(visited[e.vertex2] == -1){
                    queue.add(new Pair(e.vertex2, rem.psf+e.vertex2,rem.level+1));
                }
            }
        }
        return true;
    }
}
class Pair{
    int v;
    String psf;
    int level;

    public Pair(int v, String psf, int level){
        this.v = v;
        this.psf = psf;
        this.level = level;
    }
}
class Edge{
    int vertex1;
    int vertex2;

    public Edge(int vertex1, int vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
}
