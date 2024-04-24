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
public class GetConnectedComponents {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of vertices");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        String[] parts = new String[edges];
        System.out.println("Please enter the edges information ");
        for(int i = 0; i < edges; i++){
            parts[i] = scanner.nextLine();
        }
        
        //Function to build Adjacency Matrix for graphs 
        helper(edges,vertices,parts);
    }
    
    public static void helper(int edges, int vertices, String[] parts){
        List<Components> graphs[] = new ArrayList[vertices];
        
        for(int i = 0; i < vertices;i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] part = parts[i].split(" ");
            int vertex1 = Integer.parseInt(part[0]);
            int vertex2 = Integer.parseInt(part[1]);
            int weight = Integer.parseInt(part[2]);
            
            graphs[vertex1].add(new Components(vertex1, vertex2, weight));
            graphs[vertex2].add(new Components(vertex2, vertex1, weight));
            
        }
        
        System.out.println(Arrays.toString(graphs));
        
        List<List<Integer>> answer = new ArrayList<>();
        boolean visited[] = new boolean[vertices];
        for(int v = 0; v < vertices;v++){
            if(visited[v] == false){
                List<Integer> temp = new ArrayList<>();
                getConnectedComponents(graphs,temp,visited,v);
                answer.add(temp);
            }
        }
        
        
        //print the connected components 
        for(List<Integer> element : answer){
            System.out.println(element);
        }
        
         
    }
        
    
    public static void getConnectedComponents(List<Components> graphs[], List<Integer> temp, boolean visited[], int src){
        visited[src] = true;
        temp.add(src);
        for(Components comp : graphs[src]){
            if(visited[comp.vertex2] == false){
                getConnectedComponents(graphs,temp,visited,comp.vertex2);
            }
        }       
        
    }
    
}

class Components{
    int vertex1;
    int vertex2;
    int weight;
    
    public Components(int vertex1, int vertex2, int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        
    }

    @Override
    public String toString() {
        return "Components{" + "vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + '}';
    }
    
}
