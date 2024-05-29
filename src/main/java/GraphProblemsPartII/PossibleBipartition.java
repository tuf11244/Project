/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/28/2024
 *https://leetcode.com/problems/possible-bipartition/
 * @author parth
 */
public class PossibleBipartition {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] dislikes = {
            {1,2},
            {1,3},
            {2,4}
        };
        
        System.out.println(possibleBipartion(4,dislikes));
    }
    
    public static boolean possibleBipartion(int n,int[][] dislikes){
        List<B> graph[] = new ArrayList[n+1];
        
        for(int i =0; i <= n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] dislike : dislikes){
            int src = dislike[0];
            int nbg = dislike[1];
            
            graph[src].add(new B(src,nbg));
            graph[nbg].add(new B(nbg,src));
        }
        
        graph[0].add(new B(0,1)); //dummy edge
        
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        
        for(int i =0; i <= n;i++){
            if(visited[i] == -1){
                boolean isBipartite = checkBipartition(graph,visited,i);
                if(!isBipartite){
                    return false;
                }
            }
        }
       return true; 
    }
    
    public static boolean checkBipartition(List<B>[] graph,int[] visited,int src){
        Queue<Q> queue = new LinkedList<>();
        queue.add(new Q(src,0));
        
        while(!queue.isEmpty()){
             Q q = queue.poll();
             
             if(visited[q.v] !=-1){ //means it has been visited before
                 if(visited[q.v] != q.level){
                     return false;
                 }
             }
             visited[q.v] = q.level;
             
             for(B nbrs : graph[q.v]){
                 if(visited[nbrs.nbg] == -1){
                     queue.add(new Q(nbrs.nbg,q.level+1));
                 }
             }
        }
        return true;
    }
}
class Q{
    int v;
    int level;
    
    public Q(int v, int level){
        this.v = v;
        this.level = level;
    }
}

class B{
    int src;
    int nbg;
    
    public B(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
