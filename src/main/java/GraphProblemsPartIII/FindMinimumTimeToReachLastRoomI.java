/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 05/07/2025
 * https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
 * @author parth
 */
public class FindMinimumTimeToReachLastRoomI {
    
    public static void main(String[] args) {
        
    }
    
    // 4-directional moves: right, left, up, down
    private static final int[][] directions = {
        {0, 1},
        {0, -1},
        {-1, 0},
        {1, 0}
    };

    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<CellState> pq = new PriorityQueue<>();

        int rows = moveTime.length, cols = moveTime[0].length;
        int[][] minTime = new int[rows][cols];
        for (int[] row : minTime) Arrays.fill(row, Integer.MAX_VALUE);

        minTime[0][0] = 0;                     // start cell
        pq.add(new CellState(0, 0, 0));

        while (!pq.isEmpty()) {
            CellState rem = pq.poll();

            // reached destination
            if (rem.row == rows - 1 && rem.col == cols - 1) {
                return rem.time;
            }

            // explore neighbors
            for (int[] dir : directions) {
                int newRow = rem.row + dir[0];
                int newCol = rem.col + dir[1];

                if (isValid(newRow, newCol, rows, cols)) {
                    int newTime = Math.max(rem.time, moveTime[newRow][newCol]) + 1;
                    if (newTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = newTime;
                        pq.add(new CellState(newRow, newCol, newTime));
                    }
                }
            }
        }
        return -1;  // unreachable
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    /** Helper class representing a grid cell and the best-known time to reach it. */
    private static class CellState implements Comparable<CellState> {
        int row, col, time;

        CellState(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(CellState other) {
            return Integer.compare(this.time, other.time);
        }
    }

    
}
