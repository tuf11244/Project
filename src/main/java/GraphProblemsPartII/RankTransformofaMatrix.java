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

    public static int row[]; 
    //This holds the maximum rank assigned so far to any element in row i.
    public static int col[];  
    //This holds the maximum rank assigned so far to any element in column j.
    
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
        
           
        pair [] arr = new pair[m*n]; //we will be using this array for traversing purposes 
        //arr is 1-D array of which the values are derived from the matrix given 
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
               int index = i * n + j;
               arr[index] = new pair(matrix[i][j],i,j);
                
            }
        }
        
        //Sort our arr filled up on the values
        Arrays.sort(arr);
        
       System.out.println(Arrays.toString(arr));
       
       int lastval = Integer.MIN_VALUE;
       List<pair> list = new ArrayList<>();
       for(int i = 0; i < arr.length;i++){
           int val = arr[i].val;
            
           if(val!=lastval){
               helper(list,matrix);
               lastval = val;
            // By resetting list to a new ArrayList<>, the algorithm ensures that the helper function 
            // is called for each group of elements with the same value before moving on to the next group. 
            //This makes the processing of elements efficient and organized, 
            //allowing the algorithm to handle elements of the same value together 
            //and then clear the list for the next set of values.
               list = new ArrayList<>();
           }
           list.add(arr[i]);
       }
       
       helper(list,matrix);
       
       
         for(int[] mat : matrix){
             System.out.println(Arrays.toString(mat));
         }
    }
     
     public static void helper(List<pair> list, int[][] matrix){
         int m = matrix.length;
         int n = matrix[0].length;
         
         int [] parent = new int[m+n];
         Arrays.fill(parent, -1);
         for(pair p : list){
             int i = p.x;
             int j = p.y;
             
             int parent1 = findParent(i,parent);
             int parent2 = findParent(j+m,parent);
             
             if(parent1!=parent2){
                 
                 int maxRank = Math.min(parent[parent1], Math.min(parent[parent2], -1 *Math.max(row[i], col[j])-1));
                /* Math.max(row[i], col[j]): This finds the larger of the two maximum ranks for the row and column, 
                    ensuring the new rank respects the previous ranks. 
                 
                - 1 * Math.max(row[i], col[j]) - 1: This converts the maximum rank to a negative value and decreases it by 1. 
                    The negative sign and the decrement are because the union-find parent array stores ranks as negative values 
                    to distinguish them from indices.
                 
                 Math.min(parent[parent1], -1 * Math.max(row[i], col[j]) - 1): This finds the smaller value between the current parent value 
                 (representing the rank) of the row and the negative maximum rank needed for the current element. 
                 The use of Math.min ensures that the rank does not exceed what is currently permissible based on the union-find structure.
                 
                 
                 Math.min(parent[parent1], parent[parent2]): This ensures that the minimum rank between the two parent 
                 components (row and column) is chosen. This step respects the union-find's requirement 
                 that ranks within the same connected component remain consistent.
                 
                 */
                
                
                 parent[parent1] = maxRank;
                 parent[parent2] = parent1;
                 
                 /*parent[parent1] = maxRank;: This line sets the rank for the root of the row component. 
                The maxRank is the calculated rank that respects the ranks of all previous elements in the same row and column.

                parent[parent2] = parent1;: This line makes the root of the column component (parent2) point to the 
                root of the row component (parent).This effectively merges the two components.
                
                */
             }
         }
         
         //updating the matrix 
         for(pair p : list){
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

class pair implements Comparable<pair>{
    int val;
    int x;
    int y;
    
    public pair(int val, int x, int y){
        this.val = val;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(pair o) {
      return this.val - o.val;
    }

    @Override
    public String toString() {
        return "Pair{" + "val=" + val + ", x=" + x + ", y=" + y + '}';
    }
    
}
