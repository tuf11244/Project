/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *Date: 04/23/2024
 * @author parth
 */
public class AdjacencyList {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Please enter the edges information");
        String[] parts = new String[edges];
        for(int i = 0; i < edges;i++){
            parts[i] = scanner.nextLine();
         //   System.out.println(parts[i]);
        }
       // System.out.println(Arrays.toString(parts));
        adjacencyList(edges,vertices,parts);
    }
    public static void adjacencyList(int edges, int vertices, String[] parts){
        
        //graph is represented as adjacency List 
        //i.e. an array containing arrays list
        List<Edge> [] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] part = parts[i].split(" ");
            int vertex1 = Integer.parseInt(part[0]); //get the source 
            int vertex2 = Integer.parseInt(part[1]); //get the destination 
            int weight = Integer.parseInt(part[2]); //get the weight;
            
            graph[vertex1].add(new Edge(vertex1,vertex2,weight));
            graph[vertex2].add(new Edge(vertex2,vertex1,weight));
        }
        System.out.println(Arrays.toString(graph));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the source ");
        int source = scanner.nextInt();
        System.out.println("Please enter the destination ");
        int destination = scanner.nextInt();
        
        boolean[] visited = new boolean[vertices];
        boolean answer = hasPath(graph,source,destination,visited);
        
        System.out.println(answer);
    }
    
    public static boolean hasPath(List<Edge>[] graph, int source, int destination, boolean[] visited){
        if(source == destination){
            return true;
        }
        visited[source] = true;
        
        for(Edge edge : graph[source]){
            if(visited[edge.vertex2] == false){
                boolean hasNBRPath = hasPath(graph,edge.vertex2,destination,visited);
                if(hasNBRPath){
                    return true;
                }
            }
        }
        return false;
    }
}

class Edge{
    int vertex1;
    int vertex2;
    int weight;
    
    public Edge(int src,int dest, int weight){
        this.vertex1 = src;
        this.vertex2 = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" + "vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + '}';
    }
    
}
