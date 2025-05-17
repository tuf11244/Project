/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 05/08/2025
 * https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/
 * @author parth
 */
public class FindMinimumTimeToReachLastRoomII {
    public static void main(String[] args) {
        
    }
    
    // right, left, up, down
    private static final int[][] directions = {
        {0, 1},
        {0, -1},
        {-1, 0},
        {1, 0}
    };

    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<NodeState> pq = new PriorityQueue<>();

        int rows = moveTime.length, cols = moveTime[0].length;
        int[][] minTime = new int[rows][cols];
        for (int[] row : minTime) Arrays.fill(row, Integer.MAX_VALUE);

        minTime[0][0] = 0;
        pq.add(new NodeState(0, 0, 0, 0));  // row, col, time, moves-so-far

        while (!pq.isEmpty()) {
            NodeState rem = pq.poll();

            if (rem.row == rows - 1 && rem.col == cols - 1) {
                return rem.time;            // reached goal
            }

            for (int[] dir : directions) {
                int newRow = rem.row + dir[0];
                int newCol = rem.col + dir[1];

                if (isValid(newRow, newCol, rows, cols)) {
                    int newTime = Math.max(rem.time, moveTime[newRow][newCol]);
                    newTime += (rem.moves % 2 == 0) ? 1 : 2;   // odd/even rule

                    if (newTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = newTime;
                        pq.add(new NodeState(newRow, newCol, newTime, rem.moves + 1));
                    }
                }
            }
        }
        return -1;   // unreachable
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /** Row-col position plus best-known arrival time and move count. */
    private static class NodeState implements Comparable<NodeState> {
        int row, col, time, moves;

        NodeState(int row, int col, int time, int moves) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.moves = moves;
        }

        @Override
        public int compareTo(NodeState other) {
            return Integer.compare(this.time, other.time);
        }
    }

}
