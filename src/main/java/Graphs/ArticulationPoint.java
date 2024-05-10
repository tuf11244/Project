/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;
import java.util.*;
/**
 * Find the Articulation points in a graph using Tarjan's Algorithm 
 * 
 * Articulation points are vertices such that removing them disconnects the graph 
 * 
 *We need to DFS of this graph and keep visitedTime(i.e. what time was it discovered) and lowTime for each vertex 
 * lowTime keeps track of any back edges 
 * 
 * if any of the following condition meets, than the vertex is an articulation point 
 * Condition 1: If the vertex is root of DFS and has atleast 2 independent children (
 * By Independent it means they are not connected to each other except via the vertex.This condition is needed because 
 * if we started from a corner vertex, it will meet other condition but won't be an articulation point.
 * 
 * Condition 2 : If its not the root of DFS and if visitedTime of vertex <= lowTime of any adjacent vertex 
 *                                                                  than its an articulation point 
 * Time Complexity : O(E+V)
 * Space Complexity : O(V)
 *http://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 * @author parth
 */
public class ArticulationPoint {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] discovery;
    public static int[] low;
    public static boolean[] visited;
    public static boolean[] articulationPoint;
    public static int time;
    public static void main(String args[]) {
           System.out.println("Please enter the number of vertices ");
           Scanner scanner = new Scanner(System.in);
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
           
           buildGraph(vertices,edges,paths);
           
    }
    
    public static void buildGraph(int vertices, int edges, String[] paths){
        List<A> [] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            
            graph[src].add(new A(src,nbg));
            graph[nbg].add(new A(nbg,src));
        }
        
        parent = new int[vertices];
        
        discovery = new int[vertices];
        low = new int[vertices];
        visited = new boolean[vertices];
        time = 0;
        articulationPoint = new boolean[vertices];
        parent[0] = -1; //because 0 is our source
        dfs(0,graph); // 0 is source 
        int answer = 0; // the number of articulation points
        for(int i = 0; i < vertices;i++){
            if(articulationPoint[i] == true){
                answer++;
            }
        }
        
        System.out.println("The total articulation Points are " + answer);
    }
    public static void dfs(int src, List<A> [] graph){
        discovery[src] = time;
        low[src] = time;
        time++;
        int count = 0;
        visited[src] = true;
        
        List<A> nbrs = graph[src];
        
        for(int i = 0;i < nbrs.size();i++){
            int nbg = nbrs.get(i).nbg;
            
            //if the nbr vertex is same as the parent than ignore it 
            if(parent[src] ==  nbg){
                continue;
            }
            
            //if the nbr vertex is already visited than see if you can get a better low time
            else if(visited[nbg] == true){
                low[src] = Math.min(low[src],discovery[nbg]);
                
            //if the nbr vertex is not visited than visit it 
            }else{
                //set the parent 
                parent[nbg] = src;
                //increase the count of the children 
                count++;
                dfs(nbg,graph);
                low[src] = Math.min(low[src], low[nbg]);
                
                if(parent[src] == -1){
                    //the above the statement means if its an actual source 
                    //and it has 2 children which are independent meaning not connected any other except this src vertex
                    //i.e. Condition 1 as mentioned above 
                    if(count >= 2){
                        articulationPoint[src] = true;
                    }
                }
                else{
                    //i.e. Condition 2 as mentioned above 
                    if(low[nbg] >= discovery[src]){
                        articulationPoint[src] = true; //means the point src is articulation point
                    }
                }
            }
        }
    }
}

class A{
    int src;
    int nbg;
    
    public A(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}