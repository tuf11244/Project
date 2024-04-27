/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *
 * @author parth
 */
public class PrimsAlgorithm {

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
        
        buildAdj(vertices, edges, paths);
    }
    
    public static void buildAdj(int vertices, int edges, String[] paths){
        List<links> graph[] = new ArrayList[vertices];
        
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            int weight = Integer.parseInt(path[2]);
            
            graph[src].add(new links(src, nbg,weight));
            graph[nbg].add(new links(nbg,src,weight));
        }
        
        boolean[] visited = new boolean[vertices];
        PriorityQueue<pqpair> pq = new PriorityQueue<>();
        
        pq.add(new pqpair(0,-1,0));
        
        while(!pq.isEmpty()){
            pqpair rem = pq.poll();
            
            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            if(rem.av!=-1){
                System.out.println("The vertex is " + rem.v + " acquired from " + rem.av + " with weight " + rem.weight);
            }
            
            for(links l : graph[rem.v]){
                if(visited[l.nbg] == false){
                    pq.add(new pqpair(l.nbg,rem.v,l.weight));
                }
            }
        }
    }
}
class pqpair implements Comparable<pqpair>{
    int v;
    int av; //acquiring vertex 
    int weight;
    
    public pqpair(int v, int av, int weight){
        this.v = v;
        this.av = av;
        this.weight = weight;
    }

    @Override
    public int compareTo(pqpair o) {
       return this.weight - o.weight;
    }
    
}

class links{
    int src;
    int nbg;
    int weight;
    
    public links(int src, int nbg, int weight){
        this.src = src;
        this.nbg = nbg;
        this.weight = weight;
    }
            
}
