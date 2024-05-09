/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;
/**
 *
 * @author parth
 */
public class NegativeWeightCycleDetection {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
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
        
        if(buildGraph(vertices,edges,paths)){
            System.out.println("The graph has negative weight cycle ");
        }else{
            System.out.println("The graph is free of negative weight cycle");
        }
    }
    
    public static boolean buildGraph(int vertices, int edges, String[] paths){
        List<E> [] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            int wt = Integer.parseInt(path[2]);
            
            graph[src].add(new E(src,nbg,wt));
        }
        
        
        
        int[] ans = new int[vertices];
        
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0] = 0; //0 is our source 
        
        for(int i = 0; i < vertices - 1;i++){
            for(int j = 0; j < edges;j++){
                String[] path = paths[j].split(" ");
                int src = Integer.parseInt(path[0]);
                int nbg = Integer.parseInt(path[1]);
                int wt = Integer.parseInt(path[2]);
                
                if(ans[src] == Integer.MAX_VALUE){
                    continue;
                }
                if(ans[src] + wt < ans[nbg]){
                    ans[nbg] = ans[src] + wt;
                }
            }
        }
        
        for(int i = 0; i < 1;i++){
            for(int j = 0; j < edges;j++){
                String[] path = paths[j].split(" ");
                int src = Integer.parseInt(path[0]);
                int nbg = Integer.parseInt(path[1]);
                int wt = Integer.parseInt(path[2]);
                
                if(ans[src] == Integer.MAX_VALUE){
                    continue;
                }
                if(ans[src] + wt < ans[nbg]){
                   return true;
                }
            }
        }
        return false;
        
        
    }
}


class E{
    int src;
    int nbg;
    int wt;
    
    public E(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }

    @Override
    public String toString() {
        return "E{" + "src=" + src + ", nbg=" + nbg + ", wt=" + wt + '}';
    }
    
}

