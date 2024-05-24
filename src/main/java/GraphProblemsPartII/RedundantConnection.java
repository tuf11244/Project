/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 * Date: 05/23/2024
 *https://leetcode.com/problems/redundant-connection/
 * @author parth
 */
public class RedundantConnection {
    public static int[] parent;
    public static int[] rank;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] edges = {
            {1,2},
            {2,3},
            {3,4},
            {1,4},
            {1,5}
        };
        
        int[] arr = findRedundantConnection(edges);
        
        System.out.println(Arrays.toString(arr));
    }
     public static int[] findRedundantConnection(int[][] edges) {
        //Intialize the parent and rank arrays 
       parent = new int[edges.length + 1]; //because the nodes are given from 1 to n 
       rank = new int[edges.length + 1];
       
       for(int i = 0; i < parent.length;i++){
           parent[i] = i;
           rank[i] = 1;
       }
       
      List<List<Integer>> list  = new ArrayList<>();  // We are converting are edges to list because the nodes start from 1 to n
      List<Integer> temp = new ArrayList<>();  //also the below step is not necessary we can directly manipulate it form the edges given 
      
      temp.add(0);
      temp.add(0);  //adding a dummy node since the nodes start from 1 to n
      
      list.add(temp);
      
      for(int [] edge : edges){
          List<Integer> l = new ArrayList<>();
          l.add(edge[0]);
          l.add(edge[1]);
          list.add(l);
      }
      
     for(List<Integer> l  : list){
         if(l.get(0) == l.get(1)){
             continue;  //continuing this case because 0,0 is our dummy node
         }
         
         int lx = find(l.get(0)); //finding the parent 
         int ly = find(l.get(1)); //finding the parent
         
         if(lx!=ly){   //if they are not equal than merge them 
             union(lx,ly);
         }else{
              return new int[]{l.get(0),l.get(1)}; //that means both the parent were equal hence a cycle was deteted
              //so its redundant
             
         }     
     }       
        return new int[] {-1,-1};   //nothing was found
    }
     
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    public static void union(int lx, int ly){
        if(rank[lx] > rank[ly]){
            parent[ly] = lx;
        }else if(rank[lx] < rank[ly]){
            parent[lx] = ly;
        }else{
            parent[lx] = ly;
            rank[ly]++;
        }
    }
}
