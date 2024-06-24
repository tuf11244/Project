/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/23/2024
 *https://leetcode.com/problems/making-a-large-island/
 * @author parth
 */
public class MakingaLargeIsland {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] size;
    public static int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int largestIsland(int[][] grid) {
        parent = new int[grid.length * grid[0].length];
        size = new int[grid.length * grid[0].length];

        for(int i = 0; i < grid.length * grid[0].length;i++){
            parent[i] = i;
            size[i] = 1;
        }
        //Step 1 : Union adjacent land cells
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                 if(grid[i][j] == 1){
                    int cellno = i * grid[0].length + j;
                    
                    for(int k = 0; k < 4 ; k++){
                        int rowdash = i + directions[k][0];
                        int coldash = j + directions[k][1];

                        int celldash = rowdash * grid[0].length + coldash;

                        if(isValid(grid,rowdash,coldash) && grid[rowdash][coldash] == 1){
                             union(cellno,celldash);
                        }
                    }
                 }
            }
        }

        //Find the maximum island size without any changes
        int maxArea = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    int cellno = i * grid[0].length + j;
                    int root = find(cellno);
                    maxArea = Math.max(maxArea,size[root]);
                }
            }
        }

        // Step 2: Check every 0 to find the largest possible island
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> visited = new HashSet<>();
                    int possibleArea = 1;
                    for(int k = 0; k < 4;k++){
                        int rowdash = i + directions[k][0];
                        int coldash = j + directions[k][1];

                        if(isValid(grid,rowdash,coldash) && grid[rowdash][coldash] ==1){
                            int celldash = rowdash * grid[0].length + coldash;
                            int root = find(celldash);
                            if(visited.contains(root) == false){
                                possibleArea = possibleArea + size[root];
                                visited.add(root);
                            }
                        }
                    }

                    maxArea = Math.max(maxArea,possibleArea);
                }
            }
        }
        return maxArea;
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);

        if(lx != ly){
            if(size[lx] > size[ly]){
                parent[ly] = lx;
                size[lx] = size[lx] + size[ly];
            }else{
                parent[lx] = ly;
                size[ly] = size[ly] + size[lx];
            }
        }
    }

    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
