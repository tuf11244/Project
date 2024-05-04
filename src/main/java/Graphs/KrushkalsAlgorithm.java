/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;

import java.util.Arrays;
import java.util.Scanner;

/**
 *Date: 05/04/2024
 * https://www.geeksforgeeks.org/minimum-cost-to-provide-water/
 * @author parth
 */
public class KrushkalsAlgorithm {
  public static int[] parent;
  public static int[] rank;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        String[] paths = new String[edges];
        for(int i = 0; i < edges; i++){
            paths[i] = scanner.nextLine();
        }
        
        int[][] graph = new int[edges][3];
        
        for(int i = 0; i < edges; i++){
            String[] path = paths[i].split(" ");
            graph[i][0] = Integer.parseInt(path[0]);
            graph[i][1] = Integer.parseInt(path[1]);
            graph[i][2] = Integer.parseInt(path[2]);
        }
    }
    public static int minCostToSupplyWater(int vertices, int[][] graph){
        kPair[] arr = new kPair[graph.length];
        
        for(int i = 0; i < arr.length;i++){
            arr[i] = new kPair(graph[i][0],graph[i][1],graph[i][2]);
        }
        
        Arrays.sort(arr);
        
        parent = new int[vertices];
        rank = new int[vertices];
        
        for(int i = 0; i < vertices;i++){
            parent[i] = 1;
            rank[i] = 1;
        }
        int answer = 0;
        for(int i = 0; i < arr.length;i++){
            boolean flag = union(arr[i].src, arr[i].nbg);
            if(flag){
                answer = answer + arr[i].wt;
            }
        }
      return answer;
    }
    public static boolean union(int x, int y){
        int lx = parent[x];
        int ly = parent[y];
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[ly] = lx;
                rank[lx]++;
            }
            return true;
        }
      return false;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}

class kPair implements Comparable<kPair>{
    int src;
    int nbg;
    int wt;
    
    public kPair(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }

    @Override
    public int compareTo(kPair o) {
        return this.wt - o.wt;
    }
}

