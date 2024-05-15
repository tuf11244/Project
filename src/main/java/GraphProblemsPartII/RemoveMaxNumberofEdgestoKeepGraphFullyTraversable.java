/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/14/2024
 * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 * @author parth
 */
public class RemoveMaxNumberofEdgestoKeepGraphFullyTraversable {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public static int maxNumEdgesToRemove(int n, int[][] edges) {
        
         //sort the edges array based on the index of type 
         //we want the edges of type 3 to be on first priority as both alice and bob can travel
         Arrays.sort(edges,(a,b) -> Integer.compare(b[0], a[0]));
         
        int [] parenta = new int[n+1]; //parent array for alice 
        int [] parentb = new int[n+1]; //parent array for bob
        int [] ranka = new int[n+1]; //rank array for alice
        int [] rankb = new int[n+1]; //rank array for bob 
        
        //n+1 because 1 based indexing
        //Initialize all the above array
        for(int i = 0; i < parenta.length;i++){
            parenta[i] = i;
            parentb[i] = i;
            ranka[i] = 1;
            rankb[i] = 1;
        }
        
        int mergeda = 1; //megerd indices for alice
        int mergedb = 1; //merged indices for bob;
        int removeEdge = 0; //our final answer
        for(int[] edge : edges){
            if(edge[0] == 3){
                boolean tempa = union(edge[1],edge[2],parenta, ranka);
                boolean tempb = union(edge[1],edge[2],parentb, rankb);
                
                //meaning 2 vertices only for alice were merged
                if(tempa == true){
                    mergeda++;
                }
                //meaning 2 vertices only for bob were merged
                if(tempb == true){
                    mergedb++;
                }
                //nothing was merged for both alice and bob 
                //hence we don't need that edge
                if(tempa == false && tempb == false){
                    removeEdge++;
                }
                
            }else if(edge[0] == 1){
                 boolean tempa = union(edge[1],edge[2],parenta, ranka);
                 
                 if(tempa == true){
                     mergeda++;
                 }else{
                     removeEdge++;
                 }
                
            }else { //edge[0] == 2
                boolean tempb = union(edge[1],edge[2],parentb, rankb);
                 
                 if(tempb == true){
                     mergedb++;
                 }else{
                     removeEdge++;
                 }
            }
        }
        if(mergeda != n || mergedb != n){
            return -1;
        }
        return removeEdge;
    }
     
     public static int find(int x, int[] parent){
         if(parent[x] == x){
             return x;
         }
         int temp = find(parent[x],parent);
         parent[x] = temp;
         return temp;
     }
     
     public static boolean union(int x, int y , int[] parent, int[] rank){
         int lx = find(x,parent);
         int ly = find(y,parent);
         
         if(lx != ly){
             if(rank[lx] > rank[ly]){
                 parent[ly] = lx;
             }
             else if(rank[lx] < rank[ly]){
                 parent[lx] = ly;
             }else{
                 parent[lx] = ly;
                 rank[ly]++;
             } 
             return true; //means they were merged as lx and ly are not equal
         }
        return false; //means they were not merged 
     }
}
