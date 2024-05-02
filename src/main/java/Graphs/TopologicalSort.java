/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 *Date: 04/27/2024
 * @author parth
 */
public class TopologicalSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the information ");
        String[] paths = new String[edges];
        for(int i = 0; i < edges;i++){
            paths[i] = scanner.nextLine();
        }
        
        graph(edges,vertices,paths); //build the adjacency list
    }
    
    public static void graph(int edges, int vertices, String[] paths){
        List<Line> graph[] = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            
            graph[src].add(new Line(src,nbg));
          //  graph[nbg].add(new Line(nbg,src)); //this line is only added when its an undirected graph 
        }
        
        boolean visited[] = new boolean[vertices];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < vertices;i++){
            if(visited[i] == false){
                topologicalSort(visited,graph,st,i);
            }
        }
        
        while(!st.empty()){
            System.out.print(st.pop() + " ");
        }
    }
    public static void topologicalSort(boolean visited[] , List<Line> [] graph, Stack<Integer> st, int src){
        visited[src] = true; //mark it as visited 
        for(Line l : graph[src]){
            if(visited[l.nbg] == false){
                topologicalSort(visited,graph,st,l.nbg);
            }
        }
        st.push(src);  //this is the post order ..so add it in our stack 
    }
}
class Line{
    int src;
    int nbg;
    
    public Line(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
