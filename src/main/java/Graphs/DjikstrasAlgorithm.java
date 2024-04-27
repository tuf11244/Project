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
 *Date: 04/26/2024
 * Djisktras : Shortest paths between two given vertices;
 * @author parth
 */
public class DjikstrasAlgorithm {

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
          //  System.out.println(paths[i]);
        }
        
       buildAdjList(vertices, edges, paths); //build the graph function;
    }
    
    public static void buildAdjList(int vertices, int edges, String[] paths){
        List<edges> [] graphs = new ArrayList[vertices];
        
        for(int i = 0; i < vertices;i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            int weight = Integer.parseInt(path[2]);
            
            graphs[src].add(new edges(src,nbg,weight));
            graphs[nbg].add(new edges(nbg,src,weight));           
            
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the source ");
        int source = scanner.nextInt();
        System.out.println("Please enter the destination ");
        int destination = scanner.nextInt();
        
        boolean visited[] = new boolean[vertices];
        djisktraAlgo(visited,graphs,source, destination);
    }
    
    public static void djisktraAlgo(boolean[] visited, List<edges> [] graphs, int source, int destination){
        PriorityQueue<info> pq = new PriorityQueue<>();
        pq.add(new info(source,source+"",0));
        
        
        while(!pq.isEmpty()){
            info rem = pq.poll();
            
            if(rem.v == destination){
                System.out.println("The shorted path is " + rem.psf);
                System.out.println("The total weight is " + rem.wsf);
                break;
            } 
            if(visited[rem.v] == true){
                //this means the vertex has already been visited;
                continue;
            }
            visited[rem.v] = true;
            
            //now explore the edges 
            for(edges e : graphs[rem.v]){
                if(visited[e.nbg] == false){
                    pq.add(new info(e.nbg,rem.psf+e.nbg,rem.wsf+e.weight));
                }
            }
        }
        
    }
}
class info implements Comparable<info>{
    int v;
    String psf;
    int wsf;
    
    public info(int v, String psf, int wsf){
        this.v = v;
        this.psf = psf;
        this.wsf = wsf;
    }

    @Override
    public int compareTo(info o) {
        return this.wsf - o.wsf;
    }
    
            
}


class edges{
    int src;
    int nbg;
    int weight;
    
    public edges(int src, int nbg, int weight){
        this.src = src;
        this.nbg = nbg;
        this.weight = weight;
    }
}
