/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 04/30/2024
 * https://leetcode.com/problems/shortest-bridge/
 * @author parth
 */
public class ShortestBridge {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] grid = {
            {1,1,0,0,1},
            {1,1,0,0,1},
            {1,1,0,0,0}
    };
        int answer = ShortestBridge(grid);
        System.out.println(answer);
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
    
    public static int ShortestBridge(int[][] grid){
        Queue<zPair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        for(int i =0; i < grid.length && !flag;i++){
            for(int j = 0; j < grid[0].length && !flag;j++){
                if(grid[i][j] == 1){
                    //add all one 1's location (x coordinate and y coordinate in our first island in our queue)
                    //you can use bfs or dfs
                    dfs(grid,visited,queue,i, j);
                    flag = true;
                }
            }
        }
        System.out.println(queue);
        int level = 0;
        //now using our queue filled
        //we just have find shortest number of zeroes we need to flip to formm a bridge
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                zPair rem = queue.poll();
                
                for(int i = 0; i < 4;i++){
                    int rowdash = rem.x + directions[i][0];
                    int coldash = rem.y + directions[i][1];
                    
                    if(!isValid(grid,rowdash,coldash) || visited[rowdash][coldash] == true){
                        continue;
                    }
                    if(grid[rowdash][coldash] == 1){
                        //this above statement its the first one of the second island 
                        //so we just return our level 
                        //not that in this statemetn visited[rowdash][coldash] would be false other wise it would have been caught 
                        //in the previous condition
                        return level;
                    }
                    queue.add(new zPair(rowdash,coldash));
                    visited[rowdash][coldash] = true;  //mark it as visited
                }
                size--;
            }
            level++;
        }
        
        return 1;
    }
    
    public static void dfs(int[][] grid, boolean[][] visited, Queue<zPair> queue, int row, int column){
        
        visited[row][column] = true; //mark it as visited 
        queue.add(new zPair(row,column));
        
        for(int i = 0; i < 4;i++){
            int rowdash = row + directions[i][0];
            int coldash = column + directions[i][1];
            
            if(!isValid(grid,rowdash,coldash) || visited[rowdash][coldash] == true || grid[rowdash][coldash] == 0){
                continue;
            }
            dfs(grid,visited,queue,rowdash,coldash);
        }
    }
}



class zPair{
    int x;
    int y;
    
    public zPair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", y=" + y + '}';
    }
    
}
