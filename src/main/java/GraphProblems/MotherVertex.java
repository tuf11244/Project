/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;
/**
 *Date: 05/09/2024
 *https://www.geeksforgeeks.org/problems/mother-vertex/1
 * @author parth
 */
public class MotherVertex {

    /**
     * Find mother vertex is based on Kosaraju Algorithm
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of egdes ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the information ");
        String[] paths = new String[edges];
        for(int i = 0; i < edges;i++){
            paths[i] = scanner.nextLine();
        }
        
        buildGraph(vertices,edges,paths);
        
    }
    public static int count;
    public static void buildGraph(int vertices, int edges, String[] paths){
        List<M> [] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            
            graph[src].add(new M(src,nbg));
        }
        
        System.out.println(Arrays.toString(graph));
        
        
        boolean visited[] = new boolean[vertices];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < vertices;i++){
            if(visited[i] == false){
                dfs(i,visited,graph,st);
            }
        }
        
        //Reset the visited arr
        visited = new boolean[vertices];
        count = 0;
        int answer = st.pop();
        dfs(answer,visited,graph);
        if(count == vertices){
            System.out.println("The mother vertex is " + answer);
        }
        if(count != vertices){
            System.out.println("There is no mother vertex");
        }
       
    }
    
    public static void dfs(int src, boolean[] visited,List<M> [] graph,Stack<Integer> st){
        visited[src] = true;       
        for(M nbrs : graph[src]){
            if(visited[nbrs.nbg] == false){
                dfs(nbrs.nbg,visited,graph,st);
            }
        }
        
        st.add(src);
        
    }
     public static void dfs(int src, boolean[] visited,List<M> [] graph){
        visited[src] = true;  
        count++;
        for(M nbrs : graph[src]){
            if(visited[nbrs.nbg] == false){
                dfs(nbrs.nbg,visited,graph);
            }
        }
        
        
        
    }
}

class M{
    int src;
    int nbg;
    
    public M(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }

    @Override
    public String toString() {
        return "M{" + "src=" + src + ", nbg=" + nbg + '}';
    }
    
}
