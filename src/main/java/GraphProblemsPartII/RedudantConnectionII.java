/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;

import java.util.HashMap;
import java.util.*;

/**
 *Date: 05/23/2024
 * https://leetcode.com/problems/redundant-connection-ii/
 * 
 * There could be 3 cases 
 * Case 1: A node has 2 parents 
 * Case 2 : A cycle is formed 
 * Case 3 : A node has 2 parents + A cycle is formed basically a combination of Case 1 and Case 2 
 * @author parth
 */
public class RedudantConnectionII {
    public static int[] parent;
    public static int[] rank;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int[] findRedudantConnection(int[][] edges){
       parent = new int[edges.length + 1]; //because the nodes are given from 1 to n 
       rank = new int[edges.length + 1];
       
       for(int i = 0; i < parent.length;i++){
           parent[i] = i;
           rank[i] = 1;
       }
       
       
       int[] indegree = new int[edges.length + 1];
       //At max 1 node can have 2 indegrees 
       //There are 2 possibilities 
       //Possibility 1 : There are 0 nodes with indegree 2 i.e. there is a cycle Case 2 
       //Possibility 2 : There is 1 node with indegree 2 i.e. a node has 2 parents Case 1 
       //Please note THAT THERE CAN BE AT MAX 1 node which can have 2 incoming degrees
       Arrays.fill(indegree, -1);
       
       int bl1 = -1;
       int bl2 = -1;
       for(int i = 0; i < edges.length;i++){
           int u = edges[i][0];
           int v = edges[i][1];
           
           if(indegree[v] == -1){ //meaning no indegree for the node yet
               indegree[v] = i; //we put the edge number 
           }else{
               //in this case the since the indegree is not -1 we have a found a problem node
               //i.e. a node with 2 indegrees 
               bl1 = i; //current edge //we will assume bl1 is a our potential answer
               bl2 = indegree[v]; //first incoming edge 
           }
       }
       
       for(int i = 0; i < edges.length;i++){
           if(i == bl1){
               continue; //we don't process the edge 
           }
           
           int u = edges[i][0];
           int v = edges[i][1];
           
           boolean isCycle = union(u,v); 
           
           if(isCycle){ //means could be either case 2 or case 3
               if(bl1 == -1){
                   return edges[i]; //means because of this edge there was a cycle 
                   // This is case 2 ...only a cycle is present 
               }else{
                   return edges[bl2]; // case 3 
                   //A node with 2 parents was present + cycle was present
               }
           }
       }
       
     return edges[bl1]; //Case 1 ; i.e. a node with 2 parents 
  
    }
     public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
     public static boolean union(int x, int y){
       int lx = find(x);
       int ly = find(y);
       
       if(lx != ly){
           if(rank[lx] > rank[ly]){
               parent[ly] = lx;
           }else if(rank[lx] < rank[ly]){
               parent[lx] = ly;
           }else{
               parent[lx] = ly;
               rank[ly]++;
           }
           return false;
       }
        return true; //meaning a cycle was found 
    }
}
