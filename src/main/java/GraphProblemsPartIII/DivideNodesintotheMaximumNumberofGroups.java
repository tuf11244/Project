/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 01/29/2025
 * https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/
 * @author parth
 */
public class DivideNodesintotheMaximumNumberofGroups {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int magnificentSets(int n, int[][] edges){
        
        List<Nodes> [] graph = new ArrayList[n+1];
        
        //Build the graph
        for(int i = 1; i <= n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int [] edge : edges){
            int src = edge[0];
            int nbg = edge[1];
            
            graph[src].add(new Nodes(src,nbg));
            graph[nbg].add(new Nodes(nbg,src));
        }
        
        //Step 1 : Check if the graph is bipartite 
        int[] visited = new int[n+1];
        Arrays.fill(visited,-1);
        
        for(int i =1; i <= n;i++){
            if(visited[i] == -1){
            boolean bipartite = isBipartite(i,visited,graph);
            
            if(bipartite == false){
                return -1;
            }
            }
        }
        
        // Step 2: Find all connected components and compute the max depth for each
        boolean[] visitedNodes = new boolean[n+1];
        int maxNode = 0;
        for(int i = 1; i <= n;i++){
            if(visitedNodes[i] == false){
                List<Integer> components = new ArrayList<>();
                
                collectComponents(components,i,visitedNodes,graph);
                
                int maxDepth = 0;
                
                for(int node : components){
                    maxDepth = Math.max(maxDepth, BFS(node,graph));
                }
                maxNode = maxNode + maxDepth;
            }
        }
        
        return maxNode;
        
    }
    public int BFS(int src, List<Nodes>[] graph){
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{src,1});
        
        boolean[] visited = new boolean[graph.length];
        
        int maxDepth = 0;
        
        while(!queue.isEmpty()){
            int[] rem = queue.poll();
            int v = rem[0];
            int depth = rem[1];
            if(visited[v] == true){
                continue;
            }
            
            maxDepth = Math.max(maxDepth,depth);
            visited[v] = true;
            
            for(Nodes n : graph[v]){
                if(visited[n.nbg] == false){
                    queue.add(new int[]{n.nbg,depth+1});
                }
            }
        }
        return maxDepth;
    }
    
    public void collectComponents(List<Integer> components,int src, boolean[] visitedNodes,List<Nodes> [] graph){
        
        if(visitedNodes[src] == true){
            return;
        }
        
        visitedNodes[src] = true;
        components.add(src);
        
        for(Nodes n : graph[src]){
            if(visitedNodes[n.nbg] == false){
                collectComponents(components,n.nbg,visitedNodes,graph);
            }
        }
    }
    
    public boolean isBipartite(int src,int[] visited, List<Nodes>[] graph){
         Queue<bNode> queue = new LinkedList<>();
         queue.add(new bNode(src,0));
         
         while(!queue.isEmpty()){
             bNode rem = queue.poll();
             
             if(visited[rem.v] != -1){ //Means the node is already visited 
                   if(visited[rem.v] != rem.level){
                        return false;
                   }
             }
             
             visited[rem.v] = rem.level;
             
             for(Nodes n : graph[rem.v]){
                 if(visited[n.nbg] == - 1){
                       queue.add(new bNode(n.nbg,rem.level+1));
                 }
             }
         }
        
        return true;
    }
}

class bNode{
    int v;
    int level;
    
    public bNode(int v, int level){
        this.v = v;
        this.level = level;
    }
}

class Nodes{
    int src;
    int nbg;
    
    public Nodes(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
