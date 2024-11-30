/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 11/28/2024 POTD
 * https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/
 * @author parth
 */
public class MinimumTimetoVisitaCellinGrid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int directions[][] = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int minimumTime(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        // If it's impossible to leave the first cell
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        PriorityQueue<Time> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new Time(0, 0, 0));

        while (!queue.isEmpty()) {
            Time rem = queue.poll();

            // If we reach the destination
            if (rem.row == rows - 1 && rem.col == cols - 1) {
                return rem.time;
            }

            if (visited[rem.row][rem.col]) continue;
            visited[rem.row][rem.col] = true;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = rem.row + directions[i][0];
                int newCol = rem.col + directions[i][1];

                if (isValid(grid, newRow, newCol) && !visited[newRow][newCol]) {
                    if (rem.time + 1 >= grid[newRow][newCol]) {
                        queue.add(new Time(newRow, newCol, rem.time + 1));
                    } else {
                       int diff = grid[newRow][newCol] - rem.time;

                       if(diff % 2 != 0){
                          queue.add(new Time(newRow, newCol,rem.time + diff));
                       }else{
                          queue.add(new Time(newRow,newCol,rem.time + diff + 1));
                       }
                    }
                }
            }
        }

        return -1;
    }

    public boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
    class Time implements Comparable<Time> {
        int row, col, time;

        public Time(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        public int compareTo(Time o) {
            return this.time - o.time;
        }
    }



