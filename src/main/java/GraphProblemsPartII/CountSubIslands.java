/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 08/27/2024
 *https://leetcode.com/problems/count-sub-islands/
 * @author parth
 */
public class CountSubIslands {
    public boolean visited[][];
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        visited = new boolean[grid2.length][grid2[0].length];
        List<List<Coordinate>> cc = new ArrayList<>();

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    List<Coordinate> temp = new ArrayList<>();
                    dfs(grid2, i, j, temp);
                    cc.add(temp);
                }
            }
        }

        int subIslands = 0;
        for (List<Coordinate> c : cc) {
            boolean flag = true;
            for (Coordinate coord : c) {
                if (grid1[coord.x][coord.y] == 0) {
                    flag = false;
                    break;  // Early exit if the island is not a sub-island
                }
            }
            if (flag) {
                subIslands++;
            }
        }
        return subIslands;
    }
    
    public void dfs(int[][] grid2, int row, int col, List<Coordinate> temp) {
        if (!isValid(grid2, row, col) || grid2[row][col] == 0 || visited[row][col]) {
            return;
        }
        
        visited[row][col] = true;  // Mark as visited early
        temp.add(new Coordinate(row, col));

        dfs(grid2, row + 1, col, temp);
        dfs(grid2, row - 1, col, temp);
        dfs(grid2, row, col + 1, temp);
        dfs(grid2, row, col - 1, temp);
    }
    
    public boolean isValid(int[][] grid2, int row, int col) {
        return row >= 0 && row < grid2.length && col >= 0 && col < grid2[0].length;
    }
}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

