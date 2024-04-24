/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *Date: 04/23/2024
 * @author parth
 */
public class PrintAllthePaths {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the number of edges ");
        Scanner scanner = new Scanner(System.in);
        int edges = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the path information ");
        String[] paths = new String[edges];
        for(int i = 0; i < edges; i++){
            paths[i] = scanner.nextLine();
        }
        
        buildGraph(edges,vertices,paths);
    }
    
    public static void buildGraph(int edges, int vertices, String[] paths){
        List<Values>[] graph = new ArrayList[vertices];
        
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] part = paths[i].split(" ");
            int vertex1 = Integer.parseInt(part[0]);
            int vertex2 = Integer.parseInt(part[1]);
            int weight = Integer.parseInt(part[2]);
            
            graph[vertex1].add(new Values(vertex1,vertex2,weight));
            graph[vertex2].add(new Values(vertex2, vertex1, weight));
        }
        
        List<String> answer = new ArrayList<>(); //This will contains our answer
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the source ");
        int src = scanner.nextInt();
        System.out.println("Please enter the destination  ");
        int dest = scanner.nextInt();
        
        //call our function 
        boolean visited[] = new boolean[vertices];
        printPaths(answer,src+"",graph,src,dest,visited);
        
        Collections.sort(answer);
        System.out.println(answer);
        
    }
    
    public static void printPaths(List<String> answer,String psf, List<Values>[] graph,int src, int dest, boolean[] visited){
        if(src == dest){
            answer.add(psf);
            return;
        }
        visited[src] = true;
        for(Values value : graph[src]){
            if(visited[value.vertex2] == false){
                printPaths(answer,psf+value.vertex2,graph,value.vertex2,dest,visited);
               
            }
        }
        
        //Backtrack
        visited[src] = false;
        
    }
}
class Values{
    int vertex1;
    int vertex2;
    int weight;
    
    public Values(int vertex1, int vertex2, int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Values{" + "vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + '}';
    }
    
}
