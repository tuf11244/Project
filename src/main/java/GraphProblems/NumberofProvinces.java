/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *Date: 04/24/2024
 * https://leetcode.com/problems/number-of-provinces/
 * @author parth
 */
public class NumberofProvinces {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int findCircleNum(int[][] isConnected) {
       int V = isConnected.length;
       //Convert the matrix to the adjaceny List 
       List<List<Integer>> adjList = new ArrayList<>();
       for(int i = 0; i < V;i++){
            adjList.add(new ArrayList<>());
       }

       for(int i = 0; i < isConnected.length;i++){
        for(int j = 0; j < isConnected[0].length;j++){
            if(isConnected[i][j] == 1 && i != j){
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }
        }
       }

       boolean visited[] = new boolean[V];
       int count = 0;

       for(int i = 0; i < V;i++){
        if(visited[i] == false){
            dfs(i,adjList,visited);
            count++;
        }
       }
    return count;

    }

    public void dfs(int node, List<List<Integer>> adjList, boolean[] visited){
        visited[node] = true;
        for(Integer x : adjList.get(node)){
            if(visited[x] == false){
                dfs(x,adjList,visited);
            }
        }
    }
}

//Using DSU
class Solution {
    public static int[] parent;
    public static int[] rank;
    public int findCircleNum(int[][] isConnected) {
    //Intialize the parent and rank arrays
    parent = new int[isConnected.length];
    rank = new int[isConnected.length];

    for(int i = 0; i < isConnected.length;i++){
        parent[i] = i;
        rank[i] = 1;
    }

    for(int i = 0; i < isConnected.length;i++){
        for(int j = 0; j < isConnected.length;j++){
            if(isConnected[i][j] == 1){
                merge(i,j);
            }
        }
    }

   HashSet<Integer> set = new HashSet<>();
   for(int i = 0; i < parent.length;i++){
        int p = find(i);
        set.add(p);
   }
   return set.size();

}
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    public static void merge(int x, int y){
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
        }
    }
}
