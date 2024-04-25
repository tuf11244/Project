/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author parth
 */
public class HamiltonianPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of the edges ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        String[] parts = new String[edges];
        System.out.println("Please enter the information ");
        for(int i = 0; i < parts.length;i++){
            parts[i] = scanner.nextLine();
        }
        
        //BuildtheGraph or the adjacencyList
        function2(vertices,edges,parts);
    }
    
    public static void function2(int vertices, int edges, String[] parts){
        List<Paths> graph[] = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges;i++){
            String[] part = parts[i].split(" ");
            int vertex1 = Integer.parseInt(part[0]);
            int vertex2 = Integer.parseInt(part[1]);
            
            graph[vertex1].add(new Paths(vertex1,vertex2));
            graph[vertex2].add(new Paths(vertex2,vertex1));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the source ");
        int source = scanner.nextInt();
       
        HashSet<Integer> visited = new HashSet<>();
        dfsHelper(visited,graph,source,source+"",source);
        
       // System.out.println(answer);
    }
    
    public static void dfsHelper(HashSet<Integer> visited,List<Paths> graph[],int source,String psf, int originalSrc){
        if(visited.size() == graph.length-1){
            System.out.println(psf);
            
            boolean closingEdge = false;
            for(Paths p : graph[source]){
                if(p.vertex2 == originalSrc){
                    closingEdge = true;
                    break;
                }
            }
            
            if(closingEdge){
                System.out.println("Yes the path is cycle " + psf + "*");
            }else{
                System.out.println("Nope not a cycle " + psf + ".");
            }
            return;
        }
        visited.add(source);
        
        for(Paths p : graph[source]){
            if(visited.contains(p.vertex2) == false){
                dfsHelper(visited,graph,p.vertex2,psf+p.vertex2,originalSrc);
            }
        }
        visited.remove(source);
    }
}

class Paths{
    int vertex1;
    int vertex2;
    
    public Paths(int vertex1, int vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
}
