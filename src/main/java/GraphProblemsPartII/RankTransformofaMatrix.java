/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/16/2024
 * https://leetcode.com/problems/rank-transform-of-a-matrix/
 * @author parth
 */
public class RankTransformofaMatrix {

    /**
     * @param args the command line arguments
     */

    public static int row[];  //stores maximum so far in row[i];
    public static int col[];  //store maximum so far is col[i];
    
    public static void main(String args[]) {
        int[][] matrix = {
            {20,-21,14},
            {-19,4,19},
            {22,-47,24},
            {-19,4,19}
        };
        
        matrixRankTransform(matrix);
     }
    
     public static void matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        row = new int[m];
        col = new int[n];
        
           
        Pair [] arr = new Pair[m*n]; //we will be using this array for traversing purposes 
        //arr is 1-D array of which the values are derived from the matrix given 
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
               int index = i * n + j;
               arr[index] = new Pair(matrix[i][j],i,j);
                
            }
        }
        
        //Sort our arr filled up on the values
        Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
       
       int lastval = Integer.MIN_VALUE;
       List<Pair> list = new ArrayList<>();
       for(int i = 0; i < arr.length;i++){
           int val = arr[i].val;
            
           if(val!=lastval){
               helper(list,matrix);
               lastval = val;
               list = new ArrayList<>();
           }
           list.add(arr[i]);
       }
       
       helper(list,matrix);
       
       
         for(int[] mat : matrix){
             System.out.println(Arrays.toString(mat));
         }
    }
     
     public static void helper(List<Pair> list, int[][] matrix){
         int m = matrix.length;
         int n = matrix[0].length;
         
         int [] parent = new int[m+n];
         Arrays.fill(parent, -1);
         for(Pair p : list){
             int i = p.x;
             int j = p.y;
             
             int parent1 = findParent(i,parent);
             int parent2 = findParent(j+m,parent);
             
             if(parent1!=parent2){
                 
                 int maxRank = Math.min(parent[parent1], Math.min(parent[parent2], -1 *Math.max(row[i], col[j])-1));
                 parent[parent1] = maxRank;
                 parent[parent2] = parent1;
             }
         }
         
         //updating the matrix 
         for(Pair p : list){
             int i = p.x;
             int j = p.y;
             
             int father = findParent(i,parent);
             
             int rank = -1* parent[father];
             
             matrix[i][j] = rank;
             row[i] = rank;
             col[j] = rank;
             
         }
     }
     public static int findParent(int u, int[] parent){
         if(parent[u] < 0){
             return u;
         }
         int temp = findParent(parent[u],parent);
         parent[u] = temp;
         
         return temp;
     }
    
}

class Pair implements Comparable<Pair>{
    int val;
    int x;
    int y;
    
    public Pair(int val, int x, int y){
        this.val = val;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
      return this.val - o.val;
    }

    @Override
    public String toString() {
        return "Pair{" + "val=" + val + ", x=" + x + ", y=" + y + '}';
    }
    
}
