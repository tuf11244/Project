/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *Date: 05/02/2024
 * @author parth
 */
public class ZeroOneBFS {

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
        String[] paths = new String[edges];
        System.out.println("Please enter the information ");
        for(int i = 0; i < edges;i++){
            paths[i] = scanner.nextLine();
        }
        
        buildGraph(vertices, edges,paths);
        
    }
    public static void buildGraph(int vertices, int edges, String[] paths){
        List<EdgeInfo>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            String[] path = paths[i].split(" ");
            int vtx1 = Integer.parseInt(path[0]);
            int vtx2 = Integer.parseInt(path[1]);

            graph[vtx1].add(new EdgeInfo(vtx2, 0));
            graph[vtx2].add(new EdgeInfo(vtx1, 1));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the source vertex: ");
        int source = scanner.nextInt();
        System.out.println("Please enter the destination vertex: ");
        int destination = scanner.nextInt();

        Deque<EdgeInfo> deque = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        deque.addFirst(new EdgeInfo(source, 0));

        while (!deque.isEmpty()) {
            EdgeInfo rem = deque.removeFirst();

            if (rem.vertex == destination) {
                System.out.println("The path from " + source + " to " + destination + " comes with a cost of " + rem.weight);
                return;
            }

            if (visited[rem.vertex]) { // already visited
                continue;
            }

            visited[rem.vertex] = true;

            for (EdgeInfo e : graph[rem.vertex]) {  // process the unvisited neighbors
                if (!visited[e.vertex]) {
                    if (e.weight == 0) {
                        deque.addFirst(new EdgeInfo(e.vertex, rem.weight + 0));
                    } else {
                        deque.addLast(new EdgeInfo(e.vertex, rem.weight + 1));
                    }
                }
            }
        }

       
        System.out.println("The path is not possible "); 
        
    }
}

class EdgeInfo{
    int vertex;
    int weight;
    
    public EdgeInfo(int vertex, int weight){
        this.vertex =  vertex;
        this.weight = weight;
    }
}
