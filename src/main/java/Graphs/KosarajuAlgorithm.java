/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;
import java.util.Scanner;
import java.util.*;
/**
 * 
 *05/09/2024
 * @author parth
 */
public class KosarajuAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        System.out.println("Please enter the number of vertices ");
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of egdes ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        String[] paths = new String[edges];
        System.out.println("Please enter the information ");
        for(int i =0; i < edges;i++){
            paths[i] = scanner.nextLine();
        }
        
        buildGraph(vertices,edges,paths);
    }
    
    public static void buildGraph(int vertices, int edges, String[] paths){
       List<K>[] graph = new ArrayList[vertices];
       List<K>[] reverseGraph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
        graph[i] = new ArrayList<>();
        reverseGraph[i] = new ArrayList<>();
        }

        for (String path : paths) {
        String[] parts = path.split(" ");
        int src = Integer.parseInt(parts[0]);
        int dest = Integer.parseInt(parts[1]);
        graph[src].add(new K(src, dest));
        // Create reverse edges
        reverseGraph[dest].add(new K(dest, src));
        }
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[vertices];
        
        //Step 1: Random order dfs and fill up or stack 
        for(int i = 0; i < vertices;i++){
            if(visited[i] == false){
                dfs1(i,visited,st,graph);
            }
        }
        
         
         //Step 3 : Do a dfs from the stack that we filled in Step 1 
         int StrongConnectedComponents = 0;
         //Reset our visited array 
         visited = new boolean[vertices];
         while(!st.isEmpty()){
             int rem = st.pop();
             if(visited[rem] == false){
                 dfs2(rem,reverseGraph,visited);
                 StrongConnectedComponents++;
             }
         }
         
        
        System.out.println("The number of Strongly Connected Components are " + StrongConnectedComponents);
    }
    
    public static void dfs1(int src, boolean[] visited,Stack<Integer> st, List<K> [] graph){
        visited[src] = true;
        
        for(K nbrs : graph[src]){
            if(visited[nbrs.nbg] == false){
                dfs1(nbrs.nbg,visited,st,graph);
            }
        }
        
        //add it to our stack during backtracking 
        st.add(src);
    }
    
    public static void dfs2(int src, List<K> [] reverseGraph,boolean [] visited){
        visited[src] = true;
        
        for(K nbrs : reverseGraph[src]){
            if(visited[nbrs.nbg] == false){
                dfs2(nbrs.nbg,reverseGraph,visited);
            }
        }
    }
}

class K{
    int src;
    int nbg;
    
    public K(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
