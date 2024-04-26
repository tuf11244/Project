/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Date: 04/25/2024
 * is Graph cyclic;
 * meaning any vertex already visited before than return true
 * @author parth
 */
public class isGraphCyclicBFS{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the vertices ");
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
        
        buildTHEgraph(vertices,edges,paths);
    }
    
    public static void buildTHEgraph(int vertices, int edges, String[] paths){
        List<graph> [] graphs = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int i =0; i< edges;i++){
            String[] path = paths[i].split(" ");
            int vertex1 = Integer.parseInt(path[0]);
            int vertex2 = Integer.parseInt(path[1]);
            
            graphs[vertex1].add(new graph(vertex1, vertex2));
            graphs[vertex2].add(new graph(vertex2, vertex1));
        }
        boolean visited[] = new boolean[vertices];
        
        
        for(int v = 0; v < vertices;v++){
            if(visited[v] == false){
                boolean cycle = isCyclic(graphs,v,visited);
                if(cycle){
                    System.out.println("Cycle found ");
                    return;
                }
            }
        }
        System.out.println("Cycle not found ");
    }
    
    public static boolean isCyclic(List<graph> [] graphs, int src, boolean[] visited){
        Queue<qPair> queue = new LinkedList<>();
        queue.add(new qPair(src, src+""));
        
        while(!queue.isEmpty()){
                qPair rem = queue.poll();
               
                if(visited[rem.v] == true){
                    //Meaning the vertex has already been visited 
                    //this is the second time visiting 
                    //hence there is a cycle 
                    return true;
                }
                visited[rem.v] = true;
                //Now visit the neighbours 
                for(graph g : graphs[rem.v]){
                    if(visited[g.vertex2] == false){
                        queue.add(new qPair(g.vertex2 , rem.psf+g.vertex2));
                    }
                }
        }
        return false;
    }
}
class qPair{
    int v;
    String psf;
    
    public qPair(int v, String psf){
        this.v = v;
        this.psf = psf;
    }
}

class graph{
    int vertex1;
    int vertex2;
    
    public graph(int vertex1, int vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
}
