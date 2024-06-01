/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/31/2024
 * https://leetcode.com/problems/tree-diameter/
 * @author parth
 */
public class TreeDiameter {

    /**
     * @param args the command line arguments
     */
    public static int diameter;
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] edges = {
            {0,1},
            {1,2},
            {2,3},
            {1,4},
            {4,5}
        };
        
        System.out.println(treeDiameter(edges));
    }
    
    public static int treeDiameter(int[][] edges){
        //Build the graph 
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int nbg = edge[1];
            
            adj.get(src).add(nbg);
            adj.get(nbg).add(src);
        }
        
        diameter = 0; //intialize the diameter 
        
        boolean[] visited = new boolean[n];
        
        int src = 0;
        dfs(adj,visited,src);
        
        return diameter;
        
           
    }
    
    public static int dfs(List<List<Integer>> adj, boolean[] visited, int src){
         int firstChild = 0;
         int secondChild = 0;
         
        visited[src] = true;
        
        for(int nbg : adj.get(src)){
            
            if(visited[nbg] == true){
                continue;
            }
            
            int getDiameter = dfs(adj,visited,nbg);
            
            if(getDiameter > firstChild){
                //update both the firstChild and second child
                secondChild = firstChild; //update the second child first
                firstChild = getDiameter;
                
            }else if(getDiameter > secondChild){
                //update the second child 
                secondChild = getDiameter;
                
            }
        }
        
        if(firstChild + secondChild + 1 > diameter){
            diameter = firstChild + secondChild;
        }
        
        return firstChild + 1;
    }
}
