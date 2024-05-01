/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 04/30/2024
 * https://leetcode.com/problems/01-matrix/
 * @author parth
 */
public class ZeroOneMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        
        int[][] answer = zeroOne(grid);
        for(int[] ans : answer){
            System.out.println(Arrays.toString(ans));
        }
    }
    public static int[][] directions = {
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };
    
    public static boolean isValid(int[][] grid, int row, int column){
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
    
    public static int[][] zeroOne(int[][] grid){
        Queue<ypair> queue = new LinkedList<>();
        
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    queue.add(new ypair(i,j));
                }else{
                    grid[i][j] = -1; //this act sort of like visited array 
                }
            }
        }
        
        while(!queue.isEmpty()){
            ypair rem = queue.poll();
            
            for(int i = 0; i < 4;i++){
                int rowdash = rem.x + directions[i][0];
                int coldash = rem.y + directions[i][1];
                
                if(isValid(grid,rowdash,coldash) && grid[rowdash][coldash] == -1){
                    queue.add(new ypair(rowdash,coldash));
                    grid[rowdash][coldash] = grid[rem.x][rem.y] + 1;
                }
               
            }
        }
        return grid;
        
    }
}

class ypair{
    int x;
    int y;
    
    public ypair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
